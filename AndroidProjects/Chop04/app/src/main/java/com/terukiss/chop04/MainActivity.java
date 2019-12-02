package com.terukiss.chop04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

       Button button = (Button)  findViewById(R.id.button);


       button.setOnClickListener( new View.OnClickListener()
                                  {
                                      public void onClick(View v)
                                      {
                                          Toast.makeText(getApplicationContext(), "버튼 인력 테스트 중", Toast.LENGTH_LONG).show();
                                      }
                                  }
       );



    }

}
