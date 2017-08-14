package com.umut.enjin;

import java.util.Vector;

public class Quaternion {
    private float x;
    private float y;
    private float z;
    private float w;

    public Quaternion(float x, float y, float z, float w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public float length() {
        return (float) Math.sqrt(x * x + y*y + z*z + w*w);
    }

    public Quaternion normalize() {
        float length = length();
        x /= length;
        y /= length;
        z /= length;
        w /= length;

        return this;
    }

    public Quaternion conjugate() {
        return new Quaternion(-x, -y, -z, w);
    }

    public Quaternion mul(Quaternion other) {
        float w_ = w*other.w - x*other.x - y*other.y - z*other.z;
        float x_ = x*other.w + w*other.x + y*other.z - z*other.y;
        float y_ = y*other.w + w*other.y + z*other.x - x*other.z;
        float z_ = z*other.w + w*other.z + x*other.y - y*other.x;

        return new Quaternion(x_, y_, z_, w_);
    }

    public Quaternion mul (Vector3f other) {
        float w_ = -x*other.getX() - y*other.getY() - z*other.getZ();
        float x_ = w* other.getX() + y*other.getZ() - z* other.getY();
        float y_ = w* other.getY() + z*other.getX() - x* other.getZ();
        float z_ = w*other.getZ() + x*other.getY() - y*other.getZ();

        return new Quaternion(x_, y_, z_, w_);
    }
}
