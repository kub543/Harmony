package com.example.harmonyapp.logicHarmony.fundamental_date;

import com.example.harmonyapp.logicHarmony.tools.NumberKeyGenerator;

import java.util.Arrays;
import java.util.List;


public class CirclesOfFifths {
    final static String [] majorKeys = {"Fes", "Ces", "Ges", "Des", "As", "Es", "B", "F", "C", "G", "D", "A", "E", "H", "Fis", "Cis", "Gis"};
    final static String [] minorKeys = {"des", "as", "es", "b", "f", "c", "g", "d", "a", "e", "h", "fis", "cis", "gis", "dis", "ais", "eis"};

       final List<String> major = Arrays.asList(majorKeys);
       final List<String> minor = Arrays.asList(minorKeys);
       private List<String> modeOfCircle;
       private static final int STEP_CIRCLE = 1;

    public CirclesOfFifths() {
    }

    public CirclesOfFifths(List<String> modeOfCircle) {
        this.modeOfCircle = modeOfCircle;
    }

    public static String[] getMajorKeys() {
        return majorKeys;
    }

    public static String[] getMinorKeys() {
        return minorKeys;
    }

    public List<String> getMajor() {
        return major;
    }

    public List<String> getMinor() {
        return minor;
    }

    public List<String> getModeOfCircle() {
        return modeOfCircle;
    }

    public void setModeOfCircle(List<String> modeOfCircle) {
        this.modeOfCircle = modeOfCircle;
    }

    public List<String> choseModeOfCircle(String tonic) {
        if (major.contains(tonic)) {
           return major;
        } else if (minor.contains(tonic)) {
            return minor;
        } else {
            throw new NullPointerException("Tonacja jest Poza zakresem");
        }
    }

    public List<String> choseModeOfCircle() {
        if (NumberKeyGenerator.generateNumber()) {
            return major;
        } else {
            return minor;
        }
    }

    public String findTonic(int indexOfTonic) {
        if (indexOfTonic <= modeOfCircle.size()) {
            return modeOfCircle.get(indexOfTonic);
        } else {
            throw new ArrayIndexOutOfBoundsException("Indeks poza zakresem koła kwintowego");
        }
    }

    public String findSubdominant(String tonic) {
         return modeOfCircle.get(findIndexOfKey(tonic) - STEP_CIRCLE);
    }

    public int findIndexOfKey(String key) {
        return modeOfCircle.indexOf(key);
    }

    public String findDominant(String tonic) {
        String dominant =  modeOfCircle.get(findIndexOfKey(tonic) + STEP_CIRCLE);
        return changeModeOfKey(dominant);
    }

    public String changeModeOfKey(String key) {
        if (modeOfCircle.equals(minor)) {
            char[] dominantLetter = key.toCharArray();
            return key.replace(dominantLetter[0], Character.toUpperCase(dominantLetter[0]));
        } else {
            return key;
        }
    }

    public static void showCirclesOfFifths() {
        System.out.println("Koła kwintowe: ");
        showCircles(majorKeys);
        showCircles(minorKeys);
    }

    private static void showCircles(String[] keys) {
        for (String show : keys) {
            System.out.print(show + "  ");
        }
        System.out.println();
    }
}