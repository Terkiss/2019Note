package com.example.mypaint;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class PaintBoard extends View {

    Paint paint ;
    Canvas mCanvas ;
    Bitmap mbitmap ;

    int lastX, lastY ;

    int x,y ;
    Path path ;

    public PaintBoard(Context context)
    {
        super(context);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10.0f);


        lastX = -1;
        lastY = -1;

        path = new Path();

    }
    public PaintBoard(Context a, @Nullable AttributeSet aa)
    {
        super(a,aa);
    }

    protected  void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        mbitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888) ;
        // mbitmap = BitmapFactory.decodeFile("그림의 경로  엔 파일 ");

        mCanvas = new Canvas() ;
        mCanvas.setBitmap(mbitmap) ;
        mCanvas.drawColor(Color.WHITE);
        Log.d("j", " 실행? ");
    }

    protected  void onDraw(Canvas canvas)
    {
        if(mbitmap != null)
        {
            Log.d("j", "Ondraw 실행? ");
            canvas.drawBitmap(mbitmap,0,0, null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction() ;
        x = (int) event.getX() ;
        y = (int) event.getY() ;


        switch(action)
        {
            case MotionEvent.ACTION_DOWN:

                if(x != lastX || y != lastY)
                {
                    //mCanvas.drawLine(lastX, lastY, x, y, paint);
                    path.moveTo(x,y) ;
                }

                lastX =x ;
                lastY = y ;
                Log.d("j", lastX+" , "+lastY);
                break;


            case MotionEvent.ACTION_MOVE:
                if(lastX != -1)
                {
                    // mCanvas.drawLine(lastX, lastY, x, y, paint);

                    lastX = x ;
                    lastY = y ;
                    Log.d("j", lastX+" move, "+lastY);
                    int cenX = (x+lastX)/2, cenY = (y+lastY)/2;
                    path.quadTo(lastX, lastY, cenX, cenY);
                    mCanvas.drawPath(path, paint);
                }

                break;

            case MotionEvent.ACTION_UP:
                lastX = -1;
                lastY = -1;
                break;
        }
        invalidate();
        return true;
    }
}
