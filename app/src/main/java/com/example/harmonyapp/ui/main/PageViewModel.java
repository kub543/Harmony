package com.example.harmonyapp.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.harmonyapp.logicHarmony.elements.HarmonicTriad;
import com.example.harmonyapp.logicHarmony.harmonic_triad_builder.CreateHarmonicTriad;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    public MutableLiveData<HarmonicTriad> harmonicTriad = new MutableLiveData<>();
    private CreateHarmonicTriad builder = new CreateHarmonicTriad();
    public MutableLiveData<String> inputKey = new MutableLiveData<>();
    public MutableLiveData<String> resultText = new MutableLiveData<>();

    public PageViewModel() {
        resultText.setValue("?");
    }

    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void randomHarmonicTriad(int scope) {
        harmonicTriad.setValue(builder.buildHarmonicTriad(builder.randomKey(scope)));
    }

    public void getKey(String key) {
        inputKey.setValue(key);
        String searchKey = "";
        switch (mIndex.getValue()) {
            case 1:
                searchKey = harmonicTriad.getValue().getSubdominant().getNameTriad();
                break;
            case 2:
                searchKey = harmonicTriad.getValue().getDominant().getNameTriad();
                break;
            default:
                searchKey = harmonicTriad.getValue().getTonic().toString();
                break;
        }
        if (inputKey.getValue().equals(searchKey)) {
            resultText.setValue(inputKey.getValue());
        } else {
            resultText.setValue("źle");
        }
    }

}