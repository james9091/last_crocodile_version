package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "eng_medium")
public class Eng_Medium {
    @PrimaryKey(autoGenerate = true)
    private int id_eng_medium;
    @ColumnInfo(name = "medium_english")
    private String medium_eng;

    public int getId_eng_medium() {
        return id_eng_medium;
    }

    public void setId_eng_medium(int id_eng_medium) {
        this.id_eng_medium = id_eng_medium;
    }

    public String getMedium_eng() {
        return medium_eng;
    }

    public void setMedium_eng(String medium_eng) {
        this.medium_eng = medium_eng;
    }
}

