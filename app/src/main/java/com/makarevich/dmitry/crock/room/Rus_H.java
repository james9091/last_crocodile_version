package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
@Entity(tableName = "rus_hard")
public class Rus_H {
    @PrimaryKey(autoGenerate = true)
    private  int id_rus_hard;
    @ColumnInfo(name = "medium")
    private String hard_rus;

    public String getHard_rus() {
        return hard_rus;
    }

    public void setHard_rus(String hard_rus) {
        this.hard_rus = hard_rus;
    }

    public int getId_rus_hard() {
        return id_rus_hard;
    }

    public void setId_rus_hard(int id_rus_hard) {
        this.id_rus_hard = id_rus_hard;
    }
}
