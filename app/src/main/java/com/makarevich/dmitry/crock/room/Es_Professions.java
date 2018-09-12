package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "es_professions")
public class Es_Professions {
    @PrimaryKey(autoGenerate = true)
    private  int id_professions_es;
    @ColumnInfo(name = "professions_es")
    private String profesions_spain;

    public int getId_professions_es() {
        return id_professions_es;
    }

    public void setId_professions_es(int id_professions_es) {
        this.id_professions_es = id_professions_es;
    }

    public String getProfesions_spain() {
        return profesions_spain;
    }

    public void setProfesions_spain(String profesions_spain) {
        this.profesions_spain = profesions_spain;
    }
}

