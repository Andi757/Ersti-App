package de.hsos.ersti_app;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;

/**
 * Created by Andrej on 22.08.2017.
 */

public class MyVariable extends Application {


    private int studentVariable = 0;
    public ArrayList<String> checked = new ArrayList<String>();
    
    //The Variable will be saved either when you close your app
    public void SaveInt(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public int LoadInt(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int savedValue = sharedPreferences.getInt("key", 0);
        return savedValue;
    }

    public int getStudentVariable(){
        return LoadInt();
    }

    public void setStudentVariable(String name){
        if(!checked.contains(name)){
            checked.add(name);
            studentVariable += 10;
            SaveInt("key", studentVariable);
        }
    }
}
