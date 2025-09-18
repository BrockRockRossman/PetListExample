package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import Model.Pet;

public class MainActivity extends AppCompatActivity {

    ListView petList;
    ArrayList<Pet> pets;

    AdapterView.OnItemClickListener selectListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Pet selected = (Pet) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), "hi hi " + selected.getName(), Toast.LENGTH_SHORT).show();
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        petList = findViewById(R.id.listView);
        pets = new ArrayList<>();
        pets.add(new Pet("Kenny", "Husky", 17));
        pets.add(new Pet("Arnold", "Golden Retriever", 7));
        pets.add(new Pet("Bomber", "Malimute", 1));
        pets.add(new Pet("killa", "Corgi", 12));



        int selection = 2;
        populateListView(selection);





    }

    private void populateListView(int selection) {
        switch (selection) {
            case 1:
                useStringResource();
                break;
            case 2:
                usingDataArray();
                petList.setOnItemClickListener(selectListener);
                break;

            case 3:
                usingTwoLines();
                break;

        }
    }

    /**
     * This method populates the list view using a string resource containing
     * the content of a strings array resource
     */
    private void useStringResource() {
        String [] content = getResources().getStringArray(R.array.breeds);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, content);
        petList.setAdapter(adapter);
    }

    /**
     * This method populates the list view using a string resource containing the list of a data array
     */
    private void usingDataArray() {

        ArrayAdapter<Pet> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, pets);
        petList.setAdapter(adapter);

    }

    private void usingTwoLines(){
        List<HashMap<String, String>> data = new ArrayList<>();

        for(Pet P : pets) {
            HashMap<String, String> current = new HashMap<>();
            current.put("name", P.getName());
            current.put("breed", P.getBreed());
            data.add(current);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,
                data,
                android.R.layout.simple_list_item_2, new String[]{"name", "breed"},
                new int[]{android.R.id.text1, android.R.id.text2});

        petList.setAdapter(adapter);



    }
};