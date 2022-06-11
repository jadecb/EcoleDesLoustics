package com.example.lecole_des_loustics.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM user ORDER BY lastName, firstName")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE firstName LIKE :first AND " + "lastName LIKE :last LIMIT 1")
    User getUserByName(String first, String last);

    @Query("SELECT * FROM user WHERE userID=:id")
    User getUserById(int id);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}
