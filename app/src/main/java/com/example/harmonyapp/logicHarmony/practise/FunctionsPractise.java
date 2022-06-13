package com.example.harmonyapp.logicHarmony.practise;

public class FunctionsPractise implements Practise, PractiseBuilder {
    private String[] randomHarmonicTriadNames;
    private String[] userHarmonicTriad;
    private boolean compareSubdominant;
    private boolean compareDominant;

    public void setRandomHarmonicTriadNames(String[] randomHarmonicTriadNames) {
        this.randomHarmonicTriadNames = randomHarmonicTriadNames;
    }

    @Override
    public void practise() {
        createRandomHarmonicTriadNames();
        showTonic();
        buildUserAnswer();
        compareSubdominant();
        compareDominant();
        showResultOfCompare();
    }

    public void createRandomHarmonicTriadNames() {
        randomHarmonicTriadNames = builder.createRandomHarmonicTriadNames();
    }

    public void showTonic() {
        System.out.println("Tonika: " + randomHarmonicTriadNames[0]);
    }

    @Override
    public boolean compareKeys(String user, String random) {
        return user.equals(random);
    }

    @Override
    public void buildUserAnswer() {
        userHarmonicTriad = new String[2];
        userHarmonicTriad[0] = subdominant.input();
        input.nextLine();
        userHarmonicTriad[1] = dominant.input();
    }

    public void buildUserAnswer(String subdominant, String dominant) {
        userHarmonicTriad = new String[2];
        userHarmonicTriad[0] = subdominant;
        userHarmonicTriad[1] = dominant;
    }

    UserInput subdominant = () -> {System.out.print("Subdominanta: ");
        return input.next();
    };

    UserInput dominant = () -> {System.out.print("Domonanta: ");
        return input.next();
    };

    @Override
    public void showResultOfCompare() {
        if (compareSubdominant && compareDominant) {
            System.out.println("Brawo! Poprawnie zbudowana triada harmoniczna");
        }
    }

    public void compareSubdominant() {
        compareSubdominant = compareKeys(userHarmonicTriad[0], randomHarmonicTriadNames[1]);
        if (!compareSubdominant) {
            System.out.println("\nBłędna subdominanta");
            System.out.println("poprawna subdominanta w tonacji --" + randomHarmonicTriadNames[0] +
                                "--  to  --" + randomHarmonicTriadNames[1] + "--" + "\n");
        }
    }

    public void compareDominant() {
        compareDominant = compareKeys(userHarmonicTriad[1], randomHarmonicTriadNames[2]);
        if (!compareDominant) {
            System.out.println("Błędna dominanta");
            System.out.println("poprawna dominanta w tonacji --" + randomHarmonicTriadNames[0] +
                                "--  to  --" + randomHarmonicTriadNames[2] + "--");
        }
    }
}