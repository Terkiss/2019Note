package com.example.notification_ex_jeong;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Snapshot;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.material.snackbar.Snackbar;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button basicBtn;
    Button bigPicture;
    Button bigText;
    Button inbox;
    Button prograss;
    Button message;
    Button headSup;
    Button snack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basicBtn = findViewById(R.id.basicButton);
        bigPicture = findViewById(R.id.bigPictureButton);
        bigText = findViewById(R.id.bigTextButton);
        headSup = findViewById(R.id.headSup);
        inbox = findViewById(R.id.inboxStyleButton);
        prograss = findViewById(R.id.prograssStyleButton);
        message = findViewById(R.id.messageStyleButton);
        snack = findViewById(R.id.snackBarButton);


        basicBtn.setOnClickListener(this);
        bigPicture.setOnClickListener(this);
        bigText.setOnClickListener(this);
        headSup.setOnClickListener(this);
        inbox.setOnClickListener(this);
        prograss.setOnClickListener(this);
        message.setOnClickListener(this);
        snack.setOnClickListener(this);
    }



    /*
        알림 사용법
        1. 알림 매니저  NotificationManager manager  선언후
        2. 시스템 을 요구 getSystemService(NOTIFICATION_SERVICE)
        3. 안드로이드 sdk 의 버전을 참고해서 오래오 이전과 후로 처리할 내용을 기술
        4. 아이콘 등록, 현재시간, 컨텐츠 텍스트 본문 텍스트 입력
        5. 팬딩 인텐트를 등록하여 알림을 터치시 앱을 실행 할수 있도록 구성
        5. 팬딩 인텐트를 이용해 브로드 캐스트를 액션에 연결해 브로드 캐스트 할수  있게함
        5-1. -> 기타 처리는 하위 코드 참조
        6. 알림 방송은 manager.notify(int id , builder.build());
     */






    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onClick(View v) {
        // 알림 매니저 선언
        final NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final NotificationCompat.Builder builder;

        // 알림 사전 설정
        // 오레오 라면
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O )
        {
            // 채널 아이디 원 채널
            String channelId = "JeongChannel";

            // 채널 이름
            String channelName = "Jeong`s Channel";

            // 채널 정의
            String channelDescription = "My Channel One Study notification";

            // 알림 채널
            NotificationChannel channel = null;

            // 알림 채널 할당
            if(v == headSup)
            {   // 알림의 중요도가 다름 헤드섭
                channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
            }
            else
            {
                // 일반 알림 일경우
                channel=new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            }

            // 채널 정의 문을 채널에 등록
            channel.setDescription(channelDescription);

            // 채널을 생성합니다 .
            manager.createNotificationChannel(channel);

            // 빌더를 만듭니다.
            builder=new NotificationCompat.Builder(this, channelId);

/*
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationChannel notificationChannel = new NotificationChannel("channel_id", "channel_name", NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel.setDescription("channel description");
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.GREEN);
                notificationChannel.enableVibration(true);
                notificationChannel.setVibrationPattern(new long[]{100, 200, 100, 200});
                notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
                notificationManager.createNotificationChannel(notificationChannel);
            }
  */
        }
        else
        {
            builder=new NotificationCompat.Builder(this);
        }

        // 아이콘 등록
        builder.setSmallIcon(android.R.drawable.ic_notification_overlay);

        // 현재 시간
        builder.setWhen(System.currentTimeMillis());

        // 알림 타이틀 텍스트
        builder.setContentTitle("나의 첫 알림");

        // 알림 본문 텍스트
        builder.setContentText("이게 공지 내용 이다 이거 ok");

        //DEFAULT_SOUND, DEFAULT_VIBRATE, DEFAULT_LIGHTS을 함께 지정 가능
        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
        //  터치시 자동 삭제 여부
       builder.setAutoCancel(true);

       // setOngoing 진행 표시 여부 true 가 설정시 사용자가 밀어서 삭제 불가


        // 인텐트 이동 지정
        Intent intent = new Intent(this, MainActivity.class);

        // 팬딩 인텐트란 ?
        // 인텐트를 포함하는 인텐트, 사용하는 목적은 현재 앱이 아닌 외부의 (노티피케이션, 알람들)이
        // 현재 내가 개발한 앱을 열수 있도록 허락할 수 있는 인텐트 이며 그 펜딩 인텐트 안에는 실제
        // 데이터를 갖고 있는것과 같다
        // 따라서 내가 개발한 앱안에서 a라는 액티비티에서 b라는 액티비티를 열려면 Intent = new Intent(this, b.class);
        // 지만 외부에서는 intent를 포함하고 있는 PendingIntent를 선언 하여 Intent를  품게 한뒤 사용하게 하는것이다.
        // 팬팅인텐트.플레그값
        PendingIntent pendingIntentMain = PendingIntent.getActivity(this, 10, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntentMain);

        // 브로드 캐스트 ? 를 얻어온 팬딩 인텐트
        PendingIntent pendingIntentNotiReceiver = PendingIntent.getBroadcast(this, 20, new Intent(this, NotiReceiver.class), PendingIntent.FLAG_UPDATE_CURRENT);

        // 액션 클릭 시 하는 행동들  등록
        builder.addAction(new NotificationCompat.Action.Builder(R.drawable.bb, "Action 1", pendingIntentNotiReceiver).build());


        // 비트맵 이미지 크기 계산후 생성
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.cc);

        // 라지 아이콘에 비트맵 이미지 등록
        builder.setLargeIcon(largeIcon);


        if(v == bigPicture)
        {
            // 큰 이미지 비트맵 으로 가공
            Bitmap bigpitBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dd);

            // 큰 이미지 스타일로 ㅈ재가공
            NotificationCompat.BigPictureStyle bigStyle = new androidx.core.app.NotificationCompat.BigPictureStyle(builder);

            // 생성한 비트맵 이미지를 등록
            bigStyle.bigPicture(bigpitBitmap);

            // 빌더에 생성한 빅 스타일 등록
            builder.setStyle(bigStyle);
        }
        else if( v == bigText )
        {
            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle(builder);
            bigTextStyle.setSummaryText("커다란 텍스트 섬마리");
            bigTextStyle.bigText("동해물과 백두산이 마르고 닳도록 하나님이 보우아사 우리나라 만세!!!");
            builder.setStyle(bigTextStyle);

        }
        else if( v == inbox)
        {
            NotificationCompat.InboxStyle style=new NotificationCompat.InboxStyle(builder);
            style.addLine("Activity");
            style.addLine("BroadcastReceiver");
            style.addLine("Service");
            style.addLine("ContentProvider");
            style.setSummaryText("Android Component");
            builder.setStyle(style);
        }
        else if( v == prograss)
        {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for(int i = 1 ;  i <= 10; i++)
                    {
                        builder.setAutoCancel(false); // 터치해도 안사라짐
                        builder.setOngoing(true); // 안사라지는 마법

                        builder.setProgress(10, i, false);
                        manager.notify(111, builder.build());
                        if(i >= 10 )
                        {
                            // 알림 캔슬
                           manager.cancel(111);
                        }
                        SystemClock.sleep(1000);
                    }
                }
            };
            Thread t = new Thread(runnable);
            t.start();
        }
        else if (v == headSup )
        {
            builder.setFullScreenIntent(pendingIntentMain, true);
        }
        else if( v == message )
        {
            androidx.core.app.Person sender1 = new Person.Builder()
                    .setName("kkang")
                    .setIcon(IconCompat.createWithResource(this, R.drawable.aa))
                    .build();

            androidx.core.app.Person sender2 = new  Person.Builder()
                    .setName("sora")
                    .setIcon(IconCompat.createWithResource(this, R.drawable.dd))
                    .build();

            // 메세지를 넣는 방법이 여러개가 있음
            // 변수를 생성 하여 넣는 방법
            NotificationCompat.MessagingStyle.Message message = new NotificationCompat.MessagingStyle.Message("hello", System.currentTimeMillis(), sender2);

            // 스타일을 만들어서 넣는ㄴ 방법
            NotificationCompat.MessagingStyle style = new NotificationCompat.MessagingStyle(sender1)
                    .addMessage("world", System.currentTimeMillis(), sender1)
                    .addMessage(message);


            // 빌더에 현재 스타일을 지정 합니다 .
            builder.setStyle(style);
        }
        else if( v == snack )
        {
            // 구ㅡ글 머터리얼 디자인 스낵바
            Snackbar.make(v, "스낵바 입니다 ",Snackbar.LENGTH_LONG).show();
            return;
        }
        manager.notify(111, builder.build());
    }
}
