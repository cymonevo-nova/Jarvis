package com.cymonevo.nova.jarvis.service.db.user.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserData {
    @NonNull
    @PrimaryKey
    public String uuid;
    @ColumnInfo(name = "name")
    public String name;

    public UserData(@NonNull String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }
}
