package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("where are you going?","کجا میری؟",R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?","اسم شما چیست؟",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...","اسم من هست...",R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?","حال شما چطور است؟",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.","حس خوبی دارم.",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","داری میای؟",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.","بله ، من می آیم",R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.","دارم میام.",R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.","بیا بریم.",R.raw.phrase_lets_go));
        words.add(new Word("Come here.","بیا اینجا.",R.raw.phrase_come_here));



        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.phrases);

        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word= words.get(i);
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this,word.getmAudioResourceId());
                mediaPlayer.start();
            }
        });

    }
}
