package com.example.database_ex2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText db_Name;
    TextView status;

    ListView listView;

    String databaseName ;

    DatabaseHelper dbHelper;

    SQLiteDatabase db;
    int version = 4;

    String table_Name = "customer";


    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db_Name = findViewById(R.id.editText);


        status = findViewById(R.id.textView);
        Button query_Btn = findViewById(R.id.button);
        listView =findViewById(R.id.listView);
        context =this;
        query_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseName = db_Name.getText().toString();
                println("data base Name ::"+databaseName);
                boolean open =  createDataBase();

                if(open)
                {
                    Cursor cursor = executeQurry();
                    String[] columns = {"name", "age", "phone"};
                    int[] to = {R.id.list_name, R.id.list_age, R.id.list_phone};
                    SimpleCursorAdapter adapter = new SimpleCursorAdapter(context, R.layout.list_layout, cursor,columns, to);
                    listView.setAdapter(adapter);
                }
            }
        });
    }


    // 데이터 베이스 헬퍼
    public boolean createDataBase()
    {
       dbHelper =  new DatabaseHelper(this);
       db = dbHelper.getWritableDatabase(); // 읽기 전용 ?  읽기 쓰기 형태

       return  true;

    }

    class DatabaseHelper extends SQLiteOpenHelper
    {
        public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        public DatabaseHelper(Context context)
        {
            super(context, databaseName, null, version);
            println("["+databaseName+"] 데이터 베이스가 생성 되었습니다.");
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("drop table if exists "+table_Name+";");
            String sql = "create table if not exists "+table_Name+"(_id integer PRIMARY KEY autoincrement,"
                    +"name text,"
                    +"age integer,"
                    +"phone text);";
            db.execSQL(sql);
            println("["+table_Name+"] 테이블 생성이 완료되었습니다.");


            db.execSQL("insert into "+table_Name+" (name, age, phone) values ('John', 20, '010-1000-1000');");
            db.execSQL("insert into "+table_Name+" (name, age, phone) values ('Mike', 26, '010-2000-2000');");
            db.execSQL("insert into "+table_Name+" (name, age, phone) values ('Sean', 35, '010-3000-3000');");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            println(oldVersion+"에서 "+newVersion+" 으로 수정 합니다");
            println("manager 테이블 을 추가로 생성 합니다.");
            String sql = "create table if not exists manager3(_id integer PRIMARY KEY autoincrement,"
                    +"name text,"
                    +"age integer,"
                    +"phone text);";
            db.execSQL(sql);


            db.execSQL("insert into manager3 (name, age, phone) values ('Twice', 20, '010-1000-1000');");
            db.execSQL("insert into manager3(name, age, phone) values ('ITZY', 26, '010-2000-2000');");
            db.execSQL("insert into manager3(name, age, phone) values ('Black Pink', 35, '010-3000-3000');");



            String query = "select _id, name, age, phone from manager3;";
           // String quert2 = "select _id, name, age, phone from "+tableName+" where age >?;";
            String[] args = {"30"};

            //Cursor cursor = db.rawQuery(quert2, args);

            Cursor cursor = db.rawQuery(query, null);

            int recordCount = cursor.getCount();

            for(int i = 0 ; i < recordCount; i++)
            {
                cursor.moveToNext();
                String name = cursor.getString(1);
                int age = cursor.getInt(2);
                String phon = cursor.getString(3);

                println("record :: "+i+" : "+name+","+age+","+phon );
            }
        }

        @Override
        public void onOpen(SQLiteDatabase db)
        {
            println("["+databaseName+"] 데이터 베이스와 "+table_Name+"테이블을 열었습니다.");

        }
    }
    public void println(String msg)
    {
        Log.d("J", "\n "+msg);
        status.append("\n "+msg);
    }

    public Cursor  executeQurry()
    {
        String query = "select _id, name, age, phone from "+table_Name+";";
        String quert2 = "select _id, name, age, phone from "+table_Name+" where age >?;";
        String[] args = {"30"};

        //Cursor cursor = db.rawQuery(quert2, args);

        Cursor cursor = db.rawQuery(query, null);

        int recordCount = cursor.getCount();

        for(int i = 0 ; i < recordCount; i++)
        {
            cursor.moveToNext();
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String phon = cursor.getString(3);

            println("record :: "+i+" : "+name+","+age+","+phon );
        }
        return cursor;
    }
}
