package com.example.harmonyapp.logicHarmony.practise;

import com.example.harmonyapp.logicHarmony.harmonic_triad_builder.CreateHarmonicTriad;

import java.util.Scanner;

public interface Practise {
    Scanner input = new Scanner(System.in);
    CreateHarmonicTriad builder = new CreateHarmonicTriad();
    void practise();
}
