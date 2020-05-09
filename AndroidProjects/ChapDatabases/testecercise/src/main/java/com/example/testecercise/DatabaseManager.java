package com.example.testecercise;

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

    String Db_Name = "";

    // 데이터 베이스의 버전
    int version = 4;

    Context context;
    DatabaseHelper myDBHelper = null;
    SQLiteDatabase db;
    String TableCreateSQL = "";

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
    public DatabaseManager initialization(@NonNull Context context, @NonNull String dbName, @NonNull String tableSql)
    {
        if(this.context == null ||myDBHelper == null)
        {
            this.Db_Name = dbName;
            this.TableCreateSQL = tableSql;
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

    public void deleteDataForTable(String _TableName)
    {
        String sql = "DELETE FROM "+_TableName+";";

        executeSQL(sql);
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
            JeongLog.log.logD("데이터 베이스 생성  이 완료 되었습니다 ");

            if(TableCreateSQL.length() > 0)
            {
                executeSQL(TableCreateSQL);
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if(newVersion > oldVersion)
            {
                String sql = "drop table numberBook;";
                JeongLog.log.logD("데이터 베이스 테이블 제거 ");
                JeongLog.log.logD("테이블 재생성 ");
                db.execSQL(sql);
                if(TableCreateSQL.length() > 0)
                {

                    db.execSQL(TableCreateSQL);
                }
            }
        }
    }

}
