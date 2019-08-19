package com.example.android.miwok;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        Intent intent = getIntent();
        ReportCard reportCard = new ReportCard("Fardin",'A',"A-",85,95.5);
        Log.v("HHHHHHHHHHHHHHHHHHHH",reportCard.toString());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one","یکی",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two","دو",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three","سه",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four","چهار",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five","پنج",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six","شش" ,R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven", "هفت" ,R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight",  "هشت" ,R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine","نه",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten","ده",R.drawable.number_ten,R.raw.number_ten));



        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word= words.get(i);
                mediaPlayer = MediaPlayer.create(NumbersActivity.this,word.getmAudioResourceId());
                mediaPlayer.start();
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();


    }



    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }


}
