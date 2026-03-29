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

    public Player(Game game) {
        this.game = game;
    }

    public void update() {
        playerInput();

    }

    public void paint(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.drawOval((int) x, (int) y, (int) PlayerConstants.playerWidth, (int) PlayerConstants.playerHeight);
    }

    private void playerInput() {
        if (game.getKeyHandler().isPressed(KeyEvent.VK_W)) {
            y -= PlayerConstants.playerSpeed;
        }
        if (game.getKeyHandler().isPressed(KeyEvent.VK_S)) {
            y += PlayerConstants.playerSpeed;
        }
        if (game.getKeyHandler().isPressed(KeyEvent.VK_A)) {
            x -= PlayerConstants.playerSpeed;
        }
        if (game.getKeyHandler().isPressed(KeyEvent.VK_D)) {
            x += PlayerConstants.playerSpeed;
        }
    }

}
