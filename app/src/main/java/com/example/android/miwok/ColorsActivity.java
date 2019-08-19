package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||

                    focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mediaPlayer.pause();
                mediaPlayer.seekTo(1);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red","سرخ",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("green","سبز",R.drawable.color_green,R.raw.color_green));
        words.add(new Word("brown","رنگ قهوه ای",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("gray","خاکستری",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("black","سیاه",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("white","سفید",R.drawable.color_white,R.raw.color_white));
        words.add(new Word("dusty yellow","زرد گرد و غبار",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));

        words.add(new Word("mustard yellow","خردل زر",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));




        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.colorList);

        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word= words.get(i);
                releaseMediaPlayer();;
                mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN);
                if (    result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {


                    mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceId());
                    mediaPlayer.start();
                }
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();


    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    /**
     * Clean up the media player by releasing its resources.
     */
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
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
