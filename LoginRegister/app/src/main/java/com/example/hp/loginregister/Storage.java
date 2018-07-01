package com.example.hp.loginregister;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class Storage {

    SQLiteDatabase db;

    Context context;
    Storage(Context context)
    {
        this.context = context;
        db = context.openOrCreateDatabase("userDB", Context.MODE_PRIVATE, null);
    }

    boolean check(String tablename, String password)
    {

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

    void store(String tablename, String password, String email)
    {

        try{
            db.execSQL("CREATE TABLE IF NOT EXISTS " +tablename+ "(username VARCHAR, password VARCHAR, email VARCHAR)");
            db.execSQL("INSERT INTO " +tablename+ " VALUES('" +tablename+ "','" +password+ "','" +email+ "')");
            Toast.makeText(context, "Table Created", Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            throw e;
        }

    }
    ArrayList<String> show(String tablename)
    {
        Cursor c = db.rawQuery("SELECT * FROM " +tablename+ "",null);
        ArrayList<String> notes = new ArrayList<>();
        if(c.moveToFirst()) {
            do {
                if(!c.isAfterLast())
                {
                    do {

                        for(int i=0;i<3;i++)
                        {
                            String note = c.getString(i);
                            notes.add(note);
                        }
                    }while(c.moveToNext());
                }



                //   Log.d("username",note);


            } while (c.moveToNext());
        }
        return notes;
    }
}
