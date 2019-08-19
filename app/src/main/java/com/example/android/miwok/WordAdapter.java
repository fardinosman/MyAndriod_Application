package com.example.android.miwok;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    int colorId;



    public WordAdapter(Activity context, ArrayList<Word> wordArrayList, int colorid){
        super(context,0,wordArrayList);
        colorId=colorid;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list,parent,false);
        }
       Word currentWordAdapter = getItem(position);

        TextView nameTextView0 =(TextView) listItemView.findViewById(R.id.miwoktxt);

        nameTextView0.setText(currentWordAdapter.getmMiwokTranslation());


        TextView nameTextView1 =(TextView) listItemView.findViewById(R.id.defaulttxt);

        nameTextView1.setText(currentWordAdapter.mDefaultTranslation);


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentWordAdapter.getimageSrc());

        View textView = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),colorId);
        textView.setBackgroundColor(color);



        return listItemView;
    }
}
