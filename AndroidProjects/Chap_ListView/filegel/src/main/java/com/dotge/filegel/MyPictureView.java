package com.dotge.filegel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyPictureView extends View {

    String path;

    public MyPictureView(Context context) {
        super(context);
    }

    //xml에 붙였을때 인식하는거 xml에
    public MyPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    //뷰클래스를 상속받아서 가능!!
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(path!=null){
            Bitmap bitmap =  imageResize();

            int cenX = this.getWidth()/2;//내가 화면에 전체 쓸수 있는 크기 xml에 내가 쓸수있는 공간!!
            int cenY = this.getHeight()/2;
            int picX = (this.getWidth()-bitmap.getWidth())/2; //처음에 그림을 그릴 위치
            int picY = (this.getHeight()-bitmap.getHeight())/2;
            canvas.scale(2,2,cenX,cenY);//뿌릴 화면을 확대해서 그린다고보면됨
            canvas.drawBitmap(bitmap, picX, picY,null);//어디에 뿌릴지
            bitmap.recycle();//화면에 호출하기전에 띄운다
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private Bitmap imageResize()
    {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);


        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, 400, 272);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return  BitmapFactory.decodeFile(path, options);


    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;


            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }



}
