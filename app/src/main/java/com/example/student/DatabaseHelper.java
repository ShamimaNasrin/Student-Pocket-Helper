package com.example.student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "userdetails.db";
    private static final String TABLE_NAME = "user_details";
    private static final String ID = "_id";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final int DATABASE_VERSION_NO = 2;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
            "("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            ""+USERNAME+" VARCHAR(20)," +
            ""+PASSWORD+" VARCHAR(7));";

    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
    private Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION_NO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            Toast.makeText(context,"onCreate is called",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }
        catch (Exception e){
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try {
            Toast.makeText(context,"OnUpgrade is called",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(DELETE_TABLE);
            onCreate(sqLiteDatabase);
        }
        catch (Exception e){
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
        }

    }
    public long insertData(UserDetails userDetails){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME,userDetails.getUsername());
        contentValues.put(PASSWORD,userDetails.getPassword());

        long rowID = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowID;
    }

    public Boolean findPassword(String usern,String pass){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        Boolean result = false;
        if(cursor.getCount()==0){
            Toast.makeText(context, "NO DATA FOUND", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                String username = cursor.getString(1);
                String password = cursor.getString(2);
                if(username.equals(usern) && password.equals(pass)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
