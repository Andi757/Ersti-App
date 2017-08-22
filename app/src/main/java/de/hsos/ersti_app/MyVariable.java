package de.hsos.ersti_app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Andrej on 22.08.2017.
 */

public class MyVariable extends Application {

    private int studentVariable = 0;
    public Set<String> checked = new HashSet<String>();


    //The Variable will be saved either when you close your app
    public void SaveInt(String key, int value, String list, Set set) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.putStringSet(list, set);
        editor.commit();
    }

    public int LoadInt(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int savedValue = sharedPreferences.getInt("key", 0);
        return savedValue;
    }

    public Set LoadSet() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Set<String> fetch = sharedPreferences.getStringSet("list", null);
        return fetch;
    }

    public void DeleteInt(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }



    public int getStudentVariable(){
        return LoadInt();
    }

    public void setStudentVariable(String name){
        if(!checked.contains(name)){
            checked.add(name);
            studentVariable += 10;
            SaveInt("key", studentVariable,"list", checked);
        }
    }
    public int getListItem(String name){
        if(checked.contains(name)){
            return 1;
        }else {
            return 0;
        }
    }
}
