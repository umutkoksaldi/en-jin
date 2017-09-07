package com.umut.enjin.game;

import com.umut.enjin.engine.core.GameComponent;
import com.umut.enjin.engine.core.Transform;
import com.umut.enjin.engine.rendering.BasicShader;
import com.umut.enjin.engine.rendering.Material;
import com.umut.enjin.engine.rendering.Mesh;
import com.umut.enjin.engine.rendering.Shader;

/**
 * Created by umutkoksaldi on 9/7/17.
 */
public class MeshRenderer extends GameComponent {

    private Mesh mesh;
    private Material material;

    public MeshRenderer(Mesh mesh, Material material) {
        this.mesh = mesh;
        this.material = material;
    }

    public void render(Transform transform) {
        Shader shader = BasicShader.getInstance();

        shader.bind();
        shader.updateUniforms(transform.getTransformation(), transform.getProjectedTranformation(), material);
        mesh.draw();
    }

}
