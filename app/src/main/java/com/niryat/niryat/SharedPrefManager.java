package com.niryat.niryat;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {


   private static com.niryat.niryat.SharedPrefManager mInstance;
private     static final String SHARE_PREF_NAME = "mysharedpref";

    private static final String KEY_EMAIL = "email";
    private static final String KEY_NAME = "name";
    private static final String KEY_MOBILENO = "moblieno";


    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;

    }

    public static synchronized com.niryat.niryat.SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new com.niryat.niryat.SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(String email, String name, String mobileno) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_NAME,name);
        editor.putString(KEY_MOBILENO,mobileno);
        editor.apply();
        return true;
    }

    public boolean isLogIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_NAME, null)!=null) {
            return true;
        }
        return false;
    }

    public boolean logout() {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }

    public String getEmail() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
return sharedPreferences.getString(KEY_EMAIL,null);
    }


    public String getName() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_EMAIL,null);
    }

}