package com.example.firebase_memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

public class MemoActivity  extends AppCompatActivity implements View.OnClickListener {
   // 메모 아이템
    private ArrayList<MemoItem> memoItems = null;

    // 메모 어답터
    private MemoAdapter memoAdapter = null;


    String username;


    // 파이어 베이스의  데이터 베이스를 얻어옴
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    // 파이어 데이터의 레퍼런스를 얻어옴
    DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);


        // 초기화
        init();

        // 뷰 초기화
        initView();
    }

    private void init()
    {
        // 메모 아이템 생성
        memoItems = new ArrayList<>();

        // 랜덤 이름 생성
        username = "user_" + new Random().nextInt(1000);


    }

    private void initView()
    {
        // 초기화 뷰
        // 메모 등록 버튼
        Button regbtn = (Button)findViewById(R.id.memobtn);
        regbtn.setOnClickListener(this);


        // 유저 등록 버튼
//        Button userbtn = (Button)findViewById(R.id.reguser);
//        userbtn.setOnClickListener(this);

        // RecyclerView.ViewManager layoutManager  = new LinearLayoutManager
        // 리사이클러 뷰 순차적으로 사용
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.memolist);

        memoAdapter = new MemoAdapter(memoItems, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(memoAdapter);
    }
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.memobtn:
                regMemo();
                break;
            case R.id.reguser:
               // writeNewUser();
                break;
        }
    }
    private void regMemo()
    {


        EditText titleedit = (EditText) findViewById(R.id.memotitle);

        EditText contentsedit = (EditText) findViewById(R.id.memocontents);


        // 입력 된 길이로 체크
        if(titleedit.getText().toString().length() == 0 ||
                contentsedit.getText().toString().length() == 0)
        {
            Toast.makeText(this,
                    "메모 제목 또는 메모 내용이 입력되지 않았습니다. 입력 후 다시 시작해주세요.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        MemoItem item = new MemoItem();
        //item.setUser(this.username);
        item.setMemoTitle(titleedit.getText().toString());
        item.setMemoContents(contentsedit.getText().toString());

        //memoItems.add(item);
        //memoAdapter.notifyDataSetChanged();

        //파이어 베이스 연결된곳
        // 파이어 베이스  memo 에 item 값을 넣습니다.
        databaseReference.child("memo").push().setValue(item);

        databaseReference.child("a");

        //databaseReference.child("memo").child(uid).push().setValue(item);
      //  databaseReference.child("memo").push().setValue(item);
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        addChildEvent();
    }
    private void addChildEvent()
    {
       // memo 의 자식에 이벤트 리스너를 부착 자식으로 추가될떄 이벤트 발생 제거될떄 발생
        databaseReference.child("memo").addChildEventListener(new ChildEventListener()
        {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                Log.d("namjinha", "addChildEvent in");

                // 리얼 타임 데이터 베이스 에서 메모 데이터를 가져옴
                MemoItem item = dataSnapshot.getValue(MemoItem.class);
                //memoItems.add(item);
                // 어뎁터 에 등록
                memoAdapter.items.add(item);

                memoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }
}
