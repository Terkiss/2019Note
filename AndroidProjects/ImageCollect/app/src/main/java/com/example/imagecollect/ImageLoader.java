package com.example.imagecollect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageLoader {
    ArrayList<Item> item = new ArrayList<>();
    Handler handler = new Handler();

    boolean isComplete = false;
    int count = 0 ;
    public ImageLoader(ArrayList<Item> items)
    {
        this.item = items;
    }
    public void LoadImage()
    {
/*
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try{

                    Iterator<Item> iitem = item.iterator();
                    while(iitem.hasNext())
                    {
                        String imageLink = iitem.next().getImg_url();

                        URL url = new URL(imageLink);

                        InputStream is = url.openStream();

                        bm.add(BitmapFactory.decodeStream(is));

                    }
                } catch(Exception e){

                }

            }
        });

        t.start();
  */     final JeongLog log = new JeongLog();
        log.logD("iitem. "+item.size());
        try{
            for(int i = 0 ; i< item.size(); i++) {
               // log.logD(i+"번쨰 bm 생성 해시값 :: ");
                final String imageLink = item.get(i).getImg_url();
                final int index = i;
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        try{
                                URL url = new URL(imageLink);
                                InputStream is = url.openStream();
                                Item sItem = item.get(index);
                                sItem.setBitImg(BitmapFactory.decodeStream(is));
                               // log.logD(index+" 번쨰 이미지 로딩중");
                        } catch(Exception e){
                        }

                    }
                });

                t.start();
            }

            /*
                for(int i = 0 ; i< item.size(); i++)
                {
                    log.logD(i+"번쨰 bm 생성 해시값 :: ");
                    String imageLink = item.get(i).getImg_url();

                    URL url = new URL(imageLink);

                    InputStream is = url.openStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    bm.add( bitmap);
                    log = new JeongLog();
                }

             */
        } catch(Exception e){

        }
    }

}
