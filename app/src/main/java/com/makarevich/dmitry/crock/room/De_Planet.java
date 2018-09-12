package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "de_planet")
public class De_Planet {
    @PrimaryKey(autoGenerate = true)
    private  int id_de_planet;
    @ColumnInfo(name = "planet_de")
    private String deutch_planet;

    public int getId_de_planet() {
        return id_de_planet;
    }

    public void setId_de_planet(int id_de_planet) {
        this.id_de_planet = id_de_planet;
    }

    public String getDeutch_planet() {
        return deutch_planet;
    }

    public void setDeutch_planet(String deutch_planet) {
        this.deutch_planet = deutch_planet;
    }
}

