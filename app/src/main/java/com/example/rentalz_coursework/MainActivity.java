package com.example.rentalz_coursework;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String[] items_property = {"House","Studio", "Flat", "Apartment", "Motel" };
    String[] items_bedroom = {"No bedroom","2 bedrooms", "3 bedrooms", "4 bedrooms" };
    String[] items_furniture = {"Furnished","Unfurnished", "Part Furnished"};



    AutoCompleteTextView tvproperty,tvbedroom, tvfurniture;



    ArrayAdapter<String> adapterItems_property;
    ArrayAdapter<String> adapterItems_bedroom;
    ArrayAdapter<String> adapterItems_furniture;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);


        tvproperty = findViewById(R.id.tv_property);
        tvbedroom = findViewById(R.id.tv_bedroom);
        tvfurniture = findViewById(R.id.tv_furniture);

        adapterItems_property = new ArrayAdapter<>(this, R.layout.list_item, items_property);
        adapterItems_bedroom = new ArrayAdapter<>(this, R.layout.list_item, items_bedroom);
        adapterItems_furniture = new ArrayAdapter<>(this, R.layout.list_item, items_furniture);


        tvproperty.setAdapter(adapterItems_property);

        tvproperty.setOnItemClickListener((parent, view, position, id) -> {
            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),"Choose: " +item, Toast.LENGTH_SHORT).show();
        });

        tvbedroom.setAdapter(adapterItems_bedroom);

        tvbedroom.setOnItemClickListener((parent, view, position, id) -> {
            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),"Choose: " +item, Toast.LENGTH_SHORT).show();
        });

        tvfurniture.setAdapter(adapterItems_furniture);

        tvfurniture.setOnItemClickListener((parent, view, position, id) -> {
            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),"Choose: " +item, Toast.LENGTH_SHORT).show();
        });
    }
}