package com.dotge.mylanchroolet;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
import android.util.DisplayMetrics;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;

import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.dotge.mylanchroolet.R;


public class MainActivity extends Activity {

    private ImageView wheel;                         // 회전 이미지

    private Bitmap mBitMap;                          // 이미지를 가저온다.
    private float init_angle = 0.0f;                // 초기 각토
    private final int IMG_DP = 300;                 //  이미지 DP
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 이미지 SET
        wheel = (ImageView) findViewById(R.id.wheel);
        // 비트맵 이미지를 가저온다.(drawable폴더에 roulette이미지)
        mBitMap = BitmapFactory.decodeResource(getResources(), R.drawable.looret);
        // 비트맵을 imageview 에 넣는다.(리사이즈한후)
        wheel.setImageBitmap(onResizeImage(mBitMap));

        // 버튼 이벤트
        Button btn = (Button) findViewById(R.id.rotate_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onWheelImage();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        //if (id == R.id.action_settings) {
       //     return true;
       // }

        return super.onOptionsItemSelected(item);
    }

    /**
     *
     * DP를 픽셀로 변환시킨다.
     *
     * @param dp
     * @param context
     * @return
     */
    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

    /**
     *
     * 이미지를 리사이징한다.
     *
     */
    private Bitmap onResizeImage(Bitmap bitmap){
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();

        //이미지를 dp로 변경
        Float size = convertDpToPixel(IMG_DP, getApplicationContext());

        Bitmap resized = null;
        while (height > size.intValue()) {
            resized = Bitmap.createScaledBitmap(bitmap, (width * size.intValue()) / height, size.intValue(), true);
            height = resized.getHeight();
            width = resized.getWidth();
        }
        return resized;
    }

    /**
     *
     * 램덤 함수를 가저온다.
     *
     * @param maxNumber
     * @return
     */
    private int getRandom(int maxNumber) {
        return (int)(Math.random()*maxNumber);
    }
    /**
     *
     * 이미지를 회전시킨다.
     *
     */
    private void onWheelImage(){
        runOnUiThread(new Runnable() {
            public void run() {
                // 회전수를 제어
                // 램덤 0~360 + 720 도 + 회전각
                float fromAngle = getRandom(360)+72000+init_angle;
                // 로테이션 에니메이션 초기화.
                // 시작각, 종료각, 자기 원을 그리며 회전 옵션 (Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f)
                RotateAnimation rAnim = new RotateAnimation(init_angle, fromAngle, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
                // 초기 시작 각도를 update 한다.
                init_angle = fromAngle;
                // 지속시간 길수록 느려진다.
                rAnim.setDuration(15
                        000);
                // 에니메이션이 종료된후 상태를 고정주는 옵션
                rAnim.setFillEnabled(true);
                rAnim.setFillAfter(true);
                // 회전을 한다.
                wheel.startAnimation(rAnim);
            }
        });
    }
}


