package com.umut.enjin;

import java.util.Vector;

public class Vector2f {

    private float x;
    private float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f abs() {return new Vector2f(Math.abs(getX()),Math.abs(getY()));}

    public float length() {
        return (float) Math.sqrt(x*x + y*y);
    }

    public float dot (Vector2f other) {
        return x * other.getX() + y * other.getY();
    }

    public Vector2f normalize() {
        float length = length();
        x /= length;
        y /= length;

        return this;
    }

    public Vector2f rotate(float angle) {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        return new Vector2f((float)(x * cos - y * sin), (float) (x * sin + y * cos));
    }

    public Vector2f add (Vector2f other) {
        return new Vector2f(x + other.getX(), y + other.getY());
    }

    public Vector2f add (float num) {
        return new Vector2f(x + num, y + num);
    }

    public Vector2f sub (Vector2f other) {
        return new Vector2f(x - other.getX(), y - other.getY());
    }

    public Vector2f sub (float num) {
        return new Vector2f(x - num, y - num);
    }

    public Vector2f mul (Vector2f other) {
        return new Vector2f(x * other.getX(), y * other.getY());
    }

    public Vector2f mul (float num) {
        return new Vector2f(x * num, y * num);
    }

    public Vector2f div (Vector2f other) {
        return new Vector2f(x / other.getX(), y / other.getY());
    }

    public Vector2f div (float num) {
        return new Vector2f(x / num, y / num);
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

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
