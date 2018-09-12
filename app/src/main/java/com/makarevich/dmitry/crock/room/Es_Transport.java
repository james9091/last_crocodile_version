package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "es_transport")
public class Es_Transport {
    @PrimaryKey(autoGenerate = true)
    private  int id_transport_es;
    @ColumnInfo(name = "transport_es")
    private String transport_spain;

    public int getId_transport_es() {
        return id_transport_es;
    }

    public void setId_transport_es(int id_transport_es) {
        this.id_transport_es = id_transport_es;
    }

    public String getTransport_spain() {
        return transport_spain;
    }

    public void setTransport_spain(String transport_spain) {
        this.transport_spain = transport_spain;
    }
}

