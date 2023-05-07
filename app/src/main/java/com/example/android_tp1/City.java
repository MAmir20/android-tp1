package com.example.android_tp1;

public class City {
    private String nom, description, url;

    public City(String nom, String description, String url) {
        this.nom = nom;
        this.description = description;
        this.url = url;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
