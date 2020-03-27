package com.example.imagecollect;

import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jeongLog = new JeongLog(this);




        String htmlDoc = "<html>\n" +
                "<head>\n" +
                "    <!-- 웹페이지 지원 언어 설정 인코딩 UTF 8 전세계 적인 지원 이 가능   -->\n" +
                "    <meta charset=\"utf-8\">\n" +
                "\n" +
                "    <!-- 웹페이지 타이틀 -->\n" +
                "    <title> 안녕 html </title>\n" +
                "\n" +
                "    <!-- \n" +
                "         font-size 글자의 크기를 지정\n" +
                "         color 글자의 색상 지정 \n" +
                "    -->\n" +
                "</head>\n" +
                "<body>\n" +
                "    <a href=\"CssStudy.html\">여기 클릭</a>\n" +
                "    <!-- \n" +
                "        <h1~6> 제목\n" +
                "        <p>~~~</p> 문단\n" +
                "            <b>~~</b> 안에 있는 문자 굵게 \n" +
                "        <br> 줄바꿈\n" +
                "        &nbsp 스페이스 \n" +
                "        &lt; \n" +
                "        &gt; \n" +
                "        &amp; \n" +
                "        &quot; \n" +
                "        &copy; \n" +
                "    -->\n" +
                "\n" +
                "    <h3> 요리란? </h3>\n" +
                "    <p>\n" +
                "        요리는 &nbsp&nbsp&nbsp먹기 좋게 <b>가공한 음식</b> <br> 혹은 그 가공 행위 자체를 말합니다. 요리는 크게 나누어 지역 별로 시대별로 그종류를 구분 할수 있습니다. 전통적인 한국 정식은 ...... 쌀을 주식으로 하며 반찬은 참기름, 도ㅓㅣㄴ장 , &lt; <br> &gt; <br> &amp; <br> &quot; <br> &copy; <br>\n" +
                "    </p>\n" +
                "    <h4> 제목 </h4>\n" +
                "    <h5> 제목 </h5>\n" +
                "    <h6> 제목 </h6>\n" +
                "\n" +
                "\n" +
                "    <!-- \n" +
                "        목록 \n" +
                "        ul 순서가 없는 목록\n" +
                "        ol 순서가 있는 목록 \n" +
                "    -->\n" +
                "    <ul>\n" +
                "        <li> 초대권 소지자 : 등록 데스크에서 본인 확인후 교환권 지급</li>\n" +
                "        <li> 사전 등록자 : 등록데스크에서 보인 확인 후 교환권 지급</li>\n" +
                "        <li> 일반 관람객 : 일반 관람객은 매표소에서 입장권을 구입하여 입장</li>\n" +
                "    </ul>\n" +
                "\n" +
                "    <ol>\n" +
                "        <li> 초대권 소지자 : 등록 데스크에서 본인 확인후 교환권 지급</li>\n" +
                "        <li> 사전 등록자 : 등록데스크에서 보인 확인 후 교환권 지급</li>\n" +
                "        <li> 일반 관람객 : 일반 관람객은 매표소에서 입장권을 구입하여 입장</li>\n" +
                "    </ol>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "    <h3>가장 좋아하는 음식은 무엇 인가요?</h3>\n" +
                "    <p>\n" +
                "        가. 불고기 <br> 나. 라면 <br> 다. 떡볶이 <br> 라. 삼겹살\n" +
                "    </p>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "    <h3>간단한 로제 파스타 만들기</h3>\n" +
                "\n" +
                "    토마토 소스의 <b>새콤달콤함</b> 과 크림소스의 <b>부드럽고 고소함</b> 을 느낄수 있는 로제 파스타를 간단하게 만드는 방법 알아보자\n" +
                "    <ol>\n" +
                "        <li>새우 마늘 양파 등의 재료 준비</li>\n" +
                "        <li>끍는 물에 스파게티 면을 넣고 8분 삶기</li>\n" +
                "        <li>볶아놓은 재료와 스파게티 면을 큰 접시에 담은 다음 그위에 미리 데워놓은 파스타 소스 붓기</li>\n" +
                "    </ol>\n" +
                "    <!--\n" +
                "        1. 글제 목 만들기\n" +
                "            html에서는 <h1>, <h2>, <h3>, <h4>, <h5>, <h6>의 여섯개의 태그로 글제목 표현 \n" +
                "        2. 단락 나누기 \n" +
                "            html 문서에서 단락을 나눌 떄는 <p> 를 사용\n" +
                "        3. 글자 두껍게 하기\n" +
                "            글자를 두껍게 할떄는 <b> 태그 사용\n" +
                "        4. 줄바꿈과 공백 삽입하기\n" +
                "                html 문서에서 단락이나 글자의 내용 중에 줄바꿈을 하려면 해당 줄의 맨 뒤에 <br>\n" +
                "                태그를 붙입니다. 공백을 여러개 삽입혀려면 html 특수 문자 기호인 &nbsp 를 사용\n" +
                "        5. 목록 만들기\n" +
                "                웹페이지에서 목록을 만들려면 <ul>, <ol>, <li> 태그를 사용\n" +
                "                    * 순서가 없는 목록 : <ul>, <li> 태그\n" +
                "                    * 순서가 있는 목록 : <ol>, <li> 태그\n" +
                "        6. html 문서에 설명글 달기\n" +
                "                html 문서에 웹브라우저가 해석하지 못하는 설명글 을 넣을려면    <!---->; -->\n" +
                "</body>\n" +
                "\n" +
                "</html>";

        Document doc = Jsoup.parse(htmlDoc);

        Elements title = doc.select("title");

        jeongLog.logD("Doc :: "+doc);
        jeongLog.logD("title = "+title);


        //Thread t = new Thread(Runnable 객체를 만든다);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {    // 오래 거릴 작업을 구현한다
                // TODO Auto-generated method stub
                try{
                    // 걍 외우는게 좋다 -_-;
                    final ImageView iv = (ImageView)findViewById(R.id.imageView2);
                    URL url = new URL("http://deahets.iptime.org/ade345/mp3/back.jpg");
                    InputStream is = url.openStream();
                    final Bitmap bm = BitmapFactory.decodeStream(is);
                    handler.post(new Runnable() {

                        @Override
                        public void run() {  // 화면에 그려줄 작업
                            iv.setImageBitmap(bm);
                        }
                    });
                    iv.setImageBitmap(bm); //비트맵 객체로 보여주기
                } catch(Exception e){

                }

            }
        });

        t.start();




        new HtmlConnector().execute();

    }


    public void OnClick(View view) {
        int i = 0;
        for (Item tempData: m_Item)
        {
            jeongLog.logD(i+"\nName -> "+tempData.getTitle()+"\n ImageUri -> "+tempData.getImg_url()+"\n DetailUri -> "+tempData.getDetail_link());
        }
    }
}
