package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
@Entity(tableName = "rus_medium")
public class Rus_M {
    @PrimaryKey(autoGenerate = true)
    private  int id_rus_medium;
    @ColumnInfo(name = "medium")
    private String medium_rus;

    public String getMedium_rus() {
        return medium_rus;
    }

    public void setMedium_rus(String medium_rus) {
        this.medium_rus = medium_rus;
    }

    public int getId_rus_medium() {
        return id_rus_medium;
    }

    public void setId_rus_medium(int id_rus_medium) {
        this.id_rus_medium = id_rus_medium;
    }
}
