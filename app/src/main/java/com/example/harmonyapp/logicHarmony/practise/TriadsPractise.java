package com.example.harmonyapp.logicHarmony.practise;

import com.example.harmonyapp.logicHarmony.elements.triad.Triads;

public class TriadsPractise implements Practise, PractiseBuilder {
    private Triads randomTriad;
    private String[] randomTriadNames;
    private String[] userTriad;
    private boolean compareThird;
    private boolean compareQuint;

    @Override
    public void practise() {
        createRandomTriad();
        createRandomTriadNames();
        showPrime();
        buildUserAnswer();
        compareThird();
        compareQuint();
        showResultOfCompare();
    }

    public void createRandomTriad() {
        String randomPrime = builder.randomKey();
        randomTriad = Triads.choseModeOfTriad(randomPrime);
        randomTriad.buildTriad();
    }

    public void createRandomTriadNames() {
        randomTriadNames = randomTriad.downloadNameOfNotes();
    }

    public void showPrime() {
        System.out.println("Zbuduj trójdźwięk " + randomTriad.showModeTriad() + " od dźwięku: " +randomTriad.getPrime().getNote());
    }

    @Override
    public boolean compareKeys(String user, String random) {
        return user.equalsIgnoreCase(random);
    }

    @Override
    public void buildUserAnswer() {
        userTriad = new String[2];
        userTriad[0] = third.input();
        input.nextLine();
        userTriad[1] = quint.input();
    }

    UserInput third = () -> {System.out.print("    tercja akordu: ");
        return input.next();
    };

    UserInput quint = () -> {System.out.print("    kwinta akordu: ");
        return input.next();
    };

    @Override
    public void showResultOfCompare() {
        if (compareThird && compareQuint) {
            System.out.println("Brawo! Poprawnie zbudowany trójdźwięk");
        }
    }

    public void compareThird() {
        compareThird = compareKeys(userTriad[0], randomTriadNames[1]);
        if (!compareThird) {
            System.out.println("Błędna tercja akordu ");
            System.out.print("poprawna tercja akordu to: --" + randomTriadNames[1] + "--" + "\n");
        }
    }

    public void compareQuint() {
        compareQuint = compareKeys(userTriad[1], randomTriadNames[2]);
        if (!compareQuint) {
            System.out.println("Błędna kwinta");
            System.out.println("poprawna kwinta akordu to: --" + randomTriadNames[2] + "--");
        }
    }

    public void setRandomTriad(Triads randomTriad) {
        this.randomTriad = randomTriad;
    }
}