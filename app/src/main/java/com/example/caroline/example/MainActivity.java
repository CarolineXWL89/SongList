package com.example.caroline.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ListExamples> songs = new ArrayList<>();
    private ListView songListView;
    public static final String SONG_NAME = "song name";
    public static final String SONG_DESC = "song desc";
    private int songNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        //get the list of items you want to show up
        createList();
        //create the adapter that will be the go-between from the list to the listview
        ArrayAdapter<ListExamples> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songs);
        //android.R. --> gets premade things you haven't made
        //set the adapter to the listview
        songListView.setAdapter(adapter);
        songListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //public void onClick (View view){
                    Intent i = new Intent(MainActivity.this, SongScreen.class);
                    i.putExtra("song name", songs.get(songNum).getName());
                    i.putExtra("desc", songs.get(songNum).getDesc());
                    //resourceID passed
                    startActivity(i);
                //}
                songNum = position;
                //Toast.makeText(MainActivity.this, songs.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void wireWidgets(){
        songListView = (ListView) findViewById(R.id.listview_song);
    }

    private void createList(){
        songs.add(new ListExamples("All I Ask of You", "No more talk of darkness, forget these wide eyed fears...", R.drawable.AllIAskofYou));
        songs.add(new ListExamples("Think of Me", "Think of me, think of me fondly when we've said good bye...", R.drawable.ThinkofMe));
        songs.add(new ListExamples("Memory", "Midnight, not a sound from the pavement...", R.drawable.Memory));
        songs.add(new ListExamples("Corner of the Sky", "Everything has its season, Everything has its time, Show me a reason And I'll soon show you a rhyme...", R.drawable.CorneroftheSky));
        songs.add(new ListExamples("I Whistle a Happy Tune", "Whenever I feel afraid, I hold my head erect, And whistle a happy tune so no one will suspect I'm afraid...", R.drawable.IWhistleAHappyTune));
    }
}
