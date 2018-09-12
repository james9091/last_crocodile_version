package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "es_planet")
public class Es_Planet {
    @PrimaryKey(autoGenerate = true)
    private  int id_planet_es;
    @ColumnInfo(name = "planet_es")
    private String planet_spain;

    public int getId_planet_es() {
        return id_planet_es;
    }

    public void setId_planet_es(int id_planet_es) {
        this.id_planet_es = id_planet_es;
    }

    public String getPlanet_spain() {
        return planet_spain;
    }

    public void setPlanet_spain(String planet_spain) {
        this.planet_spain = planet_spain;
    }
}

