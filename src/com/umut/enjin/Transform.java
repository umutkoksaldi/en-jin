package com.umut.enjin;

/* Wrapper transform class */
public class Transform {

    private Vector3f translation;

    public Transform() {
        translation = new Vector3f(0, 0, 0);
    }

    public Vector3f getTranslation() {
        return translation;
    }
    
    // The method is used to convert the Vector3f values stored inside this class 
    // into a Matrix4f in order to be compatible with OpenGL functions
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
