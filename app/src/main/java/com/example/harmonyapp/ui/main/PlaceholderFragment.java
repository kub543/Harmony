package com.example.harmonyapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.harmonyapp.R;
import com.example.harmonyapp.databinding.FragmentAllPracticeBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private FragmentAllPracticeBinding binding;
    //public static final String SCOPE = "position";

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all_practice, container, false);
        View root = binding.getRoot();
        binding.setLifecycleOwner(this);
        binding.setPracticeViewModel(pageViewModel);

        Intent intent = getActivity().getIntent();
        int position = intent.getIntExtra("position", 0);
        switch (position) {
            case 0:
                position = Scope.SHARP.getKey();
                break;
            case 1:
                position = Scope.FLAT.getKey();
                break;
            case 2:
                position = Scope.ALL.getKey();
                break;
        }
        final int scope = position;
        binding.randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pageViewModel.randomHarmonicTriad(scope);
                binding.randomButton.setText(pageViewModel.harmonicTriad.getValue().getTonic().getNameTriad());
            }
        });





        //binding.randomButton.

       // final TextView textView = binding.sectionLabel;
        //pageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
           // @Override
            //public void onChanged(@Nullable String s) {
               // textView.setText(s);
          //  }
        //});
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}