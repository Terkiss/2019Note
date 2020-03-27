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
            //Document doc = Jsoup.connect("https://movie.naver.com/movie/running/current.nhn").get();
            Document doc = Jsoup.connect("https://movie.naver.com/movie/running/current.nhn").get();
            Elements mElementDataSize = doc.select("ul[class=lst_detail_t1]").select("li"); //필요한 녀석만 꼬집어서 지정
            int mElementSize = mElementDataSize.size(); //목록이 몇개인지 알아낸다
            jeongLog.logD(String.valueOf( mElementSize) + ";:  갯수");
            jeongLog.logD(mElementDataSize.toString());

            for (int i = 0 ; i < mElementSize; i++)
            {
                Element elmentData = mElementDataSize.get(i);
                //jeongLog.logD("내부 확인 "+i+"번쨰 데이터 :::"+elmentData);
               //String my_title = elmentData.select("")
                String my_title = elmentData.select("li dt[class=tit]").select("a").text();
                String my_link = "https://movie.naver.com/"+elmentData.select("li div[class=thumb] a").attr("href");

                // 속성값으로 내부 추출
                String my_image = elmentData.select("li div[class=thumb] a img").attr("src");
                Elements aa = elmentData.select("li div[class=thumb]").select("a");
                jeongLog.logD("내부 확인 "+i+"번쨰 데이터 :::"+my_link);
                //jeongLog.logD("내부 확인 "+i+"번쨰 데이터 :::"+aa.get(0).text());

                // 포장 메서드
                sealDataList(my_title, my_image, my_link);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private void sealDataList(String title, String imgUri, String detailUri)
    {
        Item item = new Item(title, imgUri, detailUri);
        MainActivity.m_Item.add(item);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // 진행 다이아 로그 표시 메서드
    }

}
