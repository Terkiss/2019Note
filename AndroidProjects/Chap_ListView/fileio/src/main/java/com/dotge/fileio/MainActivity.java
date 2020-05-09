package com.dotge.fileio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] titles={"처음처럼","시작","ON","그때 그 아인","사랑, 하자"};
    String[] singers={"엠씨더맥스","가호","방탄소년단","김필","수호"};
    ListView listView;
    SongAdapter adapter;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        Button btn_add = findViewById(R.id.button2);
        Button btn_close = findViewById(R.id.button);

        Button btn_fileWrite = findViewById(R.id.button5);
        Button btn_fileRead = findViewById(R.id.button6);



        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 0);







        adapter = new SongAdapter(this);

        for(int i=0; i<titles.length; i++){ 
            SongItem item = new SongItem(titles[i],singers[i], R.drawable.song);
            adapter.addItem(item);
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


        btn_fileWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WriteTHread thread = new WriteTHread();
                thread.start();
            }
        });
        btn_fileRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadThread thread = new ReadThread();
                thread.start();
            }
        });


        /*
             파일 입출력 이벤트 메서드
        btn_fileWrite.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                File file = getFile();
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                    ArrayList<SongItem> itmes = adapter.items;


                    objectOutputStream.writeObject(itmes.size());  // 오토 박스

                    for(int i = 0 ; i < itmes.size() ; i++)
                    {
                       SongItem item = itmes.get(i);

                       objectOutputStream.writeObject(item);


                    }
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    Toast.makeText(getApplicationContext(), "파일 개별 쓰기가 완료됨 ", Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "파일 개별 쓰기가 심패됨 ", Toast.LENGTH_LONG).show();
                }
            }


        });


        btn_fileRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = getFile();
                try {
                    ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
                    ArrayList<SongItem> items = new ArrayList<>();
                    int count = (Integer ) input.readObject();

                    adapter.Clear();
                    for(int i = 0 ; i < count; i++){
                        SongItem item = (SongItem) input.readObject();
                        adapter.addItem(item);
                    }
                    input.close();
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
         */
    }

    public File getFile()
    {
        File file =new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"list.txt");
        return file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data!=null) {
            String title = data.getStringExtra("title");
            String singer = data.getStringExtra("singer");

            int imageResource = data.getIntExtra("imageResource", 0);

            SongItem item = new SongItem(title, singer, imageResource);
            adapter.addItem(item);
            adapter.notifyDataSetChanged();

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    class WriteTHread extends Thread{
        @Override
        public void run()
        {
            try {
                Socket socket = new Socket("192.168.0.25", 10500);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject("WRITE");
                ArrayList<SongItem> items = adapter.items;
                objectOutputStream.writeObject(new Integer(items.size()));

                for(int i = 0; i <items.size(); i++)
                {
                    SongItem item = items.get(i);
                    objectOutputStream.writeObject(item);
                    objectOutputStream.flush();
                }
                handler.post((new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "서버로 리스트 쓰기 완료", Toast.LENGTH_LONG).show();
                    }
                }));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    class ReadThread extends Thread{
        @Override
        public void run()
        {
            try {
                Socket socket = new Socket("192.168.0.25", 10500);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject("READ");
                objectOutputStream.flush();


                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                int count = (int) objectInputStream.readObject();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.Clear();
                    }
                });

                for(int i = 0; i < count; i++)
                {
                    final SongItem item = (SongItem)objectInputStream.readObject();
                    Log.d("j", item.singer);
                    Log.d("j", item.title);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            adapter.addItem(item);
                            Log.d("j", "실행되나");
                            adapter.notifyDataSetChanged();
                        }
                    });
                }



                handler.post((new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "서버로 에서 리스트 읽기 완료", Toast.LENGTH_LONG).show();
                    }
                }));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
