package com.umut.enjin;

/**
 * Created by umutkoksaldi on 9/6/17.
 */
public class Attenuation
{
    private float constant;
    private float linear;
    private float exponent;

    public Attenuation(float constant, float linear, float exponent) {
        this.constant = constant;
        this.exponent = exponent;
        this.linear = linear;
    }

    public float getConstant() {
        return constant;
    }

    public void setConstant(float constant) {
        this.constant = constant;
    }

    public float getLinear() {
        return linear;
    }

    public void setLinear(float linear) {
        this.linear = linear;
    }

    public float getExponent() {
        return exponent;
    }

    public void setExponent(float exponent) {
        this.exponent = exponent;
    }
}
