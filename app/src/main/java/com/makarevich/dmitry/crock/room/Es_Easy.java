package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "es_easy")
public class Es_Easy {
    @PrimaryKey(autoGenerate = true)
    private  int id_easy_es;
    @ColumnInfo(name = "easy_es")
    private String spain_easy;

    public int getId_easy_es() {
        return id_easy_es;
    }

    public void setId_easy_es(int id_easy_es) {
        this.id_easy_es = id_easy_es;
    }

    public String getSpain_easy() {
        return spain_easy;
    }

    public void setSpain_easy(String spain_easy) {
        this.spain_easy = spain_easy;
    }
}

