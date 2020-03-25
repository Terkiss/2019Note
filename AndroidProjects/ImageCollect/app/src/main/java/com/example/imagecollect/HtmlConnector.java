package com.example.imagecollect;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class HtmlConnector extends AsyncTask<Void, Void, Void> {
    JeongLog jeongLog = new JeongLog();
    @Override
    protected Void doInBackground(Void... voids) {

        try{
            Document doc = Jsoup.connect("https://movie.naver.com/movie/running/current.nhn").get();
            Elements mElementDataSize = doc.select("ul[class=lst_detail_t1]"); //필요한 녀석만 꼬집어서 지정
            int mElementSize = mElementDataSize.size(); //목록이 몇개인지 알아낸다
            jeongLog.logD(String.valueOf( mElementSize) + ";:  갯수");
            jeongLog.logD(mElementDataSize.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // 진행 다이아 로그 표시 메서드
    }
}
