package com.example.hp.notes;


import android.content.Context;
import android.content.SharedPreferences;

import java.util.prefs.Preferences;

public class Prefrences {

    Context context;
    SharedPreferences sharedPreferences;
    private final String username = "username";
    private final String passwor = "password";
    private final String isLogIn = "IsLogin";
    private static Prefrences prefrences;

    public Prefrences(Context context) {
        this.context =  context;
        sharedPreferences = context.getSharedPreferences("prefs",Context.MODE_PRIVATE);
    }




    void createUser(String name, String password) {

        //sharedpre.edit.put("username",value);
        sharedPreferences.edit().putString(username,name).apply();
        sharedPreferences.edit().putString(passwor,password).apply();
        sharedPreferences.edit().putBoolean(isLogIn,true).apply();
    }

    String getUserName() {
        return sharedPreferences.getString(username,"");
    }

    boolean isLogin() {
        return  sharedPreferences.getBoolean(isLogIn,false);
    }

    void logOut() {
        sharedPreferences.edit().putBoolean(isLogIn,false).apply();
    }
}
