package de.hsos.ersti_app;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrej on 22.08.2017.
 */
public class MyVariable extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(sharedPreferences.getAll() == null){
            Set<String> checked = new HashSet<String>();
            editor.putStringSet("list", checked);
            editor.commit();
        }
    }



    //The Variable will be saved either when you close your app
    public void SaveVariables(String checked, Set set) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet(checked, set);
        editor.apply();
    }


    public Set LoadSet(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> fetch = sharedPreferences.getStringSet("list", null);
        return fetch;
    }


    public void DeleteInt(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        Set<String> checked = new HashSet<String>();
        editor.putStringSet("checked", checked);
        editor.commit();
    }

    public Set getCheckedList(){
        return LoadSet();
    }

    public void setStudentVariable(String name){
        if(!getCheckedList().contains(name)){
            getCheckedList().add(name);
            SaveVariables("checked", getCheckedList());
        }
    }

    public int getListNum(){
        int zahl = 0;
        for (int i = 0; i < getCheckedList().size(); i++){
            zahl += 10;
        }
        return zahl;
    }
}