package com.example.harmonyapp.ui.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harmonyapp.AllPracticeActivity;
import com.example.harmonyapp.R;
import com.example.harmonyapp.practice.MyAdapter;

public class PracticeFragment extends Fragment {

    //private FragmentPracticeBinding binding;


    String[] names = {"asdas", "ghfgh", "rtyrty"};
    String[] descriptions = {"lkjlkj", "poiupoi", "nbvnbv"};
    int[] images = {R.drawable.sharp, R.drawable.flat, R.drawable.sharp};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //PracticeViewModel practiceViewModel =
                //new ViewModelProvider(this).get(PracticeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_practice, container, false);


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        MyAdapter myAdapter = new MyAdapter(this.getActivity(), names, descriptions, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myAdapter.setListener(new MyAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), AllPracticeActivity.class);
                intent.putExtra("position", position);
                getActivity().startActivity(intent);
                //
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}