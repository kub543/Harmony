package com.example.harmonyapp.logicHarmony;

import static com.example.harmonyapp.logicHarmony.tools.MenuConsoleChoice.b;
import static com.example.harmonyapp.logicHarmony.tools.MenuConsoleChoice.k;
import static com.example.harmonyapp.logicHarmony.tools.MenuConsoleChoice.n;
import static com.example.harmonyapp.logicHarmony.tools.MenuConsoleChoice.p;
import static com.example.harmonyapp.logicHarmony.tools.MenuConsoleChoice.q;
import static com.example.harmonyapp.logicHarmony.tools.MenuConsoleChoice.s;
import static com.example.harmonyapp.logicHarmony.tools.MenuConsoleChoice.t;
import static com.example.harmonyapp.logicHarmony.tools.MenuConsoleChoice.v;
import static com.example.harmonyapp.logicHarmony.tools.MenuConsoleChoice.z;
import static com.example.harmonyapp.logicHarmony.tools.Text.DESCRIPTION;
import static com.example.harmonyapp.logicHarmony.tools.Text.INPUT;
import static com.example.harmonyapp.logicHarmony.tools.Text.INPUT2;
import static com.example.harmonyapp.logicHarmony.tools.Text.MENU;
import static com.example.harmonyapp.logicHarmony.tools.Text.SEPARATOR;
import static com.example.harmonyapp.logicHarmony.tools.Text.WELCOME;

import com.example.harmonyapp.logicHarmony.fundamental_date.CirclesOfFifths;
import com.example.harmonyapp.logicHarmony.harmonic_triad_builder.CreateHarmonicTriad;
import com.example.harmonyapp.logicHarmony.practise.FunctionsPractise;
import com.example.harmonyapp.logicHarmony.practise.HarmonicTriadsPractise;
import com.example.harmonyapp.logicHarmony.practise.Practise;
import com.example.harmonyapp.logicHarmony.practise.TriadsPractise;
import com.example.harmonyapp.logicHarmony.tools.MenuConsoleChoice;

import java.util.Scanner;


public class Harmony {
    private static Scanner input = new Scanner(System.in);
    private static CreateHarmonicTriad builder = new CreateHarmonicTriad();
    private static Practise exsercise;
    private static String INCORECT_CHOICE = "Dokonaj prawidłowego wyboru!\n";
    private static MenuConsoleChoice userChoice;

    public static void main(String[] args) {
        System.out.println(WELCOME);
        System.out.println(DESCRIPTION);

        while (true) {
            showMainMenu();
            userchoice();
            switch (userChoice) {
                case k:
                    CirclesOfFifths.showCirclesOfFifths();
                    break;
                case t:
                    builder.createAskHarmonicTriad();
                    break;
                case p:
                    choiceExsercise();
                    break;
                case s:
                    System.out.println(DESCRIPTION);
                    break;
                case z:
                    System.exit(0);
                    break;
                default:
                    System.out.println(INCORECT_CHOICE);
                    break;
            }
        }
    }

    private static void showMainMenu() {
        System.out.println(MENU);
        System.out.println(SEPARATOR);
        System.out.println(INPUT + k.name() + INPUT2 + k.getDescription());
        System.out.println(INPUT + t.name() + INPUT2 + t.getDescription());
        System.out.println(INPUT + p.name() + INPUT2 + p.getDescription());
        System.out.println(INPUT + s.name() + INPUT2 + s.getDescription());
        System.out.println(INPUT + z.name() + INPUT2 + z.getDescription());
        System.out.println(SEPARATOR);
    }

    private static void userchoice() {
        String chose = input.next().toLowerCase();
        try {
            userChoice = MenuConsoleChoice.valueOf(chose);
        } catch (IllegalArgumentException e) {
            System.err.println(INCORECT_CHOICE);
            userchoice();
        }
    }

    private static void choiceExsercise() {
        do {
            showPractiseMenu();
            exsercise = null;
            userchoice();
            choicePractise();
            try {
                exsercise.practise();
            } catch (NullPointerException e) {
                if (!userChoice.equals(q)) {
                    System.err.println(INCORECT_CHOICE);
                    input.nextLine();
                    userchoice();
                }
            }
        } while (!userChoice.equals(q));
    }

    private static void choicePractise() {
        switch (userChoice) {
            case n:
                exsercise = new TriadsPractise();
                break;
            case b:
                exsercise = new FunctionsPractise();
                break;
            case v:
                exsercise = new HarmonicTriadsPractise();
                break;
            case q:
                break;
        }
    }

    private static void showPractiseMenu(){
        System.out.println(SEPARATOR);
        System.out.println(INPUT + n.name() + INPUT2 + n.getDescription());
        System.out.println(INPUT + b.name() + INPUT2 + b.getDescription());
        System.out.println(INPUT + v.name() + INPUT2 + v.getDescription());
        System.out.println(INPUT + q.name() + INPUT2 + q.getDescription());
        System.out.println(SEPARATOR);
    }
}