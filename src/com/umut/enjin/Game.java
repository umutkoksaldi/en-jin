package com.umut.enjin;

import jdk.management.resource.ResourceContext;
import org.lwjgl.input.Keyboard;

import javax.annotation.Resource;
import java.awt.*;

public class Game {

    private Mesh mesh;
    private Shader shader;
    private Transform transform;
    private Camera camera;
    private Material material;

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

        mesh.addVertices(vertices, indices, true);

        material = new Material(ResourceLoader.loadTexture("test.png"), new Vector3f(1, 1, 1));
        shader = PhongShader.getInstance();
        camera = new Camera();

        transform = new Transform();
        transform.setProjection(70f, MainComponent.WIDTH, MainComponent.HEIGHT, 0.1f, 1000f);
        Transform.setCamera(camera);
        PhongShader.setAmbientLight(new Vector3f(1,1,1));
        PhongShader.setDirectionalLight(new DirectionalLight(new BaseLight(new Vector3f(1,1,1), 0.8f),
                new Vector3f(1,1,1)));

        PointLight pLight1 = new PointLight(new BaseLight(new Vector3f(1,0,0), 0.8f), new Attenuation(0, 0, 1), new Vector3f(-2, 0, 3));
        PointLight pLight2 = new PointLight(new BaseLight(new Vector3f(0,0,1), 0.8f), new Attenuation(0, 0, 1), new Vector3f(2, 0, 7));

        PhongShader.setPointLight(new PointLight[]{pLight1, pLight2});
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
        shader.updateUniforms(transform.getTransformation(), transform.getProjectedTranformation(), material);
        mesh.draw();
    }
}
