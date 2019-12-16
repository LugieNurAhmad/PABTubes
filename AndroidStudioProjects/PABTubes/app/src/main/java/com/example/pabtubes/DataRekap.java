package com.example.pabtubes;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

class DataRekap implements Serializable {
    @Exclude
    private String id;

    private String Penyakit;

    public DataRekap() {

    }

    public DataRekap(String Penyakit) {
        this.Penyakit = Penyakit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPenyakit() {
        return Penyakit;
    }
}
