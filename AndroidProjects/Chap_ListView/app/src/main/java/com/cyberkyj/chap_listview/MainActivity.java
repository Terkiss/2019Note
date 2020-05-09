package com.cyberkyj.chap_listview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] titles={"처음처럼","시작","ON","그때 그 아인","사랑, 하자"};  //타이틀
    String[] singers={"엠씨더맥스","가호","방탄소년단","김필","수호"}; // 가수명
    ListView listView;
    SongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView); // 리스트뷰
        Button btn_add = findViewById(R.id.btn_add); // 추가 버튼
        Button btn_close = findViewById(R.id.btn_close); // 닫기 버튼

        adapter = new SongAdapter(this);

        for(int i=0; i<titles.length; i++){
            SongItem item = new SongItem(titles[i],singers[i]); // 데이터를 이용해 클래스 생성
            adapter.addItem(item); // 데이터 보관

        }

        listView.setAdapter(adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SongInfoActivity.class);
                startActivityForResult(intent,1000);
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SongItem item = (SongItem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택한 아이템 : "+item.getTitle()+", "+item.getSinger(),Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                adapter.removeItem(position);
                adapter.notifyDataSetChanged();

                return true;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data!=null) {
            String title = data.getStringExtra("title");
            String singer = data.getStringExtra("singer");

            SongItem item = new SongItem(title, singer);
            adapter.addItem(item);
            adapter.notifyDataSetChanged();

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
