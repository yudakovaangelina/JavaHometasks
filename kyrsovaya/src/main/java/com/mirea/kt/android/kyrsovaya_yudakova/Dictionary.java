package com.mirea.kt.android.kyrsovaya_yudakova;

public class Dictionary {
    private String term;
    private String definition;
    private boolean isFavorite;
    private int id;

    public Dictionary(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setFavourite(boolean isFavourite) {
        this.isFavorite = isFavourite;
    }

    public boolean isFavourite() {
        return isFavorite;
    }

    public Dictionary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
