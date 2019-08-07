package com.example.myportofolioapp.Model;

public class ItemVidio {
    String id,judul,file;

    public ItemVidio(String id, String judul, String file) {
        this.id = id;
        this.judul = judul;
        this.file = file;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
