package com.umut.enjin;

/*
Wrapper class to hold our vertex elements in order to be easily incorporated into the meshes
 */
public class Vertex
{
    private Vector3f pos;
    private Vector2f texCoord;

    public static final int SIZE = 5;

    public Vector3f getPos() {
        return pos;
    }

    public void setPos(Vector3f pos) {
        this.pos = pos;
    }

    public Vertex(Vector3f pos) {
        this.pos = pos;
        texCoord = new Vector2f(0,0);
    }

    public Vertex(Vector3f pos, Vector2f texCoord) {
        this.pos = pos;
        this.texCoord = texCoord;
    }

    public Vector2f getTexCoord() {
        return texCoord;
    }

    public void setTexCoord(Vector2f texCoord) {
        this.texCoord = texCoord;
    }
}
