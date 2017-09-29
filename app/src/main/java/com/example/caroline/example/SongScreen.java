package com.example.caroline.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SongScreen extends AppCompatActivity {

    private TextView songName, songDesc;
    private String name, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_screen);

        Intent i = getIntent();
        name = i.getStringExtra(MainActivity.SONG_NAME);
        desc = i.getStringExtra(MainActivity.SONG_DESC);
        //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        wireWidgets();
        setText();

    }

    public void wireWidgets(){
        songName = (TextView) findViewById(R.id.textView_song_name);
        songDesc = (TextView) findViewById(R.id.textView_desc);
    }

    public void setText(){
        songName.setText(name);
        songDesc.setText(desc);
    }
}
