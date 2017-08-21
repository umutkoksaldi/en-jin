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

    public void draw() {
        glEnableVertexAttribArray(0); // enable the vertex attributes for correct opengl interpretation
        glEnableVertexAttribArray(1);

        glBindBuffer(GL_ARRAY_BUFFER, vbo); // bind the buffer so that it is rendered when render is called
        // set specs for the attributes of the vertices passed in
        glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE*4, 0);
        glVertexAttribPointer(1, 2, GL_FLOAT, false, Vertex.SIZE*4, 12);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES, size, GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
    }
}
