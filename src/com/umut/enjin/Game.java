package com.umut.enjin;

import org.lwjgl.input.Keyboard;

import javax.annotation.Resource;

public class Game {

    private Mesh mesh;
    private Shader shader;

    public Game() {
        mesh = new Mesh();
        Vertex[] data = new Vertex[] {new Vertex(new Vector3f(-1,-1,0)),
                                        new Vertex(new Vector3f(0,1,0)),
                                        new Vertex(new Vector3f(1,-1,0))
                                        };
        mesh.addVertices(data);
        shader = new Shader();

        shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
        shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
        shader.compileShader();
    }

    public void input() {
        if(Input.getKeyDown(Keyboard.KEY_UP))
            System.out.println("We've just pressed up");
        if(Input.getKeyUp(Keyboard.KEY_UP))
            System.out.println("We've just released up");

        if(Input.getMouseDown(1))
            System.out.println("We just pressed right click");
        if(Input.getMouseUp(1))
            System.out.println("We just released right click");
    }

    public void update() {

    }

    public void render() {
        shader.bind();
        mesh.draw();
    }
}
