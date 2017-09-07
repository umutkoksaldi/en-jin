package com.umut.enjin.engine.rendering;

import com.umut.enjin.engine.core.Vector3f;

/**
 * Created by umutkoksaldi on 9/6/17.
 */
public class DirectionalLight
{
    private BaseLight base;
    private Vector3f direction;

    public DirectionalLight(BaseLight base, Vector3f direction) {
        this.base = base;
        this.direction = direction.normalize();
    }

    public BaseLight getBase() {
        return base;
    }

    public void setBase(BaseLight base) {
        this.base = base;
    }

    public Vector3f getDirection() {
        return direction;
    }

    public void setDirection(Vector3f direction) {
        this.direction = direction;
    }
}
