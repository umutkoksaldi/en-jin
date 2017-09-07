package com.umut.enjin;

/**
 * Created by umutkoksaldi on 9/6/17.
 */
public class PointLight
{
    private BaseLight baseLight;
    private Vector3f position;
    private Attenuation attenuation;

    public PointLight(BaseLight baseLight, Attenuation attenuation, Vector3f position) {
        this.baseLight = baseLight;
        this.attenuation = attenuation;
        this.position = position;
    }

    public BaseLight getBaseLight() {
        return baseLight;
    }

    public void setBaseLight(BaseLight baseLight) {
        this.baseLight = baseLight;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Attenuation getAttenuation() {
        return attenuation;
    }

    public void setAttenuation(Attenuation attenuation) {
        this.attenuation = attenuation;
    }
}
