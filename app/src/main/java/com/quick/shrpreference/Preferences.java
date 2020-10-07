package com.quick.shrpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

public class Preferences {
    private SharedPreferences pref;
    private static final String PREF_NAME = "session";
    private final String KEY_IS_LOGIN ="isLogin";

    static final String KEY_USERNAME = "username";
    static final String KEY_PASSWORD = "password";


    Context mContext;

    Preferences(Context context){
        mContext = context;
        pref = mContext.getSharedPreferences(PREF_NAME, 0);

    }

    void createUserSession(String username, String password){
        SharedPreferences.Editor edit;
        edit= pref.edit();

        edit.putBoolean(KEY_IS_LOGIN, true);
        edit.putString(KEY_USERNAME, username);
        edit.putString(KEY_PASSWORD, password);

        edit.apply();
    }

    HashMap<String, String> getUserData(){
        HashMap<String , String> userData = new HashMap<>();

        userData.put(KEY_USERNAME, pref.getString(KEY_USERNAME, null));
        userData.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));

        return userData;
    }

    String getUser() {
        return pref.getString(KEY_USERNAME, "");
    }

    Boolean isUserLogin() {
        return pref.getBoolean(KEY_IS_LOGIN, false);
    }

    public void logoutUser(){
        pref.edit().clear().apply();

        Intent i = new Intent(mContext, MainActivity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        mContext.startActivity(i);
    }
}
