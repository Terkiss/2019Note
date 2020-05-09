package com.example.database_ex5;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseManager {
    public static DatabaseManager _Instance = new DatabaseManager();

    private DatabaseManager(){

    }

    String Db_Name = "myDB.db";

    int version = 1;
    Context context;
    DatabaseHelper myDBHelper = null;
    SQLiteDatabase db;
    String TableCreateSQL = "create table myDiary(diaryDate char(10), content varchar(500));";

    public DatabaseManager initialization(@NonNull Context context, @NonNull String dbName)
    {
        if(this.context == null ||myDBHelper == null)
        {
            this.Db_Name = dbName;
            JeongLog.log.logD("데이터 베이스 생성 합니다 . 이를 위해 컨트렉트 변수를 이용합니다 . ");
            this.context = context;
            myDBHelper = new DatabaseHelper(context);


            // 데이터 베이스 읽고 쓰기 가능 모드로 오픈
            db = myDBHelper.getWritableDatabase();
        }
        else
        {
            JeongLog.log.logD("데이터가 이미 있으므로 현재의 객체만 넘깁니다.");
        }
        return _Instance;
    }

    public void dbOpen(){
        db = myDBHelper.getWritableDatabase();
    }

    public void executeSQL(String SQL)
    {
        db.execSQL(SQL);
    }

    public  void CreateTable(@NonNull String _TableName, @NonNull String[] args)
    {
        String temp ="";
        for(int i = 0; i < args.length; i++)
        {
            temp += args[i]+", ";
        }
        String sql = "create table "+_TableName+"("+temp+");";

        db.execSQL(sql);
    }
    public void insertData(String _TableName, String[] filedName, String[] data){
        String filed ="";
        String Riddle="(";

        for(int i = 0; i<filedName.length; i++)
        {
            if(i == filedName.length-1)
            {
                filed += filedName[i];
                Riddle +="?);";
                break;
            }
            filed += filedName[i]+", ";
            Riddle +="?, ";
        }
        String sql = "insert into "+_TableName+"("+filed+") values"+Riddle;
        JeongLog.log.logD(sql);
        db.execSQL(sql, data);
    }
    public void deleteData(String _TableName, String fieldName, String[] args)
    {
        String sql = "delete from "+_TableName+" where "+fieldName+" =?";
        db.execSQL(sql, args);
    }

    public Cursor selectdata(String sql){
        Cursor cursor = db.rawQuery(sql,null);
        return cursor;
    }



    private class DatabaseHelper extends SQLiteOpenHelper
    {
        // 헬퍼 생성
        public DatabaseHelper(@Nullable Context context)
        {
            super(context, Db_Name, null, version);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            JeongLog.log.logD(TableCreateSQL);
            db.execSQL(TableCreateSQL);
            JeongLog.log.logD("테이블 생성 이 완료 되었습니다 ");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
