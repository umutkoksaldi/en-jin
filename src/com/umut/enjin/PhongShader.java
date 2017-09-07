package com.umut.enjin;

/**
 * Created by umutm on 8/23/2017.
 */
public class PhongShader extends Shader {

    private static final int MAX_POINT_LIGHTS = 4;
    private static final int MAX_SPOT_LIGHTS = 4;

    private static final PhongShader instance = new PhongShader();

    public static PhongShader getInstance() {
        return instance;
    }

    private static Vector3f ambientLight = new Vector3f(1,1,1);

    private static DirectionalLight directionalLight = new DirectionalLight(new BaseLight(new Vector3f(1,1,1), 0f),
                                                                            new Vector3f(0,0,0));
    private static PointLight[] pointLights = new PointLight[MAX_POINT_LIGHTS];

    private static SpotLight[] spotLights = new SpotLight[MAX_SPOT_LIGHTS];

    public static Vector3f getAmbientLight() {
        return ambientLight;
    }

    public static void setAmbientLight(Vector3f ambientLight) {
        PhongShader.ambientLight = ambientLight;
    }

    private PhongShader() {
        super();

        addVertexShader(ResourceLoader.loadShader("phongVertex.vs"));
        addFragmentShader(ResourceLoader.loadShader("phongFragment.fs"));
        compileShader();

        addUniform("transform");
        addUniform("transformProjected");
        addUniform("baseColor");

        addUniform("ambientLight");

        addUniform("directionalLight.base.color");
        addUniform("directionalLight.base.intensity");
        addUniform("directionalLight.direction");

        addUniform("specularIntensity");
        addUniform("specularPower");
        addUniform("eyePos");

        for (int i = 0; i < MAX_POINT_LIGHTS; i++) {
            addUniform("pointLights[" + i + "].base.color");
            addUniform("pointLights[" + i + "].base.intensity");
            addUniform("pointLights[" + i + "].atten.constant");
            addUniform("pointLights[" + i + "].atten.linear");
            addUniform("pointLights[" + i + "].atten.exponent");
            addUniform("pointLights[" + i + "].position");
            addUniform("pointLights[" + i + "].range");
        }

        for (int i = 0; i < MAX_SPOT_LIGHTS; i++) {
            addUniform("spotLights[" + i + "].pointlight.base.color");
            addUniform("spotLights[" + i + "].pointlight.base.intensity");
            addUniform("spotLights[" + i + "].pointlight.atten.constant");
            addUniform("spotLights[" + i + "].pointlight.atten.linear");
            addUniform("spotLights[" + i + "].pointlight.atten.exponent");
            addUniform("spotLights[" + i + "].pointlight.position");
            addUniform("spotLights[" + i + "].pointlight.range");

            addUniform("spotLights[" + i + "].direction");
            addUniform("spotLights[" + i + "].cutoff");
        }
    }

    public void updateUniforms(Matrix4f worldMatrix, Matrix4f projectedMatrix, Material material) {

        if(material.getTexture() != null)
            material.getTexture().bind();
        else
            RenderUtil.unbindTextures();

        setUniform("transformProjected", projectedMatrix);
        setUniform("transform", worldMatrix);
        setUniform("color", material.getColor());

        setUniform("ambientLight", ambientLight);
        setUniform("directionalLight", directionalLight);

        setUniformf("specularIntensity", material.getSpecularIntensity());
        setUniformf("specularPower", material.getSpecularPower());

        setUniform("eyePos", Transform.getCamera().getPos());

        for(int i = 0; i < pointLights.length; i++) {
            setUniform("pointLights[" + i + "]", pointLights[i]);
        }

        for(int i = 0; i < spotLights.length; i++) {
            setUniform("spotLights[" + i + "]", spotLights[i]);
        }
    }

    public void setUniform(String uniformName, PointLight pointLight) {
        setUniform(uniformName + ".base", pointLight.getBaseLight());
        setUniformf(uniformName + ".atten.constant", pointLight.getAttenuation().getConstant());
        setUniformf(uniformName + ".atten.exponent", pointLight.getAttenuation().getExponent());
        setUniformf(uniformName + ".atten.linear", pointLight.getAttenuation().getLinear());
        setUniform(uniformName + ".position", pointLight.getPosition());
        setUniformf(uniformName + ".range", pointLight.getRange());
    }

    public void setUniform(String uniformName, SpotLight spotLight) {
        setUniform(uniformName + ".pointLight", spotLight.getPointLight());
        setUniform(uniformName + ".direction", spotLight.getDirection());
        setUniformf(uniformName + ".cutoff", spotLight.getCutoff());
    }

    public static void setPointLight(PointLight[] pointLights) {
        if (pointLights.length > MAX_POINT_LIGHTS) {
            System.err.println("Error: You passed in too many point lights. Max allowed is: " + MAX_POINT_LIGHTS);
            new Exception().printStackTrace();
            System.exit(1);
        }

        PhongShader.pointLights = pointLights;
    }

    public static void setSpotLight(SpotLight[] spotLights) {
        if (spotLights.length > MAX_SPOT_LIGHTS) {
            System.err.println("Error: You passed in too many spot lights. Max allowed is: " + MAX_SPOT_LIGHTS);
            new Exception().printStackTrace();
            System.exit(1);
        }

        PhongShader.spotLights = spotLights;
    }

    public void setUniform(String uniformName, BaseLight baseLight) {
        setUniform(uniformName + ".color", baseLight.getColor());
        setUniformf(uniformName + ".intensity", baseLight.getIntensity());
    }

    public void setUniform(String uniformName, DirectionalLight directionalLight) {
        setUniform(uniformName + ".base", directionalLight.getBase());
        setUniform(uniformName + ".direction", directionalLight.getDirection());
    }

    public static DirectionalLight getDirectionalLight() {
        return directionalLight;
    }

    public static void setDirectionalLight(DirectionalLight directionalLight) {
        PhongShader.directionalLight = directionalLight;
    }
}
