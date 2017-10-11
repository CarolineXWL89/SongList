package com.example.caroline.example;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements Parcelable, Comparable<ListExamples> {
    private ArrayList<ListExamples> songs = new ArrayList<>();
    private ListView songListView;
    public static final String SONG_NAME = "song name";
    public static final String SONG_DESC = "song desc";
    public static final String SONG_PIC = "picture";
    public static final String SONG_OBJ = "song";
    private int songNum;
    //private ContextMenu contextMenu;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
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
                /*i.putExtra("song name", songs.get(songNum).getName());
                i.putExtra("desc", songs.get(songNum).getDesc());
                i.putExtra("picture", songs.get(songNum).getImageSResourceId());*/
                i.putExtra("song", (Parcelable) songs.get(songNum)); // why does this need to be cast?

                //resourceID passed
                startActivity(i);
                //}
                songNum = position;
                //Toast.makeText(MainActivity.this, songs.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(songListView);
    }

    private void wireWidgets() {
        songListView = (ListView) findViewById(R.id.listview_song);
    }

    private void createList() {
        songs.add(new ListExamples("All I Ask of You", "No more talk of darkness, forget these wide eyed fears...", 5, R.drawable.alliaskofyou));
        songs.add(new ListExamples("Think of Me", "Think of me, think of me fondly when we've said good bye...", 2, R.drawable.thinkofme));
        songs.add(new ListExamples("memory", "Midnight, not a sound from the pavement...", 3, R.drawable.memory));
        songs.add(new ListExamples("Corner of the Sky", "Everything has its season, Everything has its time, Show me a reason And I'll soon show you a rhyme...", 1, R.drawable.cornerofthesky));
        songs.add(new ListExamples("I Whistle a Happy Tune", "Whenever I feel afraid, I hold my head erect, And whistle a happy tune so no one will suspect I'm afraid...", 4, R.drawable.iwhistleahappytune));
    }

    private void registerForContextMenu(final ListView listView) {
        songListView.setOnCreateContextMenuListener(new ListView.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                onCreateContextMenu(contextMenu, listView, contextMenuInfo); //need to figure out what is wrong
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.sortrank, contextMenu);
            }
        });
    }

    protected MainActivity(Parcel in) {
        if (in.readByte() == 0x01) {
            songs = new ArrayList<ListExamples>();
            in.readList(songs, ListExamples.class.getClassLoader());
        } else {
            songs = null;
        }
        songListView = (ListView) in.readValue(ListView.class.getClassLoader());
        songNum = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (songs == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(songs);
        }
        dest.writeValue(songListView);
        dest.writeInt(songNum);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MainActivity> CREATOR = new Parcelable.Creator<MainActivity>() {
        @Override
        public MainActivity createFromParcel(Parcel in) {
            return new MainActivity(in);
        }

        @Override
        public MainActivity[] newArray(int size) {
            return new MainActivity[size];
        }


    };

    @Override
    public int compareTo(@NonNull ListExamples listExamples) {
        return 0;
    }
}