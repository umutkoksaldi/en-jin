package com.umut.enjin.engine.core;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL32.*;

public class RenderUtil {

    public static void clearScreen() {
        // TODO: Stencil buffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the screen
    }

    public static void setClearColor(Vector3f color) {
        glClearColor(color.getX(), color.getY(), color.getZ(), 1.0f);
    }

    public static void setTextures(boolean enabled) {
        if (enabled)
            glEnable(GL_TEXTURE_2D);
        else
            glDisable(GL_TEXTURE_2D);
    }

    public static void initGraphics() {
        glClearColor(0f, 0f, 0f, 0f); // set the clear colors bits

        glFrontFace(GL_CW); // determine frontface
        glCullFace(GL_BACK);
        glEnable(GL_CULL_FACE); // enable object culling
        glEnable(GL_DEPTH_TEST); // depth aware drawing

        glEnable(GL_DEPTH_CLAMP);

        glEnable(GL_TEXTURE_2D);

    }

    public static void unbindTextures() {
        glBindTexture(GL_TEXTURE_2D, 0);
    }

    public static String getOpenGLVersion() {
        return glGetString(GL_VERSION);
    }
}
