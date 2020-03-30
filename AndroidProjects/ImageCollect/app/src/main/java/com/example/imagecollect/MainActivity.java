package com.example.imagecollect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();


    // 외부쓰레드 에서 메인 UI화면을 그릴때 사용
/*
* 안드로이드의 이미지뷰 (ImageView) 에 인터넷 상의 이미지들을 띄우는 예제입니다.

1. 권한을 획득한다 (인터넷에 접근할수 있는 권한을 획득한다)  - 메니페스트 파일
2. Thread 에서 웹의 이미지를 받아온다 - honeycomb(3.0) 버젼 부터 반드시 Thread 사용
4. URL.openStream -> InputStream -> BitmapFactory.decodeStream() -> Bitmap -> ImageView.setImageBitmap() 순으로 진행됩니다.
3. 외부쓰레드에서 메인 UI에 접근하려면 Handler 를 사용하여 Handler.post() 에서 runnable 객체를 생성하여 ImageView.setImageBitmap()을 실행시킵니다.

이와 같이 복잡한(?) 절차를 밟는 이유는 아무래도 인터넷상에서 끌어오다 보니, 속도등의 문제로 로딩이 지연될수 있으니  화면에 뿌려주는 단계를 Thread로 하기 위해 그렇겠죠. ^^



출처: https://bitsoul.tistory.com/26 [Happy Programmer~]
* */
    public static ArrayList<Item> m_Item = new ArrayList<>();

    JeongLog jeongLog;

    Bitmap aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jeongLog = new JeongLog(this);





        HtmlConnector connector = new HtmlConnector();
        connector.setMainActivity(MainActivity.this);
        connector.execute();

    }



    int count = 0;
    public void OnClick(View view) {
        int i = 0;
        String data = " \n";
        for (Item tempData : m_Item) {
            if (i % 17 == 0) {
                jeongLog.logD(data);
                data = " \n";
            }
            data += "\n" + (i++) + ". Name -> " + tempData.getTitle() + "\n ImageUri -> " + tempData.getImg_url() + "\n DetailUri -> " + tempData.getDetail_link();

        }
        jeongLog.logD(data);
        ImageView iv = (ImageView) findViewById(R.id.imageView2);
        iv.setImageBitmap(m_Item.get(count++).getBitImg());
    }

    public void LoadComplete()
    {
        ImageLoader iLoader = new ImageLoader(m_Item);
        iLoader.LoadImage();
        int i = 0;
        int imageLoadedCount = 0;
        while(true)
        {
            if(count == m_Item.size())
            {
                break;
            }

            if(i < m_Item.size()&&(m_Item.get(i).getBitImg() != null))
            {
                count++;
                i++;
            }
            else
            {
                count =0;
                i = 0;
            }
        }
        jeongLog.logD("로딩완료");
        RecyclerView recyclerView = findViewById(R.id.recyleView1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(m_Item, this);
        recyclerView.setAdapter(myAdapter);
    }
}
