package com.example.administrator.mysqlapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Acer on 10/2/2560.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static  final String databaseName = "dbtodolist.sqlite";
    private static  final int databaseVesion = 1;
    Context myContext;

    private static final String SQlCreateTable =
            "CREATE TABLE tbtodo_list(taskid INTEGER PRIMARY KEY AUTOINCREMENT,taskname TEXT)";

    public DbHelper(Context context){
        super(context, databaseName, null,databaseVesion );
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQlCreateTable);
        String insertData1 = "INSERT INTO tbtodo_list (taskname) VALUES ('a1')";
        String insertData2 = "INSERT INTO tbtodo_list (taskname) VALUES ('a2')";
        String insertData3 = "INSERT INTO tbtodo_list (taskname) VALUES ('a3')";
        String insertData4 = "INSERT INTO tbtodo_list (taskname) VALUES ('a4')";
        String insertData5 = "INSERT INTO tbtodo_list (taskname) VALUES ('a5')";
        db.execSQL(insertData1);
        db.execSQL(insertData2);
        db.execSQL(insertData3);
        db.execSQL(insertData4);
        db.execSQL(insertData5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
