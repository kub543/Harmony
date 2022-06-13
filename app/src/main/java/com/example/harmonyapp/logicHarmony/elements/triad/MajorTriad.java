package com.example.harmonyapp.logicHarmony.elements.triad;
public class MajorTriad extends Triads {

    public MajorTriad(String nameTriad) {
        super(nameTriad);
        buildTriad(nameTriad);
    }

    @Override
    public int findIndexOfSoundThird(int sound) {
        final int MAJOR_HALF_TONE = 4;
        final int POINT_LOOP = 7;
        if (sound > POINT_LOOP) {
            return (sound + MAJOR_HALF_TONE) - Triads.CONTINUE_KEYBOARD;
        } else {
            return sound + MAJOR_HALF_TONE;
        }
    }
}