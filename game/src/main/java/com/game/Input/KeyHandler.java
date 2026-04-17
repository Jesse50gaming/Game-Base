package com.game.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.HashSet;

public class KeyHandler implements KeyListener  {

    //hashset so there are no duplicates
    public HashSet<Integer> pressedKeys;

    public KeyHandler() {
        pressedKeys = new HashSet<>();
    }

    public void update() {
        //updated every frame
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       //when a key is pressed, add it to the set of pressed keys
        pressedKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //removes the key from the set of pressed keys when it is released
        pressedKeys.remove(e.getKeyCode());
    }

    
    /**
     * Checks if a key is currently pressed.
     * @param keyCode The key code to check. should use KeyEvent.VK_ constants.
     * @return true if the key is pressed, false otherwise.
    **/
    public boolean isPressed(Integer keyCode) {
        if(pressedKeys.isEmpty()){ return false;}
        if (pressedKeys.contains(keyCode)){ return true;}
        return false;
    }

}
