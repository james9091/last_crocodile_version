package com.makarevich.dmitry.crock.game_dictionary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makarevich.dmitry.crock.R;
import com.makarevich.dmitry.crock.other_class.SharedPref;
import com.makarevich.dmitry.crock.game_process.Play_Mode;

public class DictionaryLevel extends AppCompatActivity {
    private ImageView ic_logo_one, ic_logo_two, ic_logo_three, ic_easy, ic_medium, ic_hard, ic_mix;
    private TextView txt_dictionary, txt_choose, txt_complexity, txt_easy, txt_medium, txt_hard, txt_mix;
    @SuppressLint("StaticFieldLeak")
    public static Context context_dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_level);
        context_dictionary = getApplicationContext();
        txt_dictionary = findViewById(R.id.txt_dictionary);
        txt_choose = findViewById(R.id.txt_choose);
        txt_complexity = findViewById(R.id.txt_complexity);
        txt_easy = findViewById(R.id.txt_easy);
        txt_medium = findViewById(R.id.txt_medium);
        txt_hard = findViewById(R.id.txt_hard);
        txt_mix = findViewById(R.id.txt_mix);
        ic_logo_one = findViewById(R.id.ic_logo_one);
        ic_logo_two = findViewById(R.id.ic_logo_two);
        ic_logo_three = findViewById(R.id.ic_logo_three);
        ic_easy = findViewById(R.id.ic_easy);
        ic_medium = findViewById(R.id.ic_medium);
        ic_hard = findViewById(R.id.ic_hard);
        ic_mix = findViewById(R.id.ic_mix);
        RelativeLayout one = findViewById(R.id.rel_one);
        RelativeLayout two = findViewById(R.id.rel_two);
        RelativeLayout five = findViewById(R.id.rel_three);
        RelativeLayout fives = findViewById(R.id.rel_four);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getDicOne();
                SharedPref.Perehod();
                SharedPref.Play_Start_Easy();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getDicTwo();
                SharedPref.Perehod();
                SharedPref.Play_Start_Medium();
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getDicTree();
                SharedPref.Perehod();
                SharedPref.Play_Start_Hard();
            }
        });
        fives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.Perehod();
                SharedPref.Play_Start_Mixsy();

            }
        });

        PushImage();
        Font();
    }

    public static Context getContexDictionary() {
        return context_dictionary;
    }

    @Override
    public void onBackPressed() {
        Intent bac = new Intent(DictionaryLevel.this, Play_Mode.class);
        startActivity(bac);
    }

    public void PushImage() {
        int first = R.drawable.crocko_green;
        int second = R.drawable.easy;
        int third = R.drawable.medium;
        int four = R.drawable.hard;
        int five = R.drawable.mixsy;
        Glide
                .with(this)
                .load(first)
                .into(ic_logo_one);
        Glide
                .with(this)
                .load(first)
                .into(ic_logo_two);
        Glide
                .with(this)
                .load(first)
                .into(ic_logo_three);
        Glide
                .with(this)
                .load(second)
                .into(ic_easy);
        Glide
                .with(this)
                .load(third)
                .into(ic_medium);
        Glide
                .with(this)
                .load(four)
                .into(ic_hard);
        Glide
                .with(this)
                .load(five)
                .into(ic_mix);
    }

    public void Font() {
        txt_dictionary.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_easy.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_medium.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_hard.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_choose.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_complexity.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_mix.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }
}
