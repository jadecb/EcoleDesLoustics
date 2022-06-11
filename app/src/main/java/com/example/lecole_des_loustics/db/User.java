package com.example.lecole_des_loustics.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int userId;

    @ColumnInfo(name = "firstName")
    private String firstName;

    @ColumnInfo(name = "lastName")
    private String lastName;


    /* Getters and Setters */

    public int getUserId() { return userId; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public void setUserId(int userId) { this.userId = userId; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
