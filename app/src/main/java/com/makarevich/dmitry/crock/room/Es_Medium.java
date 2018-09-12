package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "es_medium")
public class Es_Medium {
    @PrimaryKey(autoGenerate = true)
    private  int id_medium_es;
    @ColumnInfo(name = "medium_es")
    private String spain_medium;

    public int getId_medium_es() {
        return id_medium_es;
    }

    public void setId_medium_es(int id_medium_es) {
        this.id_medium_es = id_medium_es;
    }

    public String getSpain_medium() {
        return spain_medium;
    }

    public void setSpain_medium(String spain_medium) {
        this.spain_medium = spain_medium;
    }
}

