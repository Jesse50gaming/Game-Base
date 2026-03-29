package com.game.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.HashSet;

public class KeyHandler implements KeyListener  {

    public HashSet<Integer> pressedKeys;

    public KeyHandler() {
        pressedKeys = new HashSet<>();
    }

    public void update() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        pressedKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        
        
        pressedKeys.remove(e.getKeyCode());
    }

    public boolean isPressed(Integer keyCode) {
        if(pressedKeys.isEmpty()){ return false;}
        if (pressedKeys.contains(keyCode)){ return true;}
        return false;
    }

}
