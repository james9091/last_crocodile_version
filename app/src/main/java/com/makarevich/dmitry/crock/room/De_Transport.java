package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "de_transport")
public class De_Transport {
    @PrimaryKey(autoGenerate = true)
    private  int id_de_transport;
    @ColumnInfo(name = "transport_de")
    private String deutch_transport;

    public int getId_de_transport() {
        return id_de_transport;
    }

    public void setId_de_transport(int id_de_transport) {
        this.id_de_transport = id_de_transport;
    }

    public String getDeutch_transport() {
        return deutch_transport;
    }

    public void setDeutch_transport(String deutch_transport) {
        this.deutch_transport = deutch_transport;
    }
}

