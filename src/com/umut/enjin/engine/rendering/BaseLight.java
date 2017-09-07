package com.umut.enjin.engine.rendering;

import com.umut.enjin.engine.core.Vector3f;

/**
 * Created by umutkoksaldi on 9/6/17.
 */
public class BaseLight
{
    private Vector3f color;
    private float intensity;

    public BaseLight(Vector3f color, float intensity) {
        this.color = color;
        this.intensity = intensity;
    }

    public Vector3f getColor() {
        return color;
    }

    public void setColor(Vector3f color) {
        this.color = color;
    }

    public float getIntensity() {
        return intensity;
    }

    public void setIntensity(float intensity) {
        this.intensity = intensity;
    }
}
