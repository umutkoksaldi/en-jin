package com.umut.enjin;

import java.util.HashMap;
import java.util.Vector;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;

public class Shader
{
    // pointer to the program for the shaders
    private int program;
    private HashMap<String, Integer> uniforms;

    public Shader() {
        program = glCreateProgram(); // get pointer from opengl
        uniforms = new HashMap<String, Integer>();

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

    public void addUniform(String uniform) {
        int uniformLocation = glGetUniformLocation(program, uniform);

        if (uniformLocation == 0xFFFFFF) {
            System.err.println("Error: Could not find uniform: " + uniform);
            new Exception().printStackTrace();
            System.exit(1);
        }

        uniforms.put(uniform, uniformLocation);
    }

    public void setUniformi(String uniformName, int value) {
        glUniform1i(uniforms.get(uniformName), value);
    }

    public void setUniformf(String uniformName, float value) {
        glUniform1f(uniforms.get(uniformName), value);
    }

    public void setUniform(String uniformName, Vector3f value) {
        glUniform3f(uniforms.get(uniformName), value.getX(), value.getY(), value.getZ());
    }

    public void setUniform(String uniformName, Matrix4f value) {
        glUniformMatrix4(uniforms.get(uniformName), true, Util.createFlippedBuffer(value));
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

    public void updateUniforms(Matrix4f worldMatrix, Matrix4f projectedMatrix, Material material) {

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
