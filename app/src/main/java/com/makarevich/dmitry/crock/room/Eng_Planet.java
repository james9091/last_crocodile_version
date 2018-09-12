package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "eng_planet")
public class Eng_Planet {
    @PrimaryKey(autoGenerate = true)
    private  int id_eng_planet;
    @ColumnInfo(name = "planet_english")
    private String planet_eng;

    public int getId_eng_planet() {
        return id_eng_planet;
    }

    public void setId_eng_planet(int id_eng_planet) {
        this.id_eng_planet = id_eng_planet;
    }

    public String getPlanet_eng() {
        return planet_eng;
    }

    public void setPlanet_eng(String planet_eng) {
        this.planet_eng = planet_eng;
    }
}

