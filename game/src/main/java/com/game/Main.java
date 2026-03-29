package com.game;

import javax.swing.JFrame;

import com.game.Input.KeyHandler;

public class Main {
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("game");
        
        window.requestFocus();
        

        Game gamePanel = new Game();
        window.add(gamePanel);
        window.pack();
        
        gamePanel.startGameThread();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}