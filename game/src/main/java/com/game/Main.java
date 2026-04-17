package com.game;

import javax.swing.JFrame;

import com.game.Input.KeyHandler;

public class Main {
    public static void main(String[] args) {
        //creates a window for the game to be displayed in
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what happens when the window is closed
        window.setResizable(false); // stops from resizing
        window.setTitle("game"); // title of the window
        
        window.requestFocus();
        

        Game gamePanel = new Game();
        window.add(gamePanel); // adds the game panel to the window
        window.pack(); // sets the window to the size of the game panel
        
        gamePanel.startGameThread(); // starts the game loop
        window.setLocationRelativeTo(null); // centers the window on the screen
        window.setVisible(true); // makes the window visible
    }
}