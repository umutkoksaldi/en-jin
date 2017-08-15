package com.umut.enjin;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class RenderUtil {

    public static void clearScreen() {
        // TODO: Stencil buffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the screen
    }

    public static void initGraphics() {
        glClearColor(0.5f, 0f, 0f, 0f); // set the clear colors bits

        glFrontFace(GL_CW); // determine frontface
        glCullFace(GL_BACK);
        glEnable(GL_CULL_FACE); // enable object culling
        glEnable(GL_DEPTH_TEST); // depth aware drawing

        // TODO: Depth clamp

        glEnable(GL_FRAMEBUFFER_SRGB); // for auto gamma correction
    }
}
