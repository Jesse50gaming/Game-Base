package com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.game.Constants.ScreenConstants;
import com.game.Input.KeyHandler;
import com.game.Player.Player;

public class Game extends JPanel implements Runnable{

    private Thread gameThread;

    private KeyHandler keyHandler;
    private Player player;

    public Game() {
        keyHandler = new KeyHandler();
        this.setPreferredSize(new Dimension((int) ScreenConstants.screenWidth, (int) ScreenConstants.screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocusInWindow();
        addKeyListener(keyHandler);
        init();
    }

    private void init() {
        player = new Player(this);
    }

    private void update() {
        keyHandler.update();
        player.update();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        
        player.paint(g2);
        
        
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/ScreenConstants.FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null) {

            
             update();
            
             repaint();
             
             try {
                
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                
                nextDrawTime += drawInterval;
                

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

}
