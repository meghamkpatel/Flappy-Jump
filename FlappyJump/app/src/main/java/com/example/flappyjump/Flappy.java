package com.example.flappyjump;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Flappy {
    static int x;
    static int y;
    static int gravity = 1;
    static int vspeed = 1;
    static int flappyHeight;
    static int flappyWidth;
    Bitmap bmp;
    GameView gameview;
    public Flappy(GameView gameview, Bitmap bmp, int x, int y){
        this.x = x;
        this.y = y;
        this.gameview = gameview;
        this.bmp = bmp;
        flappyHeight = bmp.getHeight();
    }
    public void update(){
        checkground();
    }
    public void checkground(){
        if(y > gameview.getHeight()-64-flappyHeight){
            vspeed+=gravity;
        }
        else{
            vspeed = 0;
        }
        y+=vspeed;
    }
    public void ontouch(){
        if(y<=gameview.getHeight()-64-flappyHeight){

        }
    }
    public onDraw(Canvas canvas){
        update();
        canvas.drawBitmap(bmp, x, y, null);
    }
}
