package de.hsos.ersti_app;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrej on 22.08.2017.
 */
public class MyVariable extends Application {

    private int studentVariable = 0;
    public Set<String> checked = new HashSet<String>();

    //The Variable will be saved either when you close your app
    public void SaveVariables(String key, int value, String list, Set set) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.putStringSet(list, set);
        editor.apply();
    }
    public int LoadInt(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int savedValue = sharedPreferences.getInt("key", 0);
        return savedValue;
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
        editor.commit();
    }


    public int getStudentVariable(){
        return LoadInt();
    }

    public Set getCheckedList(){
        return LoadSet();
    }

    public void setStudentVariable(String name){
        if(!checked.contains(name)){
            checked.add(name);
            studentVariable += 10;
            SaveVariables("key", studentVariable,"list", checked);
        }
    }
    public String[] listToString(){
        String[] done=new String[9];
        while (!getCheckedList().isEmpty()){
            if(getCheckedList().contains("mensa")){
                done[0]="Mensa";
            }else if (getCheckedList().contains("bib")){
                done[1]="Bibliothek";
            }
        }
        return done;
    }
    public int getListItem(String name){
        if(getCheckedList().contains(name)){
            return 1;
        }else {
            return 0;
        }
    }
}
