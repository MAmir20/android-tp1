package com.example.android_tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    CityAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.list);
        City[] cityList = new City[] {
                new City("Paris", "The city of Lights", "https://upload.wikimedia.org/wikipedia/commons/4/4b/La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_ao%C3%BBt_2014_%282%29.jpg"),
                new City("New York", "The Big Apple", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/World_Trade_Center%2C_New_York_City_-_aerial_view_%28March_2001%29.jpg/1200px-World_Trade_Center%2C_New_York_City_-_aerial_view_%28March_2001%29.jpg"),
                new City("Tokyo", "The Land of the Rising Sun", "https://media.cntraveller.com/photos/6343df288d5d266e2e66f082/16:9/w_1280,c_limit/tokyoGettyImages-1031467664.jpeg")
        };

        adapter = new CityAdapter(cityList);
        rv.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
    }
}