package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "es_animal")
public class Es_Animal {
    @PrimaryKey(autoGenerate = true)
    private  int id_animal_es;
    @ColumnInfo(name = "animal_es")
    private String animal_spain;

    public int getId_animal_es() {
        return id_animal_es;
    }

    public void setId_animal_es(int id_animal_es) {
        this.id_animal_es = id_animal_es;
    }

    public String getAnimal_spain() {
        return animal_spain;
    }

    public void setAnimal_spain(String animal_spain) {
        this.animal_spain = animal_spain;
    }
}

