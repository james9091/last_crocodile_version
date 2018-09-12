package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DictionaryAll extends AppCompatActivity {
    private ImageView ic_main_logo, ic_small, ic_hard, ic_easy, ic_medium, ic_happy, ic_starts, ic_animal, ic_planet, ic_professions, ic_transport;
    private TextView txt_crocodile, txt_select_dictionary, txt_starts, txt_animals, txt_planet, txt_professions, txt_transport;
    @SuppressLint("StaticFieldLeak")
    public static Context context_dictionary_all;
    private TextView txt_one_you, txt_two_you, txt_three_you, txt_five_you, txt_six_you;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary__all);
        context_dictionary_all = getApplicationContext();
        txt_crocodile = findViewById(R.id.txt_crocodile);
        txt_select_dictionary = findViewById(R.id.txt_select_dictionary);
        txt_starts = findViewById(R.id.txt_starts);
        txt_animals = findViewById(R.id.txt_animals);
        txt_planet = findViewById(R.id.txt_planet);
        txt_professions = findViewById(R.id.txt_professions);
        txt_transport = findViewById(R.id.txt_transport);
        txt_one_you = findViewById(R.id.txt_one_you);
        txt_two_you = findViewById(R.id.txt_two_you);
        txt_three_you = findViewById(R.id.txt_three_you);
        txt_six_you = findViewById(R.id.txt_six_you);
        txt_five_you = findViewById(R.id.txt_five_you);
        ic_main_logo = findViewById(R.id.ic_main_logo);
        ic_small = findViewById(R.id.ic_small);
        ic_hard = findViewById(R.id.ic_hard);
        ic_easy = findViewById(R.id.ic_easy);
        ic_medium = findViewById(R.id.ic_medium);
        ic_happy = findViewById(R.id.ic_happy);
        ic_starts = findViewById(R.id.ic_starts);
        ic_animal = findViewById(R.id.ic_animal);
        ic_planet = findViewById(R.id.ic_planet);
        ic_professions = findViewById(R.id.ic_professions);
        ic_transport = findViewById(R.id.ic_transport);
        RelativeLayout one = findViewById(R.id.rel_one);
        RelativeLayout two = findViewById(R.id.rel_two);
        RelativeLayout three = findViewById(R.id.rel_three);
        RelativeLayout six = findViewById(R.id.rel_six);
        RelativeLayout five = findViewById(R.id.rel_five);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Next();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.Play_Animal();
                SharedPref.Perehod_Two();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.Play_Planet();
                SharedPref.Perehod_Two();
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.Play_Kids();
                SharedPref.Perehod_Two();
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.Play_Profession();
                SharedPref.Perehod_Two();
            }
        });
        PushImage();
        Font();
        GetDicCount();
    }

    public static Context getContexDictionaryAll() {
        return context_dictionary_all;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(DictionaryAll.this, Play_Mode.class);
        startActivity(back);
    }

    public void Next() {
        Intent next = new Intent(DictionaryAll.this, Dictionary_Level.class);
        startActivity(next);
    }

    public void Font() {
        txt_crocodile.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_starts.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_animals.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_transport.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_select_dictionary.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_planet.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_professions.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

    public void PushImage() {

        int first = R.drawable.crocko_green;
        int second = R.drawable.sad;
        int third = R.drawable.medium;
        int four = R.drawable.easy;
        int five = R.drawable.hard;
        int six = R.drawable.mixsy;
        int seven = R.drawable.starts;
        int eight = R.drawable.animals;
        int nine = R.drawable.worlds;
        int ten = R.drawable.professions;
        int eleven = R.drawable.ship;


        Glide
                .with(this)
                .load(first)
                .into(ic_main_logo);
        Glide
                .with(this)
                .load(second)
                .into(ic_small);
        Glide
                .with(this)
                .load(third)
                .into(ic_hard);
        Glide
                .with(this)
                .load(four)
                .into(ic_easy);
        Glide
                .with(this)
                .load(five)
                .into(ic_medium);
        Glide
                .with(this)
                .load(six)
                .into(ic_happy);
        Glide
                .with(this)
                .load(seven)
                .into(ic_starts);
        Glide
                .with(this)
                .load(eight)
                .into(ic_animal);
        Glide
                .with(this)
                .load(nine)
                .into(ic_planet);
        Glide
                .with(this)
                .load(ten)
                .into(ic_professions);
        Glide
                .with(this)
                .load(eleven)
                .into(ic_transport);

    }

    @SuppressLint("SetTextI18n")
    public void GetDicCount() {

        Context applicationContext = DictionaryAll.getContexDictionaryAll();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");

        if (def_locale.contains("ru")) {
            String animal_ru = sharedPreferences.getString("RU_ANIMAL_CURSOR", "");
            String planet_ru = sharedPreferences.getString("RU_PLANET_CURSOR", "");
            String professions_ru = sharedPreferences.getString("RU_PROFESSIONS_CURSOR", "");
            String transport_ru = sharedPreferences.getString("RU_TRANSPORT_CURSOR", "");
            int start_int_ru = Integer.parseInt(sharedPreferences.getString("RU_EASY_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("RU_MEDIUM_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("RU_HARD_CURSOR", ""));
            String starting_ru = String.valueOf(start_int_ru);
            txt_one_you.setText(getString(R.string.good) + "\n" + starting_ru + "\n" + getString(R.string.word));
            txt_two_you.setText(getString(R.string.good) + "\n" + animal_ru + "\n" + getString(R.string.word));
            txt_three_you.setText(getString(R.string.good) + "\n" + planet_ru + "\n" + getString(R.string.word));
            txt_five_you.setText(getString(R.string.good) + "\n" + professions_ru + "\n" + getString(R.string.word));
            txt_six_you.setText(getString(R.string.good) + "\n" + transport_ru + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("en")) {
            String animal_en = sharedPreferences.getString("EN_ANIMAL_CURSOR", "");
            String planet_en = sharedPreferences.getString("EN_PLANET_CURSOR", "");
            String professions_en = sharedPreferences.getString("EN_PROFESSIONS_CURSOR", "");
            String transport_en = sharedPreferences.getString("EN_TRANSPORT_CURSOR", "");
            int start_int_en = Integer.parseInt(sharedPreferences.getString("EN_EASY_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("EN_MEDIUM_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("EN_HARD_CURSOR", ""));
            String starting_en = String.valueOf(start_int_en);
            txt_one_you.setText(getString(R.string.good) + "\n" + starting_en + "\n" + getString(R.string.word));
            txt_two_you.setText(getString(R.string.good) + "\n" + animal_en + "\n" + getString(R.string.word));
            txt_three_you.setText(getString(R.string.good) + "\n" + planet_en + "\n" + getString(R.string.word));
            txt_five_you.setText(getString(R.string.good) + "\n" + professions_en + "\n" + getString(R.string.word));
            txt_six_you.setText(getString(R.string.good) + "\n" + transport_en + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("de")) {
            String animal_de = sharedPreferences.getString("DE_ANIMAL_CURSOR", "");
            String planet_de = sharedPreferences.getString("DE_PLANET_CURSOR", "");
            String professions_de = sharedPreferences.getString("DE_PROFESSIONS_CURSOR", "");
            String transport_de = sharedPreferences.getString("DE_TRANSPORT_CURSOR", "");
            int start_int_de = Integer.parseInt(sharedPreferences.getString("DE_EASY_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("DE_MEDIUM_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("DE_HARD_CURSOR", ""));
            String starting_de = String.valueOf(start_int_de);
            txt_one_you.setText(getString(R.string.good) + "\n" + starting_de + "\n" + getString(R.string.word));
            txt_two_you.setText(getString(R.string.good) + "\n" + animal_de + "\n" + getString(R.string.word));
            txt_three_you.setText(getString(R.string.good) + "\n" + planet_de + "\n" + getString(R.string.word));
            txt_five_you.setText(getString(R.string.good) + "\n" + professions_de + "\n" + getString(R.string.word));
            txt_six_you.setText(getString(R.string.good) + "\n" + transport_de + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("es")) {
            String animal_es = sharedPreferences.getString("ES_ANIMAL_CURSOR", "");
            String planet_es = sharedPreferences.getString("ES_PLANET_CURSOR", "");
            String professions_es = sharedPreferences.getString("ES_PROFESSIONS_CURSOR", "");
            String transport_es = sharedPreferences.getString("ES_TRANSPORT_CURSOR", "");
            int start_int_es = Integer.parseInt(sharedPreferences.getString("ES_EASY_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("ES_MEDIUM_CURSOR", "")) + Integer.parseInt(sharedPreferences.getString("ES_HARD_CURSOR", ""));
            String starting_es = String.valueOf(start_int_es);
            txt_one_you.setText(getString(R.string.good) + "\n" + starting_es + "\n" + getString(R.string.word));
            txt_two_you.setText(getString(R.string.good) + "\n" + animal_es + "\n" + getString(R.string.word));
            txt_three_you.setText(getString(R.string.good) + "\n" + planet_es + "\n" + getString(R.string.word));
            txt_five_you.setText(getString(R.string.good) + "\n" + professions_es + "\n" + getString(R.string.word));
            txt_six_you.setText(getString(R.string.good) + "\n" + transport_es + "\n" + getString(R.string.word));
        }


    }
}
