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

    public Set<String> checked = new HashSet<String>();

    //The Variable will be saved either when you close your app
    public void SaveVariables(String list, Set set) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet(list, set);
        editor.apply();
    }


    public Set LoadSet(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> fetch = sharedPreferences.getStringSet("list", null);
        return fetch;
    }


    public void DeleteInt(){
        /*SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove();
        editor.commit();*/
        getCheckedList().clear();
    }

    public Set getCheckedList(){
        return LoadSet();
    }

    public void setStudentVariable(String name){
        if(!getCheckedList().contains(name)){
            getCheckedList().add(name);
            SaveVariables("list", getCheckedList());
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