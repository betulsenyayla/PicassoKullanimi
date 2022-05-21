package com.example.picasso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.picasso.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding tasarim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        String alinan_url = "https://i.imgur.com/H1R6U0G.png";

        ArrayList<String> methodList = new ArrayList<>();
        methodList.add("Metod Seçiniz: ");
        methodList.add("Metod 1");
        methodList.add("Metod 2");
        methodList.add("Metod 3");

        tasarim.spMethod.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, methodList));

        tasarim.spMethod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 1) {
                    Picasso.get().load(alinan_url).into(tasarim.imageView);
                }

                else if(position == 2) {
                    Picasso.get().load(alinan_url).resize(700, 600).into(tasarim.imageView);
                }

                else if(position == 3) {
                    Picasso.get().load(alinan_url).rotate(20).into(tasarim.imageView);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }
}