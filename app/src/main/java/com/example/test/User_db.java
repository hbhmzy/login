package com.example.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018/2/4.
 */

public class User_db extends SQLiteOpenHelper {

    public static final String CREATE_USERDATA="create table userData(" +
            "id integer primary key autoincrement,"
            +"nametext,"
            +"password text)";


    private Context mContext;


    public User_db(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERDATA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
