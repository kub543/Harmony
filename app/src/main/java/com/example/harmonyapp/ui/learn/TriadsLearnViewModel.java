package com.example.harmonyapp.ui.learn;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.harmonyapp.logicHarmony.elements.HarmonicTriad;
import com.example.harmonyapp.logicHarmony.elements.triad.MajorTriad;
import com.example.harmonyapp.logicHarmony.harmonic_triad_builder.CreateHarmonicTriad;

public class TriadsLearnViewModel extends ViewModel {
    public MutableLiveData<HarmonicTriad> harmonicTriads;
    private CreateHarmonicTriad buildHarmonicTriad = new CreateHarmonicTriad();

    public TriadsLearnViewModel() {
        harmonicTriads = new MutableLiveData<>();
        harmonicTriads.setValue(new HarmonicTriad(
                new MajorTriad("C"), new MajorTriad("F"), new MajorTriad("G")
        ));
    }
    public void changeTriads(String userInput) {
        harmonicTriads.setValue(buildHarmonicTriad.buildHarmonicTriad(userInput));
    }
}