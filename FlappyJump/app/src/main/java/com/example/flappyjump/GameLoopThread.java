package com.example.flappyjump;

import android.graphics.Canvas;

public class GameLoopThread extends Thread{
    private GameView view;
    static final long FPS =30;
    boolean running;
    public GameLoopThread(GameView view){
        this.view = view;
    }
    public void setRunning(boolean run){
        running = true;
    }
    @Override
    public void run(){
        long ticksPS =  1000/FPS;
        long startTime = 0;
        long sleepTime;
        while(running){
            Canvas c = null;
            try {
                c = view.getHolder().lockCanvas();
                synchronized(view.getHolder()){
                    view.onDraw(c);
                }
            }finally {
                if(c != null){
                    view.getHolder().unlockCanvasAndPost(c);
                }
            }
            sleepTime = ticksPS-(System.currentTimeMillis() - startTime);
            try{
                if(sleepTime > 0){
                    sleep(sleepTime);
                }
                else{
                    sleep(10);
                }
            }
            catch(Exception e){}
        }
    }
}
