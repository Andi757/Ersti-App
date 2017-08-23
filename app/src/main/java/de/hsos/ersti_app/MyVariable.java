package de.hsos.ersti_app;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;
import java.util.HashSet;
import java.util.Set;


public class MyVariable extends Application {

  /*  SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;*/
   public Set<String> checked = new HashSet<String>();
    @Override
    public void onCreate() {

        super.onCreate();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(getCheckedList() != null){
            Set<String> set = getCheckedList();
            for(String str: set){
                checked.add(str);
            }
        }
        if(sharedPreferences == null){
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            editor = sharedPreferences.edit();
            editor.putStringSet("list", checked);
            editor.apply();
            editor.commit();
        }
    }

    public void SaveVariables(String list, Set set) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet(list, set);
        editor.apply();
        editor.commit();
    }

    public Set LoadSet(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Set<String> fetch = sharedPreferences.getStringSet("list", checked);
        return fetch;
    }

    public void DeleteInt(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        checked.clear();
        //Set<String> checked = new HashSet<String>();
        editor.putStringSet("list", checked);
        editor.apply();
        editor.commit();
    }

    public Set getCheckedList(){
        return LoadSet();
    }

    public void setStudentVariable(String name){
        if (getCheckedList()==null){
            DeleteInt();
        }if (!getCheckedList().contains(name)){
            checked.add(name);
            SaveVariables("list", checked);
        }else {
            Toast.makeText(this, "Bereits gescannt!", Toast.LENGTH_SHORT).show();
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