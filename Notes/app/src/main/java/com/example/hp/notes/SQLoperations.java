package com.example.hp.notes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class SQLoperations {
    Context context;
    SQLiteDatabase db;
    private static SQLoperations sqLoperations;

    public SQLoperations(Context context) {
        this.context = context;
        db = context.openOrCreateDatabase("userDB",MODE_PRIVATE,null);
    }





    void createTable(String tablename) {

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS " +tablename+ "(notes VARCHAR)");
        } catch (Exception e) {
            throw e;
        }

    }

    void insert(String tablename,String note) {

        db.execSQL("INSERT INTO " +tablename+ " VALUES('" +note+ "')");

    }




    boolean checkTable(String tablename) {
        Cursor c = null;
        /* get cursor on it */
        try
        {
            c = db.query(tablename, null,
                    null, null, null, null, null);
        }
        catch (Exception e) {
            /* fail */
            return false;
        }
        return true;
    }


    ArrayList<String> getNotes(String tablename) {
        Cursor c = db.rawQuery("SELECT * FROM " +tablename+ "",null);
        ArrayList<String> notes = new ArrayList<>();
        if(c.moveToFirst()) {
            do {
                int index = c.getColumnIndex("notes");
                String note = c.getString(index);
                //   Log.d("username",note);
                notes.add(note);
            } while (c.moveToNext());
        }
        return  notes;
    }


}
