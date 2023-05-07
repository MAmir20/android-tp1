package com.example.android_tp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {
    List<City> villes;
    public CityAdapter(List<City> villes) {
        this.villes = villes;
    }



    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_city, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.getTextView().setText(localDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView desc;
        private final ImageView img;
        public CityViewHolder(@NonNull View itemView) {

            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            desc = (TextView) itemView.findViewById(R.id.desc);
            img = (ImageView) itemView.findViewById(R.id.img);

        }
    }
}
