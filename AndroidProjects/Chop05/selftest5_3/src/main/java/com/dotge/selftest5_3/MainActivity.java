package com.dotge.selftest5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SelfJavaView SJV = new SelfJavaView(getApplicationContext());
        setContentView(R.layout.activity_main);
        SJV.etGenerator("editText");
        SJV.btnGenerator("button", "개판으로", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ev = SJV.editTextGet("editText");
                TextView tv = SJV.textViewGet("textview");
                TextView tv2 = SJV.textViewGet("textview2");
                TextView tv3 = SJV.textViewGet("textview3");

                tv.setText(ev.getText().toString());
                tv2.setText("2번쨰");
                tv3.setText("3번쨰");

            }
        });
        SJV.btnGenerator("button", "가버리는", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ev = SJV.editTextGet("editText");
                TextView tv = SJV.textViewGet("textview");
                TextView tv2 = SJV.textViewGet("textview2");
                TextView tv3 = SJV.textViewGet("textview3");

                tv.setText(ev.getText().toString());
                tv2.setText("2번쨰");
                tv3.setText("3번쨰");

            }
        });
        SJV.btnGenerator("button", "버튼 ", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ev = SJV.editTextGet("editText");
                TextView tv = SJV.textViewGet("textview");
                TextView tv2 = SJV.textViewGet("textview2");
                TextView tv3 = SJV.textViewGet("textview3");

                tv.setText(ev.getText().toString());
                tv2.setText("2번쨰");
                tv3.setText("3번쨰");

            }
        });
        SJV.btnGenerator("button", "개판 ", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ev = SJV.editTextGet("editText");
                TextView tv = SJV.textViewGet("textview");
                TextView tv2 = SJV.textViewGet("textview2");
                TextView tv3 = SJV.textViewGet("textview3");

                tv.setText(ev.getText().toString());
                tv2.setText("2번쨰");
                tv3.setText("3번쨰");

            }
        });

        SJV.tvGenerator("textview");
; SJV.tvGenerator("textview2");
        SJV.tvGenerator("textview3");
        SJV.etGenerator("editText");SJV.etGenerator("editText");SJV.etGenerator("editText");

        setContentView( SJV.linearLayoutAddWidget(), new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));



        /*
        LinearLayout ll = new LinearLayout(getApplicationContext());
        ll.setOrientation( LinearLayout.VERTICAL);
        LinearLayout.LayoutParams inputParam = new LinearLayout.LayoutParams(
          LinearLayout.LayoutParams.MATCH_PARENT,
          LinearLayout.LayoutParams.WRAP_CONTENT
        );
        ll.setPadding(10,10,10,10);


        et = new EditText(getApplicationContext());
        et.setHint("입력");
        LinearLayout.LayoutParams etParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        btn = new Button(getApplicationContext());
        btn.setText("눌러");
        LinearLayout.LayoutParams btnParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        btn.layout(10,10,10,10);

        final TextView tv = new TextView(getApplicationContext());
        tv.setText("");
        LinearLayout.LayoutParams tvParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        ll.addView(et, etParam);
        ll.addView(btn, btnParam);
        ll.addView(tv,tvParam);

        setContentView(ll);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText( et.getText().toString());
            }
        });

        */
    }
}
