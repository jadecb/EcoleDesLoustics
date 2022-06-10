package com.example.lecole_des_loustics.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(primaryKeys = {"firstName", "lastName"})
public class User implements Serializable {

    @ColumnInfo(name = "firstName")
    private String firstName;

    @ColumnInfo(name = "lastName")
    private String lastName;


    /* Getters and Setters */

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public void setFirstName(String userFirstName) { this.firstName = userFirstName; }

    public void setLastName(String userLastName) {
        this.lastName = userLastName;
    }
}
