package com.example.administrator.mysqlapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Acer on 10/2/2560.
 */

public class TodoListDAO {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public TodoListDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void add(TodoList todoList) {

        TodoList newTodoList = new TodoList();
        newTodoList = todoList;

        ContentValues values = new ContentValues();
        values.put("taskname", newTodoList.getTaskname());
        this.database.insert("tbtodo_list", null, values);

        Log.d("Todo List Demo :::", "Add OK");
    }

    public void update(TodoList todoList){
        TodoList updatetodolist = todoList;
        ContentValues values = new ContentValues();
        values.put("taskname",updatetodolist.getTaskname());
        values.put("taskid", updatetodolist.getTaskid());

        String where = "taskid=" + updatetodolist.getTaskid();
        this.database.update("tbtodo_list", values, where, null);
        Log.d("Todo List Demo :::","update OK !!");
    }

    public void delete(TodoList todoList){
        TodoList deletetodo = todoList;
        String sqlText = "DELETE FROM tbtodo_list WHERE taskid=" + deletetodo.getTaskid();
        this.database.execSQL(sqlText);
    }

    public ArrayList<TodoList> getAlltodoList() {
        ArrayList<TodoList> todoList = new ArrayList<TodoList>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbtodo_list;", null);
        cursor.moveToFirst();
        TodoList todoList1;

        while (!cursor.isAfterLast()) {
            todoList1 = new TodoList();
            todoList1.setTaskid(cursor.getInt(0));
            todoList1.setTaskname(cursor.getString(1));

            todoList.add(todoList1);
            cursor.moveToNext();
        }
        cursor.close();
        return todoList;
    }

}
