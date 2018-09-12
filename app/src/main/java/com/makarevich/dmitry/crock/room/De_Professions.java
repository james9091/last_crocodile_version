package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "de_professions")
public class De_Professions {
    @PrimaryKey(autoGenerate = true)
    private  int id_de_professions;
    @ColumnInfo(name = "professions_de")
    private String deutch_professions;

    public int getId_de_professions() {
        return id_de_professions;
    }

    public void setId_de_professions(int id_de_professions) {
        this.id_de_professions = id_de_professions;
    }

    public String getDeutch_professions() {
        return deutch_professions;
    }

    public void setDeutch_professions(String deutch_professions) {
        this.deutch_professions = deutch_professions;
    }
}

