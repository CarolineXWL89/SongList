package com.example.caroline.example;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SongScreen extends AppCompatActivity {

    private TextView songName, songDesc;
    private ImageView songPic;
    private String name, desc;
    private int pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_screen);

        Intent i = getIntent();
        name = i.getStringExtra(MainActivity.SONG_NAME);
        desc = i.getStringExtra(MainActivity.SONG_DESC);
        pic = i.getIntExtra(MainActivity.SONG_PIC, 0);
        //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        wireWidgets();
        setStuff();

    }

    public void wireWidgets(){
        songName = (TextView) findViewById(R.id.textView_song_name);
        songDesc = (TextView) findViewById(R.id.textView_desc);
        songPic = (ImageView) findViewById(R.id.imageView_pic);
    }

    public void setStuff(){
        songName.setText(name);
        songDesc.setText(desc);
        songPic.setImageResource(pic);
    }
}
