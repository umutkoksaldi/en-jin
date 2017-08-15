package com.umut.enjin;

import org.lwjgl.opengl.Display;

public class MainComponent {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "En'jin";
    public static final double FRAME_CAP = 5000.0;

    private Game game;

    private boolean isRunning;

    public MainComponent(){
        System.out.println(RenderUtil.getOpenGLVersion());
        RenderUtil.initGraphics();
        isRunning = false;
        game = new Game();
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

        boolean render = false;
        int frames = 0;
        long frameCounter = 0L;

        double frameTime = 1.0 / FRAME_CAP;

        long lastTime = Time.getTime();
        double unprocessedTime = 0;

        while(isRunning) {
            // calculate the render time of the last frame
            long startTime = Time.getTime();
            long passedTime = startTime - lastTime;
            lastTime = startTime;

            // calculate the time that needs to be processed - displayed
            unprocessedTime += passedTime / (double) Time.SECOND;
            // process loop
            while(unprocessedTime > frameTime) {
                render = true;

                unprocessedTime -= frameTime;
                frameCounter += passedTime;     // update frame time passed

                if (Window.isCloseRequested())
                    stop();

                // Update game
                Input.update();

                Time.setDelta(frameTime); // set Time.deltaTime

                game.input();
                game.update();

                // print out the frame rate after each second of rendering
                if(frameCounter >= Time.SECOND) {
                    System.out.println(frames);
                    frames = 0;
                    frameCounter = 0;
                }
            }
            if(render) {
                render();
                frames++;
            }
            else {
                try {
                    Thread.sleep(1); // if not rendering, let the thread sleep
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        cleanUp();
    }

    private void render(){
        RenderUtil.clearScreen();
        game.render();
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

