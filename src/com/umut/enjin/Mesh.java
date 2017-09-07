package com.umut.enjin;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

public class Mesh
{
    // index buffer object
    private int ibo;
    // pointer to the mesh to be stored in opengl
    private int vbo;
    // number of floating point values in the stored mesh
    private int size;

    public Mesh() {
        vbo = glGenBuffers(); // initialize the pointer to the mesh
        ibo = glGenBuffers(); // initialize pointer for mesh face
        size = 0;
    }

    public void addVertices(Vertex[] vertices, int[] indices) {
        size = indices.length; // calculate vertex size from floating point values

        glBindBuffer(GL_ARRAY_BUFFER, vbo); // bind the buffer so it will be rendered

        // set the prepared data in a vertex array provided by our util class
        glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Util.createFlippedBuffer(indices), GL_STATIC_DRAW);
    }

    public void addVertices(Vertex[] vertices, int[] indices, boolean calcNormals) {
        if (calcNormals) {
            calcNormals(vertices, indices);
        }

        size = indices.length; // calculate vertex size from floating point values

        glBindBuffer(GL_ARRAY_BUFFER, vbo); // bind the buffer so it will be rendered

        // set the prepared data in a vertex array provided by our util class
        glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Util.createFlippedBuffer(indices), GL_STATIC_DRAW);
    }

    public void draw() {
        glEnableVertexAttribArray(0); // enable the vertex attributes for correct opengl interpretation
        glEnableVertexAttribArray(1);
        glEnableVertexAttribArray(2);

        glBindBuffer(GL_ARRAY_BUFFER, vbo); // bind the buffer so that it is rendered when render is called
        // set specs for the attributes of the vertices passed in
        glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE*4, 0);
        glVertexAttribPointer(1, 2, GL_FLOAT, false, Vertex.SIZE*4, 12);
        glVertexAttribPointer(2, 3, GL_FLOAT, false, Vertex.SIZE*4, 20);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES, size, GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);
        glDisableVertexAttribArray(2);
    }

    private void calcNormals(Vertex[] vertices, int[] indices) {
        // calculate the normals for each triangle and add an approximate normal to the
        // vectors making up the triangles
        for(int i = 0; i < indices.length; i+=3) {
            int i0 = indices[i];
            int i1 = indices[i+1];
            int i2 = indices[i+2];

            Vector3f v1 = vertices[i1].getPos().sub(vertices[i0].getPos());
            Vector3f v2 = vertices[i2].getPos().sub(vertices[i0].getPos());

            Vector3f normal = v1.cross(v2).normalize();

            vertices[i0].setNormal(vertices[i0].getNormal().add(normal));
            vertices[i1].setNormal(vertices[i1].getNormal().add(normal));
            vertices[i2].setNormal(vertices[i2].getNormal().add(normal));

        }
        // normalize the increased size resulting from adding vectors
        for(int i = 0; i < vertices.length; i++) {
            vertices[i].setNormal(vertices[i].getNormal().normalize());
        }
    }
}
