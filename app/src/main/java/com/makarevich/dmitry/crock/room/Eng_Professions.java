package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "eng_professions")
public class Eng_Professions {
    @PrimaryKey(autoGenerate = true)
    private  int id_eng_professions;
    @ColumnInfo(name = "professions_english")
    private String professions_eng;

    public int getId_eng_professions() {
        return id_eng_professions;
    }

    public void setId_eng_professions(int id_eng_professions) {
        this.id_eng_professions = id_eng_professions;
    }

    public String getProfessions_eng() {
        return professions_eng;
    }

    public void setProfessions_eng(String professions_eng) {
        this.professions_eng = professions_eng;
    }
}

