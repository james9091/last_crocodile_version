package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "rus_easy")
public class Words {
    @PrimaryKey(autoGenerate = true)
    private  int id;
    @ColumnInfo(name = "easy")
    private String easy_rus;

    public String getEasy_rus() {
        return easy_rus;
    }

    public void setEasy_rus(String easy_rus) {
        this.easy_rus = easy_rus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

