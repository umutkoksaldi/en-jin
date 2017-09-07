package com.umut.enjin.engine.rendering;

import com.umut.enjin.engine.core.Vector2f;
import com.umut.enjin.engine.core.Vector3f;

/*
Wrapper class to hold our vertex elements in order to be easily incorporated into the meshes
 */
public class Vertex
{
    private Vector3f pos;
    private Vector2f texCoord;
    private Vector3f normal;

    public static final int SIZE = 8;

    public Vector3f getPos() {
        return pos;
    }

    public void setPos(Vector3f pos) {
        this.pos = pos;
    }

    public Vertex(Vector3f pos) {
        this.pos = pos;
        texCoord = new Vector2f(0,0);
        normal = new Vector3f(0,0,0);
    }

    public Vertex(Vector3f pos, Vector2f texCoord) {
        this(pos, texCoord, new Vector3f(0,0,0));
    }

    public Vertex(Vector3f pos, Vector2f texCoord, Vector3f normal) {
        this.pos = pos;
        this.texCoord = texCoord;
        this.normal = normal;
    }

    public Vector2f getTexCoord() {
        return texCoord;
    }

    public void setTexCoord(Vector2f texCoord) {
        this.texCoord = texCoord;
    }

    public Vector3f getNormal() {
        return normal;
    }

    public void setNormal(Vector3f normal) {
        this.normal = normal;
    }
}
