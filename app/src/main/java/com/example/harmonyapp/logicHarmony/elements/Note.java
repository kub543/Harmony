package com.example.harmonyapp.logicHarmony.elements;


public class Note {
    private int sound;
    private int name;
    private String note;

    public Note(int sound, int name, String note) {
        this.sound = sound;
        this.name = name;
        this.note = note;
    }

    public int getSound() {
        return sound;
    }

    public int getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return name == note1.name;
    }
}