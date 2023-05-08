package com.example.android_tp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {
    private City[] cityList;
    public CityAdapter(City[] cityList) {
        this.cityList = cityList;
    }
    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_city, parent, false);
        return new CityViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.name.setText(cityList[position].getNom());
        holder.desc.setText(cityList[position].getDescription());
        Picasso.get()
                .load(cityList[position].getUrl())
                .fit()
                .centerCrop()
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return cityList.length;
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView desc;
        private final ImageView img;
        public CityViewHolder(@NonNull View itemView) {

            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.desc = (TextView) itemView.findViewById(R.id.desc);
            this.img = (ImageView) itemView.findViewById(R.id.img);

        }
    }
}
