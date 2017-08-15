package com.umut.enjin;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class RenderUtil {

    public static void clearScreen() {
        // TODO: Stencil buffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public static void initGraphics() {
        glClearColor(0.5f, 0f, 0f, 0f);

        glFrontFace(GL_CW);
        glCullFace(GL_BACK);
        glEnable(GL_CULL_FACE);
        glEnable(GL_DEPTH_TEST);

        // TODO: Depth clamp

        glEnable(GL_FRAMEBUFFER_SRGB);
    }
}
