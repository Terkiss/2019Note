package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtDb;
    EditText edtTb;

    String dbName, tableName;

    TextView status ;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_dataBaseGen = findViewById(R.id.createDb);
        Button btn_tableGen = findViewById(R.id.createTb);

        edtDb = findViewById(R.id.edtDbName);
        edtTb = findViewById(R.id.edtTbName);


        status = findViewById(R.id.status);

        btn_dataBaseGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbName = edtDb.getText().toString();
                createDataBase(dbName);
            }
        });

        btn_tableGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableName = edtTb.getText().toString();
                createTable(tableName);
                //int count = inserRecord(tableName);
                //println(count+"개의 레코드를 입력하였습니다.");
            }
        });

    }


    /**
     * 텍스트 뷰에 게속해서 붙여
     * @param str
     */
    public void println(String str)
    {
        Log.d("J", "\n"+str);
        status.append("\n"+str);
    }



    public void createDataBase(String dataBaseName)
    {
        // 데이터 베이스가 존재하면 오픈 존재 하지 않으면 생성
        db = openOrCreateDatabase(dataBaseName, MODE_PRIVATE, null);
        println("["+dataBaseName+"] 데이터베이스 생성이 완료되었습니다.");
    }
    public void createTable(String str)
    {
        if(db != null)
        {
            // 테이블 이 존재하지 않을떄만 생성
            String sql = "create table if not exists "+str+"(_id integer PRIMARY KEY autoincrement,"
                            +"name text,"
                            +"age integer,"
                            +"phone text);";

            db.execSQL(sql);

            println("["+str+"] 테이블 생성이 완료되었습니다.");
        }
    }


    /**
     * 이데이터를 입력 해달라
     * 전통적인 방법
     * @param tbName
     * @return
     */
    public int inserRecord(String tbName)
    {
        if(db != null)
        {
            db.execSQL("insert into "+tbName+"(name, age, phone) values('John', 20, '010-1000-1000');");
            db.execSQL("insert into "+tbName+"(name, age, phone) values('Mike', 26, '010-2000-2000');");
            db.execSQL("insert into "+tbName+"(name, age, phone) values('Sean', 35, '010-3000-3000');");

            return 3;
        }
        return -1;

    }


  // costomer.db costomer

    public void update_Click(View view) {
        //db.execSQL("update "+tableName+" set age=50 where name='Rice';");
        ContentValues record_Value = new ContentValues();
        record_Value.put("age",40);
        String args[] = {"Rice"};


        

        int count = db.update(tableName, record_Value, "name=?", args);

        println("["+tableName+"] 테이블에 "+count+"개의 데이터를 수정 하였씁니다.");
    }

    public void delete_Click(View view) {

        //db.execSQL("delete from "+tableName+" where age>=40;");

        String args[] = {"Rice"};
        int count = db.delete(tableName, "name =?", args);

        println("["+tableName+"] 테이블에 "+count+"개의 데이터를 삭제 하였씁니다.");
    }


    /**
     * 입력 버튼
     * @param view
     */
    public void insert_Click(View view) {
        ContentValues recordValue = new ContentValues();

        // 키 에다가는 해당 레코드의 필드 명을 입력
        recordValue.put("name", "Rice");
        recordValue.put("age", 20);
        recordValue.put("phone", "010-1000-1000");

        // db.insert(테이블명, 공백 필드명, 레코드 벨류 데이터)
        db.insert(tableName, null, recordValue);
        println("["+tableName+"] 테이블에 1개의 데이터를 입력하였습니다.");
    }
}
