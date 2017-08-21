package com.umut.enjin;

import jdk.management.resource.ResourceContext;
import org.lwjgl.input.Keyboard;

import javax.annotation.Resource;

public class Game {

    private Mesh mesh;
    private Shader shader;
    private Transform transform;
    private Camera camera;
    private Texture texture;

    public Game() {
        // mesh = ResourceLoader.loadMesh("cube.obj");
        mesh = new Mesh();
        Vertex[] vertices = new Vertex[] {  new Vertex(new Vector3f(-1, -1, 0), new Vector2f(0,0)),
                                            new Vertex(new Vector3f(0, 1, 0), new Vector2f(0.5f,0)),
                                            new Vertex(new Vector3f(1, -1, 0), new Vector2f(1.0f,0)),
                                            new Vertex(new Vector3f(0, -1, 1), new Vector2f(0,0.5f))};

        int[] indices = new int[] {3,1,0,
                                    2,1,3,
                                    0,1,2,
                                    0,2,3};

        mesh.addVertices(vertices, indices);

        shader = new Shader();
        camera = new Camera();
        texture = ResourceLoader.loadTexture("test.png");

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
        texture.bind();
        mesh.draw();
    }
}
