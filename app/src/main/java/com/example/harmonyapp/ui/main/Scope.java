package com.example.harmonyapp.ui.main;

public enum Scope {
    SHARP(16), FLAT(8), ALL(0);
    private final int key;
    Scope(int key) {
        this.key = key;
    }
    public int getKey() {
        return key;
    }
}
