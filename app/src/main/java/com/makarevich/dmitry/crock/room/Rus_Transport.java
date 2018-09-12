package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "rus_transport")
public class Rus_Transport {
    @PrimaryKey(autoGenerate = true)
    private  int id_rus_transport;
    @ColumnInfo(name = "medium")
    private String transport_rus;

    public int getId_rus_transport() {
        return id_rus_transport;
    }

    public void setId_rus_transport(int id_rus_transport) {
        this.id_rus_transport = id_rus_transport;
    }

    public String getTransport_rus() {
        return transport_rus;
    }

    public void setTransport_rus(String transport_rus) {
        this.transport_rus = transport_rus;
    }
}
