package com.example.lecole_des_loustics;

import android.app.Application;
import com.example.lecole_des_loustics.db.User;

public class MyApplication extends Application {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
