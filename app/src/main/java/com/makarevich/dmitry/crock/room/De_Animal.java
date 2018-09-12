package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "de_animal")
public class De_Animal {
    @PrimaryKey(autoGenerate = true)
    private  int id_de_animal;
    @ColumnInfo(name = "animal_de")
    private String deutch_animal;

    public int getId_de_animal() {
        return id_de_animal;
    }

    public void setId_de_animal(int id_de_animal) {
        this.id_de_animal = id_de_animal;
    }

    public String getDeutch_animal() {
        return deutch_animal;
    }

    public void setDeutch_animal(String deutch_animal) {
        this.deutch_animal = deutch_animal;
    }
}

