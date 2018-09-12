package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "eng_hard")
public class Eng_Hard {
    @PrimaryKey(autoGenerate = true)
    private  int id_eng_hard;
    @ColumnInfo(name = "hard_english")
    private String hard_eng;

    public int getId_eng_hard() {
        return id_eng_hard;
    }

    public void setId_eng_hard(int id_eng_hard) {
        this.id_eng_hard = id_eng_hard;
    }

    public String getHard_eng() {
        return hard_eng;
    }

    public void setHard_eng(String hard_eng) {
        this.hard_eng = hard_eng;
    }
}

