package com.example.caroline.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SongScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_screen);

        Intent i = getIntent();
        String messageFromMain = i.getStringExtra(MainActivity.SONG_KEY);
        Toast.makeText(this, messageFromMain, Toast.LENGTH_SHORT).show();
    }
}
