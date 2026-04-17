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

    public MouseEvent getCurrentMouseEvent() {
        if (currentMouseEvent == null) {
            System.out.println("No mouse event detected.");
            return null;
        }
        return currentMouseEvent;
    }


    public void updateMouse() {
        if(!game.isShowing() || currentMouseEvent == null) return;

        Point mousePoint = MouseInfo.getPointerInfo().getLocation();
        Point windowLocation = game.getLocationOnScreen();

        currentMouseEvent.translatePoint(mousePoint.x - windowLocation.x - currentMouseEvent.getX(), mousePoint.y - windowLocation.y - currentMouseEvent.getY());
    }

    
    
}
