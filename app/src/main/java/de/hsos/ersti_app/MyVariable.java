package de.hsos.ersti_app;

import android.app.Application;

/**
 * Created by Andrej on 22.08.2017.
 */

public class MyVariable extends Application {

    private int studentVarible = 0;

    public int getStudentVarible(){
        return studentVarible;
    }

    public void setStudentVarible(int increase){
        this.studentVarible += increase;
    }
}
