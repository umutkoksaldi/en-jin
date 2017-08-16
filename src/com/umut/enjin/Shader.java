package com.umut.enjin;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;

public class Shader
{
    // pointer to the program for the shaders
    private int program;

    public Shader() {
        program = glCreateProgram(); // get pointer from opengl

        if (program == 0) {
            System.err.println("Shader creation failed: Could not find valid memory location");
            System.exit(1);
        }
    }
    // Wrapper methods for special shader addition
    public void addVertexShader(String text) {
        addProgram(text, GL_VERTEX_SHADER);
    }

    public void addGeometryShader(String text) {
        addProgram(text, GL_GEOMETRY_SHADER);
    }

    public void addFragmentShader(String text) {
        addProgram(text, GL_FRAGMENT_SHADER);
    }

    // compile the stored shader
    public void compileShader() {
        glLinkProgram(program); // link the program to the processor through

        if(glGetProgram(program, GL_LINK_STATUS) == 0) {
            System.err.println(glGetShaderInfoLog(program, 1024));
            System.exit(1);
        }

        glValidateProgram(program); // validate the status to prevent malfunctioning

        if(glGetProgram(program, GL_VALIDATE_STATUS) == 0) {
            System.err.println(glGetShaderInfoLog(program, 1024));
            System.exit(1);
        }
    }

    public void bind() {
        glUseProgram(program);  // bind the program so that shaders are actually used when the game runs
    }

    private void addProgram(String text, int type) {
        int shader = glCreateShader(type);  // get pointer for the new shader
        if (shader == 0) {
            System.err.println("Shader creation failed: Could not find valid memory location when adding shader");
            System.exit(1);
        }

        glShaderSource(shader, text); // set the source from the text provided by the ResourceLoader class
        glCompileShader(shader); // compile the attached shader

        if(glGetShader(shader, GL_COMPILE_STATUS) == 0) {
            System.err.println(glGetShaderInfoLog(shader, 1024));
            System.exit(1);
        }

        glAttachShader(program, shader); // attach the newly created shader to the main program
    }
}
