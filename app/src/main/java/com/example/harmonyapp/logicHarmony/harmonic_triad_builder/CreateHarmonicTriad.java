package com.example.harmonyapp.logicHarmony.harmonic_triad_builder;

import com.example.harmonyapp.logicHarmony.elements.HarmonicTriad;
import com.example.harmonyapp.logicHarmony.elements.triad.Triads;
import com.example.harmonyapp.logicHarmony.fundamental_date.CirclesOfFifths;
import com.example.harmonyapp.logicHarmony.tools.NumberKeyGenerator;

import java.util.Scanner;

public class CreateHarmonicTriad {

   private CirclesOfFifths circles = new CirclesOfFifths();
   private Scanner input = new Scanner(System.in);

    public void createAskHarmonicTriad() {
        try {
            HarmonicTriad harmonicTriad = buildHarmonicTriad(userInputTonic());
            System.out.println(harmonicTriad);
        } catch (NullPointerException e) {
            createAskHarmonicTriad();
        }
    }

    public String[] createRandomHarmonicTriadNames() {
        String tonic = randomKey();
        return findNameOfHarmonicTriadFunction(tonic);
    }
    final int REJECT_FIRST_KEY = 1;
    final int REJECT_LAST_KEY = 2;
    public String randomKey() {
        circles.setModeOfCircle(circles.choseModeOfCircle());
        int scope = circles.getModeOfCircle().size() - REJECT_LAST_KEY;
        int randomNumber =  NumberKeyGenerator.generateNumber(scope, REJECT_FIRST_KEY);
        return circles.findTonic(randomNumber);
    }
    public String randomKey(int scope) {
        circles.setModeOfCircle(circles.choseModeOfCircle());
        int randomNumber = scope;
        switch (scope) {
            case 16: // random 8 - 15, Sharp Key
                randomNumber = NumberKeyGenerator.generateNumber(7,9);
                break;
            case 8: // random 1 - 8, Flat Key
                randomNumber = NumberKeyGenerator.generateNumber(8,1);
                break;
            case 0: // All Key
                randomNumber = NumberKeyGenerator.generateNumber(15, 1);
                break;
        }
        return circles.findTonic(randomNumber);
    }

    private String userInputTonic() throws IndexOutOfBoundsException {
        System.out.print("Wpisz tonikę: ");
        return input.next();
    }

    public HarmonicTriad buildHarmonicTriad(String tonic) {
        String[] functionOfHarmonicTriad = findNameOfHarmonicTriadFunction(tonic);
        Triads tonicTriad = Triads.choseModeOfTriad(tonic);
        Triads subDominantTriad = Triads.choseModeOfTriad(functionOfHarmonicTriad[1]);
        Triads dominantTriad = Triads.choseModeOfTriad(functionOfHarmonicTriad[2]);

        HarmonicTriad harmonicTriad = new HarmonicTriad(tonicTriad, subDominantTriad, dominantTriad);

        tonicTriad.buildTriad(tonic);
        subDominantTriad.buildTriad(functionOfHarmonicTriad[1]);
        dominantTriad.buildTriad(functionOfHarmonicTriad[2]);
        return harmonicTriad;
    }

    public String[] findNameOfHarmonicTriadFunction(String tonic) {
        String[] functions = new String[3];
        try {
            circles.setModeOfCircle(circles.choseModeOfCircle(tonic));
            functions[0] = tonic;
            functions[1] = circles.findSubdominant(tonic);
            functions[2] = circles.findDominant(tonic);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wpisz prawidłową tonację! (do siedmiu znaków przykluczowych).\n");
        }
        return functions;
    }
}