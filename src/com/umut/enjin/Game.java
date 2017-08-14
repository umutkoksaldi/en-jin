package com.umut.enjin;

import org.lwjgl.input.Keyboard;

public class Game {

    public Game() {

    }

    public void input() {
        if(Input.getKeyDown(Keyboard.KEY_UP))
            System.out.println("We've just pressed up");
        if(Input.getKeyUp(Keyboard.KEY_UP))
            System.out.println("We've just released up");

        if(Input.getMouseDown(1))
            System.out.println("We just pressed right click");
        if(Input.getMouseUp(1))
            System.out.println("We just released right click");
    }

    public void update() {

    }

    public void render() {

    }
}
