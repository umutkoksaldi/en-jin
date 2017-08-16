package com.umut.enjin;

public class Transform {

    private Vector3f translation;

    public Transform() {
        translation = new Vector3f(0, 0, 0);
    }

    public Vector3f getTranslation() {
        return translation;
    }

    public Matrix4f getTransformation() {
        Matrix4f trans = new Matrix4f().initTranslation(translation.getX(), translation.getY(), translation.getZ());

        return trans;
    }

    public void setTranslation(Vector3f translation) {
        this.translation = translation;
    }

    public void setTranslation(float x, float y, float z) {
        this.translation = new Vector3f(x,y,z);
    }
}
