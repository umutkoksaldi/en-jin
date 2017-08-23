package com.umut.enjin;

/**
 * Created by umutm on 8/22/2017.
 */
public class BasicShader extends Shader
{

    private static final BasicShader instance = new BasicShader();

    public static BasicShader getInstance() {
        return  instance;
    }

    private BasicShader() {
        super();

        addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
        addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
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
