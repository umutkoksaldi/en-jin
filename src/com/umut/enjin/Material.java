package com.umut.enjin;

/**
 * Created by umutm on 8/22/2017.
 */
public class Material {

    private Texture texture;
    private Vector3f color;
    private float specularIntensity;
    private float specularPower;

    public Material(Texture texture, Vector3f color) {
        this.texture = texture;
        this.color = color;
        specularIntensity = 2;
        specularPower = 32;
    }

    public Material(Texture texture, Vector3f color, float specularIntensity, float specularPower) {
        this.texture = texture;
        this.color = color;
        this.specularPower = specularPower;
        this.specularIntensity = specularIntensity;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Vector3f getColor() {
        return color;
    }

    public void setColor(Vector3f color) {
        this.color = color;
    }

    public float getSpecularIntensity() {
        return specularIntensity;
    }

    public void setSpecularIntensity(float specularIntensity) {
        this.specularIntensity = specularIntensity;
    }

    public float getSpecularPower() {
        return specularPower;
    }

    public void setSpecularPower(float specularPower) {
        this.specularPower = specularPower;
    }
}
