package com.umut.enjin;

import org.lwjgl.opengl.Display;

public class MainComponent {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "En'jin";

    private boolean isRunning;

    public MainComponent(){
        isRunning = false;
    }

    public void start(){
        if (isRunning) {
            return;
        }

        run();
    }

    public void stop(){
        if(!isRunning) {
            return;
        }

        isRunning = false;
    }

    private void run(){
        isRunning = true;

        while(isRunning) {
            if (Window.isCloseRequested())
                stop();

            render();
        }

        cleanUp();
    }

    private void render(){
        Window.render();
    }

    private void cleanUp(){
        Window.dispose();
    }

    public static void main(String[] args) {
        Window.createWindow(WIDTH, HEIGHT, TITLE);
        MainComponent game = new MainComponent();
        game.start();
    }


}

