package com.umut.enjin.engine.rendering;

import com.umut.enjin.engine.core.Vector3f;

/**
 * Created by umutkoksaldi on 9/6/17.
 */
public class PointLight
{
    private BaseLight baseLight;
    private Vector3f position;
    private Attenuation attenuation;
    private float range;

    public PointLight(BaseLight baseLight, Attenuation attenuation, Vector3f position, float range) {
        this.baseLight = baseLight;
        this.attenuation = attenuation;
        this.position = position;
        this.range = range;
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

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }
}
