package com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.game.Constants.ScreenConstants;


public class Game extends JPanel implements Runnable{

    private Thread gameThread;

   
    public Game() {
       
        this.setPreferredSize(new Dimension((int) ScreenConstants.screenWidth, (int) ScreenConstants.screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocusInWindow();
        init();
    }

    private void init() {
      
    }

    private void update() {
       
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
     
        
        
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

 

}
