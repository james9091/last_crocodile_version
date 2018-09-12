package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "de_easy")
public class De_Easy {
    @PrimaryKey(autoGenerate = true)
    private  int id_de_easy;
    @ColumnInfo(name = "easy_de")
    private String deutch_easy;

    public int getId_de_easy() {
        return id_de_easy;
    }

    public void setId_de_easy(int id_de_easy) {
        this.id_de_easy = id_de_easy;
    }

    public String getDeutch_easy() {
        return deutch_easy;
    }

    public void setDeutch_easy(String deutch_easy) {
        this.deutch_easy = deutch_easy;
    }
}

