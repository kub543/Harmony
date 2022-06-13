package com.example.harmonyapp.logicHarmony.practise;

import com.example.harmonyapp.logicHarmony.elements.HarmonicTriad;

public class HarmonicTriadsPractise implements Practise {
    private TriadsPractise triadTonic;
    private TriadsPractise triadSubdominant;
    private TriadsPractise triadDominant;
    private FunctionsPractise function;
    HarmonicTriad harmonicTriad;

    @Override
    public void practise() {
        createHarmonicTriad();
        buildHarmonicTriad();
        takeAnswer();
        triadTonic();
        triadSubdominant();
        triadDominant();
    }

    private void buildHarmonicTriad() {
        creatTonicTriad();
        createSubdominantTriad();
        createDominantTriads();
    }

    private void createHarmonicTriad() {
        function = new FunctionsPractise();
        harmonicTriad = builder.buildHarmonicTriad(builder.randomKey());
        function.setRandomHarmonicTriadNames(builder.findNameOfHarmonicTriadFunction
                                            (harmonicTriad.getTonic().getNameTriad()));
    }

    private void creatTonicTriad() {
        triadTonic = new TriadsPractise();
        triadTonic.setRandomTriad(harmonicTriad.getTonic());
        triadTonic.createRandomTriadNames();
    }

    private void createSubdominantTriad() {
        triadSubdominant = new TriadsPractise();
        triadSubdominant.setRandomTriad(harmonicTriad.getSubdominant());
        triadSubdominant.createRandomTriadNames();
    }

    private void createDominantTriads() {
        triadDominant = new TriadsPractise();
        triadDominant.setRandomTriad(harmonicTriad.getDominant());
        triadDominant.createRandomTriadNames();
    }

    private void takeAnswer() {
        function.showTonic();
        triadTonic.buildUserAnswer();
        String subdominant = function.subdominant.input();
        triadSubdominant.buildUserAnswer();
        String dominant = function.dominant.input();
        triadDominant.buildUserAnswer();
        function.buildUserAnswer(subdominant, dominant);
    }

    private void triadTonic() {
        System.out.println("\nTONIKA:");
        triadTonic.compareThird();
        triadTonic.compareQuint();
        triadTonic.showResultOfCompare();
    }

    private void triadSubdominant() {
        System.out.println("\nSUBDOMINANTA:");
        triadSubdominant.compareThird();
        triadSubdominant.compareQuint();
        triadSubdominant.showResultOfCompare();
    }

    private void triadDominant() {
        System.out.println("\nDOMINANTA:");
        triadDominant.compareThird();
        triadDominant.compareQuint();
        triadDominant.showResultOfCompare();
        function.showResultOfCompare();
    }
}