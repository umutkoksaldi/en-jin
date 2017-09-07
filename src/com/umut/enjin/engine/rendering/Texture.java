package com.umut.enjin.engine.rendering;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by umutm on 8/22/2017.
 */
public class Texture {

    private int id;

    public Texture(int id) {
        this.id = id;
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
