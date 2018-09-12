package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "es_hard")
public class Es_Hard {
    @PrimaryKey(autoGenerate = true)
    private  int id_hard_es;
    @ColumnInfo(name = "hard_es")
    private String hard_spain;

    public int getId_hard_es() {
        return id_hard_es;
    }

    public void setId_hard_es(int id_hard_es) {
        this.id_hard_es = id_hard_es;
    }

    public String getHard_spain() {
        return hard_spain;
    }

    public void setHard_spain(String hard_spain) {
        this.hard_spain = hard_spain;
    }
}

