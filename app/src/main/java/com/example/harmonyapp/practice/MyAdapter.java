package com.example.harmonyapp.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harmonyapp.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    String[] names;
    String[] descriptions;
    int[] images;
    private Listener listener;

    public interface Listener {
        void onClick(int position);
    }

    public MyAdapter(Context ct, String[] names, String[] descriptions, int[] images) {
        context = ct;
        this.names = names;
        this.descriptions = descriptions;
        this.images = images;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.practice_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(names[position]);
        holder.descr.setText(descriptions[position]);
        holder.image.setImageResource(images[position]);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null)
                    listener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView descr;
        ImageView image;
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            descr = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.firstImage);
            button = itemView.findViewById(R.id.practice_button);
        }
    }
}
