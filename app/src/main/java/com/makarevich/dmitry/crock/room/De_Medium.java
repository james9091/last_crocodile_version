package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "de_medium")
public class De_Medium {
    @PrimaryKey(autoGenerate = true)
    private  int id_de_medium;
    @ColumnInfo(name = "medium_de")
    private String deutch_medium;

    public int getId_de_medium() {
        return id_de_medium;
    }

    public void setId_de_medium(int id_de_medium) {
        this.id_de_medium = id_de_medium;
    }

    public String getDeutch_medium() {
        return deutch_medium;
    }

    public void setDeutch_medium(String deutch_medium) {
        this.deutch_medium = deutch_medium;
    }
}

