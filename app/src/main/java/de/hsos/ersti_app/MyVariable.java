package de.hsos.ersti_app;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Andrej on 22.08.2017.
 */

public class MyVariable extends Application {

    private int studentVariable = 0;
    public ArrayList<String> checked = new ArrayList<String>();


    public int getStudentVarible(){
        return studentVariable;
    }

    public void setStudentVarible(String name){
        for(String s: checked){
            if(s.equals(name)){
                this.studentVariable += 10;
                checked.add(name);
                break;
            }
        }
    }
}
