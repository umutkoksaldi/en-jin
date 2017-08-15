package com.umut.enjin;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

public class Mesh
{
    // pointer to the mesh to be stored in opengl
    private int vbo;
    // number of floating point values in the stored mesh
    private int size;

    public Mesh() {
        vbo = glGenBuffers(); // initialize the pointer to the mesh
        size = 0;
    }

    public void addVertices(Vertex[] vertices) {
        size = vertices.length; // calculate vertex size from floating point values

        glBindBuffer(GL_ARRAY_BUFFER, vbo); // bind the buffer so it will be rendered

        // set the prepared data in a vertex array provided by our util class
        glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);
    }

    public void draw() {
        glEnableVertexAttribArray(0); // enable the vertex attributes for correct opengl interpretation

        glBindBuffer(GL_ARRAY_BUFFER, vbo); // bind the buffer so that it is rendered when render is called
        // set specs for the attributes of the vertices passed in
        glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE*4, 0);
        // execute the draw operation
        glDrawArrays(GL_TRIANGLES, 0, size);

        glDisableVertexAttribArray(0);
    }
}
