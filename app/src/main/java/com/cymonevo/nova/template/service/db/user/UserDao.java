package com.cymonevo.nova.template.service.db.user;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.cymonevo.nova.template.service.db.user.entity.UserData;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<UserData> getAll();
    @Insert
    void insert(UserData user);
    @Delete
    void delete(UserData user);
}
