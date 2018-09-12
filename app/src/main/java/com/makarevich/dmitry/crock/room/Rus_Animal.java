package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "rus_animal")
public class Rus_Animal {
    @PrimaryKey(autoGenerate = true)
    private  int id_rus_animal;
    @ColumnInfo(name = "medium")
    private String animal_rus;

    public int getId_rus_animal() {
        return id_rus_animal;
    }

    public void setId_rus_animal(int id_rus_animal) {
        this.id_rus_animal = id_rus_animal;
    }

    public String getAnimal_rus() {
        return animal_rus;
    }

    public void setAnimal_rus(String animal_rus) {
        this.animal_rus = animal_rus;
    }
}
