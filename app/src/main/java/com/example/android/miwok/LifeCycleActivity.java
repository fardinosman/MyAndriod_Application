package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("LifeCycleActivity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("LifeCycleActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("LifeCycleActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("LifeCycleActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("LifeCycleActivity","onDestroy");
    }
}
