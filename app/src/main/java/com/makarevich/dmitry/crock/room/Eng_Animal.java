package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "eng_animal")
public class Eng_Animal {
    @PrimaryKey(autoGenerate = true)
    private  int id_eng_animal;
    @ColumnInfo(name = "animal_english")
    private String animal_eng;

    public int getId_eng_animal() {
        return id_eng_animal;
    }

    public void setId_eng_animal(int id_eng_animal) {
        this.id_eng_animal = id_eng_animal;
    }

    public String getAnimal_eng() {
        return animal_eng;
    }

    public void setAnimal_eng(String animal_eng) {
        this.animal_eng = animal_eng;
    }
}

