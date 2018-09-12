package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "eng_transport")
public class Eng_Transport {
    @PrimaryKey(autoGenerate = true)
    private  int id_eng_transport;
    @ColumnInfo(name = "transport_english")
    private String transport_eng;

    public int getId_eng_transport() {
        return id_eng_transport;
    }

    public void setId_eng_transport(int id_eng_transport) {
        this.id_eng_transport = id_eng_transport;
    }

    public String getTransport_eng() {
        return transport_eng;
    }

    public void setTransport_eng(String transport_eng) {
        this.transport_eng = transport_eng;
    }
}

