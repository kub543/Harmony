package com.example.harmonyapp.ui.practice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PracticeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PracticeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}