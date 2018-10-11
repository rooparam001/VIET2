package com.viet.rooparam.viet2.Utility;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private final String PREFRENCE_NAME = "VIET";

    public static final String KEY_USERTYPE = "usertype";
    public static final String KEY_ROLL_NUMBER = "roll_number";
    public static final String LOGIN = "false";
    Context context;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFRENCE_NAME, Context.MODE_PRIVATE);
    }

    public void CreateLogin(String login, String usertype, String roll_number)
    {
        editor = sharedPreferences.edit();
        editor.putString(LOGIN, login);
        editor.putString(KEY_USERTYPE, usertype);
        editor.putString(KEY_ROLL_NUMBER, roll_number);
        editor.apply();
    }

    public void LogOut(String login) {
        editor = sharedPreferences.edit();
        editor.putString(LOGIN, login);
        editor.commit();
    }

    public boolean isLoggedIn()
    {
        if (sharedPreferences.getString(LOGIN,"").equalsIgnoreCase("true"))
        {return true;}
        else
        { return false; }
    }

    public HashMap<String, String> getData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(LOGIN, sharedPreferences.getString(LOGIN, ""));
        hashMap.put(KEY_USERTYPE, sharedPreferences.getString(KEY_USERTYPE, ""));
        hashMap.put(KEY_ROLL_NUMBER, sharedPreferences.getString(KEY_ROLL_NUMBER, ""));
        return hashMap;
    }
}