package com.uiapp.doan.interactor.prefer;

import android.content.SharedPreferences;

/**
 * Created by hongnhung on 10/23/16.
 */

public class PreferManager {
    SharedPreferences mSharedPreferences;

    public PreferManager(SharedPreferences preferences){
        this.mSharedPreferences=preferences;
    }


    public String getKeyValueByKeyName( String keyName) {
        return mSharedPreferences.getString(keyName,null);
    }


    public void setKeyValueByKeyName(String keyName, String keyValue) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(keyName, keyValue);
        editor.apply();
    }


    public void removeKeyValueByKeyName(String keyName) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.remove(keyName);
        editor.apply();
    }
}
