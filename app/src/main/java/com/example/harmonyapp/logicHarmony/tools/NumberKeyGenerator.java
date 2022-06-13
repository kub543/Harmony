package com.example.harmonyapp.logicHarmony.tools;

import java.security.SecureRandom;

public class NumberKeyGenerator {
    final static SecureRandom secureRandom = new SecureRandom();

    public static int generateNumber(int scope, int move) {
        return move + secureRandom.nextInt(scope);
    }

    public static boolean generateNumber() {
        return secureRandom.nextBoolean();
    }
}