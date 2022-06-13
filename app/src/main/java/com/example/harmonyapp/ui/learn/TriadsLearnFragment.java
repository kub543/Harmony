package com.example.harmonyapp.ui.learn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.harmonyapp.R;
import com.example.harmonyapp.databinding.TriadsLearnFragmentBinding;

public class TriadsLearnFragment extends Fragment {

    private TriadsLearnViewModel mViewModel;
    public static TriadsLearnFragment newInstance() {
        return new TriadsLearnFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(TriadsLearnViewModel.class);
        TriadsLearnFragmentBinding dataBinding =
                DataBindingUtil.inflate(inflater, R.layout.triads_learn_fragment, container, false);
        View view = dataBinding.getRoot();
        dataBinding.setLifecycleOwner(this);
        dataBinding.setViewModel(mViewModel);




        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TriadsLearnViewModel.class);
        // TODO: Use the ViewModel
    }

}