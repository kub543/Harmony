package com.example.harmonyapp.logicHarmony.elements.triad;


public class MinorTriad extends Triads {

    public MinorTriad(String nameTriad) {
        super(nameTriad);
        buildTriad(nameTriad);
    }

    @Override
    public int findIndexOfSoundThird(int sound) {
        final int MINOR_THIRD_HALF_TONE = 3;
        final int POINT_LOOP = 8;
        if (sound > POINT_LOOP) {
            return   (sound + MINOR_THIRD_HALF_TONE) - Triads.CONTINUE_KEYBOARD;
        } else {
            return sound + MINOR_THIRD_HALF_TONE;
        }
    }
}