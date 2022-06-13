package com.example.harmonyapp.logicHarmony.elements.triad;

import com.example.harmonyapp.logicHarmony.elements.Note;
import com.example.harmonyapp.logicHarmony.fundamental_date.KeyNames;
import com.example.harmonyapp.logicHarmony.tools.Text;


public abstract class Triads implements NoteOfTriad {
    private Note prime;
    private Note third;
    private Note quint;
    private String nameTriad;
    protected final static int CONTINUE_KEYBOARD = 12;

    public Triads(String nameTriad) {
        this.nameTriad = nameTriad;
    }

    public static Triads choseModeOfTriad(String key) {
        char keyChar = key.charAt(0);
        Triads triad;
        if (Character.isUpperCase(keyChar)) {
            triad = new MajorTriad(key);
        } else {
            triad = new MinorTriad(key);
        }
            return triad;
    }

    public Note getPrime() {
        return prime;
    }

    public void setPrime(Note prime) {
        this.prime = prime;
    }

    public Note getThird() {
        return third;
    }

    public void setThird(Note third) {
        this.third = third;
    }

    public Note getQuint() {
        return quint;
    }

    public void setQuint(Note quint) {
        this.quint = quint;
    }

    public String getNameTriad() {
        return nameTriad;
    }

    public void setNameTriad(String nameTriad) {
        this.nameTriad = nameTriad;
    }

    public void buildTriad() {
        Note primeOfTriad = findPrime(KeyNames.keyBoard, nameTriad);
        Note thirdOfTriad = findThird(primeOfTriad);
        Note quintOfThird = findQuint(primeOfTriad);
        setPrime(primeOfTriad);
        setThird(thirdOfTriad);
        setQuint(quintOfThird);
    }

    public void buildTriad(String primeOfTriadName) {
        Note primeOfTriad = findPrime(KeyNames.keyBoard, primeOfTriadName);
        Note thirdOfTriad = findThird(primeOfTriad);
        Note quintOfThird = findQuint(primeOfTriad);
        setPrime(primeOfTriad);
        setThird(thirdOfTriad);
        setQuint(quintOfThird);
    }

    public Note findPrime(String[][] notes, String primeOfTriad) {
        Note prime = null;
        for (int row = 0; row < notes.length; row++) {
            for (int column = 0; column < notes[row].length; column++) {
                if (primeOfTriad.toLowerCase().equals(notes[row][column])) {
                    prime = new Note(row, column, primeOfTriad.toLowerCase());
                }
            }
        }
        return prime;
    }

    public Note findThird(Note note) {
        int indexOfSound = findIndexOfSoundThird(note.getSound());
        int indexOfName = findIndexOfName(note, indexOfSound);
        String keyName = KeyNames.keyBoard[indexOfSound][indexOfName];
        Note third = new Note(indexOfSound, indexOfName, keyName.toLowerCase());
        return third;
    }

    public Note findQuint(Note note) {
        int indexOfSound = findIndexOfSoundQuint(note.getSound());
        int indexOfName = findIndexOfName(note, indexOfSound);
        String keyName = KeyNames.keyBoard[indexOfSound][indexOfName];
        Note quint = new Note(indexOfSound, indexOfName, keyName.toLowerCase());
        return quint;
    }

    public int findIndexOfSoundQuint(int sound) {
        final int POINT_LOOP = 4;
        final int HALF_TONE = 7;
        if (sound > POINT_LOOP) {
            return (sound + HALF_TONE) - CONTINUE_KEYBOARD;
        } else {
            return sound + HALF_TONE;
        }
    }

    public int findIndexOfName(Note note, int indexSound) {
        final int DOUBLE_SHARP_NOTE = 3;
        final int MOVE_SHARP_FLAT = 1;
        int name = note.getName();
        String nameOfNote = note.getNote();
        if (KeyNames.keyBoard[indexSound][name].equals("x")) {
            if (isDoubleSharp(nameOfNote)) {
                return DOUBLE_SHARP_NOTE;
            } else if (isFlat(nameOfNote)) {
                return name + MOVE_SHARP_FLAT;
            } else {
                return name - MOVE_SHARP_FLAT;
            }
        } else {
            return name;
        }
    }

    private boolean isDoubleSharp(String nameOfNote){
        if(nameOfNote.equalsIgnoreCase("dis") || nameOfNote.equalsIgnoreCase("eis") ||
                nameOfNote.equalsIgnoreCase("ais")) {
            return true;
        }else{
            return false;
        }
    }

    private boolean isFlat(String nameOfNote){
        if(nameOfNote.equalsIgnoreCase("g")||nameOfNote.equalsIgnoreCase("c") || nameOfNote.equalsIgnoreCase("f") ||
                nameOfNote.equalsIgnoreCase("fis")||nameOfNote.equalsIgnoreCase("cis") || nameOfNote.equalsIgnoreCase("gis") ){
            return true;
        } else {
            return false;
        }
    }

    public String showModeTriad() {
        char[] name = nameTriad.toCharArray();
        if (Character.isUpperCase(name[0])) {
            return "durowy";
        } else {
            return "molowy";
        }
    }

    public String[] downloadNameOfNotes() {
        String[] triad = new String[3];
        triad[0] = prime.getNote();
        triad[1] = third.getNote();
        triad[2] = quint.getNote();
        return triad;
    }

    @Override
    public String toString() {
        StringBuilder createNotes = new StringBuilder();
        createNotes.append(nameTriad)
                .append(Text.INPUT_Notes)
                .append(prime)
                .append(Text.INPUT_COMMA)
                .append(third)
                .append(Text.INPUT_COMMA)
                .append(quint)
                .append(Text.INPUT_BRACKET);
             return createNotes.toString();
    }
}