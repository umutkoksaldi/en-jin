package com.umut.enjin;

import jdk.management.resource.ResourceContext;
import org.lwjgl.input.Keyboard;

import javax.annotation.Resource;

public class Game {

    private Mesh mesh;
    private Shader shader;
    private Transform transform;
    private Camera camera;

    public Game() {
        mesh = ResourceLoader.loadMesh("cube.obj");

        shader = new Shader();
        camera = new Camera();

        transform = new Transform();
        transform.setProjection(70f, MainComponent.WIDTH, MainComponent.HEIGHT, 0.1f, 1000f);
        Transform.setCamera(camera);

        shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
        shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
        shader.compileShader();

        shader.addUniform("transform");
    }

    public void input() {
        camera.input();
    }

    float temp = 0.0f;

    public void update() {
        temp += Time.getDelta();

        float sinTemp = (float) Math.sin(temp);

        transform.setTranslation(sinTemp, 0, 5);
        transform.setRotation(0, sinTemp * 180, 0);
        transform.setScale(0.7f, 0.7f, 0.7f);
    }

    public void render() {
        shader.bind();
        shader.setUniform("transform", transform.getProjectedTranformation());
        mesh.draw();
    }
}
