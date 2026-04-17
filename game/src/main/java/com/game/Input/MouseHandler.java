package com.game.Input;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.game.Game;

public class MouseHandler implements MouseListener {

    private MouseEvent currentMouseEvent;
    private Game game;

    public MouseHandler(Game game) {
        this.game = game;
    }

    //sets the current mouse event to the most recent mouse event
    @Override
    public void mouseClicked(MouseEvent e) {
        currentMouseEvent = e;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        currentMouseEvent = e;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        currentMouseEvent = e;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        currentMouseEvent = e;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        currentMouseEvent = e;
    }

    /**
     * @return the most recent mouse event, or null if there is no mouse event
     */
    public MouseEvent getCurrentMouseEvent() {
        if (currentMouseEvent == null) {
            System.out.println("No mouse event detected.");
            return null;
        }
        return currentMouseEvent;
    }

    /**
     * runs every frame
     */
    public void updateMouse() {
        if(!game.isShowing() || currentMouseEvent == null) return;

        Point mousePoint = MouseInfo.getPointerInfo().getLocation(); // the point of the mouse on the screen
        Point windowLocation = game.getLocationOnScreen(); // where the window is on the screen

        // -currentMouseEvent.getX() to set to 0, then takes the difference between the mouse and the window to get the position of the mouse relative to the window
        currentMouseEvent.translatePoint(mousePoint.x - windowLocation.x - currentMouseEvent.getX(), mousePoint.y - windowLocation.y - currentMouseEvent.getY());
    }

    
    
}
