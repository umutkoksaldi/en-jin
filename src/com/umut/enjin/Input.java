package com.umut.enjin;

import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

public class Input {

    public static final int NUM_KEYCODES = 256;
    private static ArrayList<Integer> currentKeys = new ArrayList<>();
    private static ArrayList<Integer> downKeys = new ArrayList<>();
    private static ArrayList<Integer> upKeys = new ArrayList<>();


    public static void update() {

        upKeys.clear();

        for (int i = 0; i < NUM_KEYCODES; i++) {
            if(!getKey(i) && currentKeys.contains(i)) {
                upKeys.add(i);
            }
        }

        downKeys.clear();

        for (int i = 0; i < NUM_KEYCODES; i++) {
            if(getKey(i) && !currentKeys.contains(i)) {
                downKeys.add(i);
            }
        }

        currentKeys.clear();

        for (int i = 0; i < NUM_KEYCODES; i++) {
            if(getKey(i)) {
                currentKeys.add(i);
            }
        }
    }

    public static boolean getKey(int keyCode) {
        return Keyboard.isKeyDown(keyCode);
    }

    public static boolean getKeyDown(int keyCode) {
        return downKeys.contains(keyCode);
    }

    public static boolean getKeyUp(int keyCode) {
        return upKeys.contains(keyCode);
    }

}
