package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "de_hard")
public class De_Hard {
    @PrimaryKey(autoGenerate = true)
    private  int id_de_hard;
    @ColumnInfo(name = "hard_de")
    private String deutch_hard;

    public int getId_de_hard() {
        return id_de_hard;
    }

    public void setId_de_hard(int id_de_hard) {
        this.id_de_hard = id_de_hard;
    }

    public String getDeutch_hard() {
        return deutch_hard;
    }

    public void setDeutch_hard(String deutch_hard) {
        this.deutch_hard = deutch_hard;
    }
}

