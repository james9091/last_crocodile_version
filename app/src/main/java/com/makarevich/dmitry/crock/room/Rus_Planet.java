package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "rus_planet")
public class Rus_Planet {
    @PrimaryKey(autoGenerate = true)
    private  int id_rus_planet;
    @ColumnInfo(name = "medium")
    private String planet_rus;

    public int getId_rus_planet() {
        return id_rus_planet;
    }

    public void setId_rus_planet(int id_rus_planet) {
        this.id_rus_planet = id_rus_planet;
    }

    public String getPlanet_rus() {
        return planet_rus;
    }

    public void setPlanet_rus(String planet_rus) {
        this.planet_rus = planet_rus;
    }
}
