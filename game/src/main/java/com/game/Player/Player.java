package com.game.Player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.game.Game;
import com.game.Constants.PlayerConstants;
import com.game.Constants.ScreenConstants;

public class Player {

    private Game game;

    private double x = ScreenConstants.screenWidth /2 ,y = ScreenConstants.screenHeight / 2;
    //sets the player's position to the center of the screen on gamestart

    public Player(Game game) {
        this.game = game;
    }

    public void update() {
        playerKeyInput();
        playerMouseInput();
    }

    public void paint(Graphics2D g2) {
        //draws the player as a white circle
        g2.setColor(Color.WHITE);
        g2.drawOval((int) x, (int) y, (int) PlayerConstants.playerWidth, (int) PlayerConstants.playerHeight);
    }

    private void playerKeyInput() {
        
        if (game.getKeyHandler().isPressed(KeyEvent.VK_W)) {
            //if w is pressed, move the player up by subtracting from the y position
            y -= PlayerConstants.playerSpeed;
        }
        if (game.getKeyHandler().isPressed(KeyEvent.VK_S)) {
            //if s is pressed, move the player down by adding to the y position
            y += PlayerConstants.playerSpeed;
        }
        if (game.getKeyHandler().isPressed(KeyEvent.VK_A)) {
            //if a is pressed, move the player left by subtracting from the x position
            x -= PlayerConstants.playerSpeed;
        }
        if (game.getKeyHandler().isPressed(KeyEvent.VK_D)) {
            //if d is pressed, move the player right by adding to the x position
            x += PlayerConstants.playerSpeed;
        }
    }

    private void playerMouseInput() {
        if (game.getMouseHandler().getCurrentMouseEvent() == null) return;
        //add mouse logic here
    }

}
