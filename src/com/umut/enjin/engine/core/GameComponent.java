package com.umut.enjin.engine.core;

/**
 * Created by umutkoksaldi on 9/7/17.
 */
public abstract class GameComponent {

    public void init(Transform transform){}
    public void input(Transform transform){}
    public void update(Transform transform){}

    public void render(Transform transform){}

}
