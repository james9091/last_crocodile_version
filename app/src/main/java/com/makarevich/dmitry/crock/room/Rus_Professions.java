package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "rus_professions")
public class Rus_Professions {
    @PrimaryKey(autoGenerate = true)
    private  int id_rus_professions;
    @ColumnInfo(name = "medium")
    private String professions_rus;

    public int getId_rus_professions() {
        return id_rus_professions;
    }

    public void setId_rus_professions(int id_rus_professions) {
        this.id_rus_professions = id_rus_professions;
    }

    public String getProfessions_rus() {
        return professions_rus;
    }

    public void setProfessions_rus(String professions_rus) {
        this.professions_rus = professions_rus;
    }
}
