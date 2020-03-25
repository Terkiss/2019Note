package com.example.imagecollect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class ImageLoader {
    ArrayList<Bitmap> bm = new ArrayList<Bitmap>();
    public void LoadImage(URL url)
    {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try{


                    URL url = new URL("http://deahets.iptime.org/ade345/mp3/back.jpg");
                    InputStream is = url.openStream();
                    bm.add( BitmapFactory.decodeStream(is) );

                } catch(Exception e){

                }

            }
        });

        t.start();
    }
}
