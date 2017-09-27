package com.example.caroline.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ListExamples> songs = new ArrayList<>();
    private ListView songListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        //get the list of items you want to show wet up
        createList();
        //create the adapter that will be the go-between from the list to the listview
        ArrayAdapter<ListExamples> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, songs);
        //android.R. --> gets premade things you haven't made
        //set the adapter to the listview
        songListView.setAdapter(adapter);
    }

    private void wireWidgets(){
        songListView = (ListView) findViewById(R.id.listview_song);
    }

    private void createList(){
        songs.add(new ListExamples("All I Ask of You", "", 0));
        songs.add(new ListExamples("Think of Me", "", 0));
        songs.add(new ListExamples("Memory", "", 0));
        songs.add(new ListExamples("Corner of the Sky", "", 0));
        songs.add(new ListExamples("I Whistle a Happy Tune", "", 0));

    }
}
