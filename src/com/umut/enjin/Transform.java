package com.umut.enjin;

/* Wrapper transform class */
public class Transform {

    private Vector3f translation;
    private Vector3f rotation;
    private Vector3f scale;

    public Vector3f getScale() {
        return scale;
    }

    public void setScale(Vector3f scale) {
        this.scale = scale;
    }

    public void setScale(float x, float y, float z) {
        this.scale = new Vector3f(x, y, z);
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }

    public void setRotation(float x, float y, float z) {
        this.rotation = new Vector3f(x, y, z);
    }

    public Transform() {
        translation = new Vector3f(0, 0, 0);
        rotation = new Vector3f(0, 0, 0);
        scale = new Vector3f(1, 1, 1);
    }

    public Vector3f getTranslation() {
        return translation;
    }
    
    // The method is used to convert the Vector3f values stored inside this class 
    // into a Matrix4f in order to be compatible with OpenGL functions
    public Matrix4f getTransformation() {
        Matrix4f transformationMatrix = new Matrix4f().initTranslation(translation.getX(), translation.getY(), translation.getZ());
        Matrix4f rotationMatrix = new Matrix4f().InitRotation(rotation.getX(), rotation.getY(), rotation.getZ());
        Matrix4f scaleMatrix = new Matrix4f().initScale(scale.getX(), scale.getY(), scale.getZ());

        return transformationMatrix.mul(rotationMatrix.mul(scaleMatrix));
    }

    public void setTranslation(Vector3f translation) {
        this.translation = translation;
    }

    public void setTranslation(float x, float y, float z) {
        this.translation = new Vector3f(x,y,z);
    }

}
