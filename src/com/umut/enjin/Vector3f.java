package com.umut.enjin;

import java.util.Vector;

public class Vector3f
{
    private float x;
    private float y;
    private float z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public float length() {
        return (float) Math.sqrt(x*x + y*y + z*z);
    }

    public float dot (Vector3f other) {
        return x * other.getX() + y * other.getY() + z * other.getZ();
    }

    public Vector3f cross(Vector3f other) {
        float x_ = y * other.getZ() - z * other.getY();
        float y_ = z * other.getX() - x * other.getZ();
        float z_ = x * other.getY() - y * other.getX();

        return new Vector3f(x_, y_, z_);
    }

    public Vector3f add (Vector3f other) {
        return new Vector3f(x + other.getX(), y + other.getY(), z + other.getZ());
    }

    public Vector3f add (float num) {
        return new Vector3f(x + num, y + num, z + num);
    }

    public Vector3f sub (Vector3f other) {
        return new Vector3f(x - other.getX(), y - other.getY(), z - other.getZ());
    }

    public Vector3f sub (float num) {
        return new Vector3f(x - num, y - num, z - num);
    }

    public Vector3f mul (Vector3f other) {
        return new Vector3f(x * other.getX(), y * other.getY(), z * other.getZ());
    }

    public Vector3f mul (float num) {
        return new Vector3f(x * num, y * num, z * num);
    }

    public Vector3f div (Vector3f other) {
        return new Vector3f(x / other.getX(), y / other.getY(), z / other.getZ());
    }

    public Vector3f div (float num) {
        return new Vector3f(x / num, y / num, z / num);
    }

    public Vector3f normalize() {
        float length = length();
        x /= length;
        y /= length;
        z /= length;

        return this;
    }
}
