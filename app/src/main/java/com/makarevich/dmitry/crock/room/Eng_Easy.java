package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "eng_easy")
public class Eng_Easy {
    @PrimaryKey(autoGenerate = true)
    private  int id_easy_eng;
    @ColumnInfo(name = "easy_enlish")
    private String easy_eng;

    public int getId_easy_eng() {
        return id_easy_eng;
    }

    public void setId_easy_eng(int id_easy_eng) {
        this.id_easy_eng = id_easy_eng;
    }

    public String getEasy_eng() {
        return easy_eng;
    }

    public void setEasy_eng(String easy_eng) {
        this.easy_eng = easy_eng;
    }
}

