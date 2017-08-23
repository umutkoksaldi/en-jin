package com.umut.enjin;

/**
 * Created by umutm on 8/23/2017.
 */
public class PhongShader extends Shader {

    private static final PhongShader instance = new PhongShader();

    public static PhongShader getInstance() {
        return instance;
    }

    private PhongShader() {
        super();

        addVertexShader(ResourceLoader.loadShader("phongVertex.vs"));
        addFragmentShader(ResourceLoader.loadShader("phongFragment.fs"));
        compileShader();

        addUniform("transform");
        addUniform("color");
    }

    public void updateUniforms(Matrix4f worldMatrix, Matrix4f projectedMatrix, Material material) {

        if(material.getTexture() != null)
            material.getTexture().bind();
        else
            RenderUtil.unbindTextures();

        setUniform("transform", projectedMatrix);
        setUniform("color", material.getColor());
    }

}
