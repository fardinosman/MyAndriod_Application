package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
   private ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        mediaPlayer = MediaPlayer.create(this, R.raw.father);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father","پدر",R.drawable.family_father,R.raw.father));
        words.add(new Word("mother","مادر",R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("son","فرزند پسر",R.drawable.family_son,R.raw.family_son));
        words.add(new Word("daugther","فرزند دختر",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word("older brother","برادر بزرگتر",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("younger brother","برادر جوانتر",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("older sister","خواهر بزرگتر",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("younger sister","خواهر کوچکتر",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("grandmother","مادر بزرگ",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Word("grandfather","پدر بزرگ",R.drawable.family_grandfather,R.raw.family_grandfather));



        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_family);


        ListView listView = (ListView) findViewById(R.id.family);

        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              Word word= words.get(i);
                mediaPlayer = MediaPlayer.create(FamilyActivity.this,word.getmAudioResourceId());
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
