package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView petList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        petList = findViewById(R.id.listView);

        int selection = 1;
        populateListView(selection);



    }

    private void populateListView(int selection) {
        switch (selection) {
            case 1:
                useStringResource();
                break;
            case 2:
                usingDataArray();
                break;

        }
    }

    /**
     * This method populates the list view using a string resource containing
     * the content of a strings array resource
     */
    private void useStringResource() {
        String [] content = getResources().getStringArray(R.array.breeds);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, content);
        petList.setAdapter(adapter);
    }

    /**
     * This method populates the list view using a string resource containing the list of a data array
     */
    private void usingDataArray() {


    }
}