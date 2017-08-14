package com.umut.enjin;

public class Matrix4f {
    private float[][] m;

    public Matrix4f() {
        m = new float[4][4];
    }

    public Matrix4f initIdentity() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
            {
                if (i == j) {
                    m[i][j] = 1;
                }
                else {
                    m[i][j] = 0;
                }
            }
        }
        return this;
    }

    public Matrix4f mul(Matrix4f other) {
        Matrix4f result = new Matrix4f();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result.set(i, j, m[i][0] * other.get(0, j) +
                        m[i][1] * other.get(1, j) +
                        m[i][2] * other.get(2, j) +
                        m[i][3] * other.get(3, j));
            }
        }

        return result;
    }

    public float[][] getM() {
        return m;
    }

    public float get(int x, int y) {
        return m[x][y];
    }

    public void set(int x, int y, float value) {
        m[x][y] = value;
    }

    public void setM(float[][] m) {
        this.m = m;
    }
}
