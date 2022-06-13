package com.example.harmonyapp.logicHarmony.elements;

import com.example.harmonyapp.logicHarmony.elements.triad.Triads;
import com.example.harmonyapp.logicHarmony.tools.Text;


public class HarmonicTriad {
    private Triads tonic;
    private Triads subdominant;
    private Triads dominant;
    private String[] functionsOfHarmonicTriad;

    public HarmonicTriad(Triads tonic, Triads subdominant, Triads dominant) {
        this.tonic = tonic;
        this.subdominant = subdominant;
        this.dominant = dominant;
    }

    public Triads getTonic() {
        return tonic;
    }

    public Triads getSubdominant() {
        return subdominant;
    }

    public Triads getDominant() {
        return dominant;
    }

    public String[] getFunctionsOfHarmonicTriad() {
        return functionsOfHarmonicTriad;
    }

    @Override
    public String toString() {
        StringBuilder createHarmonicTriads = new StringBuilder();
        createHarmonicTriads.append(Text.INPUT_TONIC)
                .append(tonic)
                .append(System.getProperty("line.separator"))
                .append(Text.INPUT_SUBDOMINANT)
                .append(subdominant)
                .append(System.getProperty("line.separator"))
                .append(Text.INPUT_DOMINANTA)
                .append(dominant)
                .append(System.getProperty("line.separator"));
        return createHarmonicTriads.toString();
    }
}