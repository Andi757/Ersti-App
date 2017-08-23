package de.hsos.ersti_app;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.HashSet;
import java.util.Set;


public class MyVariable extends Application {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Set<String> checked;

    @Override
    public void onCreate() {

        super.onCreate();
        /*if(sharedPreferences.getAll() == null){
            checked = new HashSet<String>();
            editor.putStringSet("checked", checked);
            editor.commit();
        }*/
        if(sharedPreferences == null){
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            editor = sharedPreferences.edit();
            checked = new HashSet<String>();
            editor.putStringSet("checked", checked);
            editor.commit();
        }

    }

    //The Variable will be saved either when you close your app
    public void SaveVariables(String checked, Set set) {
        editor.putStringSet(checked, set);
        editor.apply();
    }


    public Set LoadSet(){
        Set<String> fetch = sharedPreferences.getStringSet("checked", null);
        return fetch;
    }


    public void DeleteInt(){
        editor.clear();
        Set<String> checked = new HashSet<String>();
        editor.putStringSet("checked", checked);
        editor.commit();
    }

    public Set getCheckedList(){
        return LoadSet();
    }

    public void setStudentVariable(String name){
        if(getCheckedList() == null){
            getCheckedList().add(name);
            SaveVariables("checked", getCheckedList());
        }else if(!getCheckedList().contains(name)){
            getCheckedList().add(name);
            SaveVariables("checked", getCheckedList());
        }
    }

    public int getListNum(){
        int zahl = 0;
        if(getCheckedList() != null){
            for (int i = 0; i < getCheckedList().size(); i++){
                zahl += 10;
            }
        }
        return zahl;
    }
}