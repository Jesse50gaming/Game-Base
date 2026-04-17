package com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.game.Constants.ScreenConstants;
import com.game.Input.KeyHandler;
import com.game.Input.MouseHandler;
import com.game.Player.Player;

public class Game extends JPanel implements Runnable{

    private Thread gameThread;

    private MouseHandler mouseHandler;
    private KeyHandler keyHandler;
    private Player player;

    public Game() {
        //initializes the game panel and input handlers
        keyHandler = new KeyHandler();
        mouseHandler = new MouseHandler(this);
        this.setPreferredSize(new Dimension((int) ScreenConstants.screenWidth, (int) ScreenConstants.screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocusInWindow();
        addKeyListener(keyHandler);
        addMouseListener(mouseHandler);
        init();
    }

    private void init() {
        player = new Player(this);
    }

    /**
     * runs every frame
     */
    private void update() {
        keyHandler.update();
        mouseHandler.updateMouse();
        player.update();
    }


    /**
     * runs every frame
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        
        player.paint(g2);
        //
        
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/ScreenConstants.FPS; // how many nanoseconds are there in a frame
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null) { // while the game is running

            
             update(); // updates the game 
            
             repaint(); // draws things onto the screen
             
             try {
                
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime); // sleeps the thread until the next frame should be drawn
                
                nextDrawTime += drawInterval;
                

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * creates the gamethread and starts it, which starts the game loop
     */
    public void startGameThread() { 
        gameThread = new Thread(this);
        gameThread.start();
    }

    
    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public MouseHandler getMouseHandler() {
        return mouseHandler;
    }

}
