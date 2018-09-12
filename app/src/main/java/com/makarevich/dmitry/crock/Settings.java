package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Settings extends AppCompatActivity {
    private ImageView ic_logo_large, ic_logo_small, ic_logo_small_two, ic_play, ic_book, ic_developer, ic_deutch, ic_russian, ic_english, ic_spain;
    private TextView txt_settings, txt_do, txt_choice, txt_change_lang, txt_we_plays, txt_about_developer;
    @SuppressLint("StaticFieldLeak")
    public static Context context_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        context_settings = getApplicationContext();
        RelativeLayout three = findViewById(R.id.rel_five);
        txt_settings = findViewById(R.id.txt_settings);
        txt_do = findViewById(R.id.txt_do);
        txt_choice = findViewById(R.id.txt_choice);
        txt_change_lang = findViewById(R.id.txt_change_lang);
        txt_we_plays = findViewById(R.id.txt_we_plays);
        txt_about_developer = findViewById(R.id.txt_about_developer);
        ic_spain = findViewById(R.id.ic_spain);
        ic_deutch = findViewById(R.id.ic_deutch);
        ic_russian = findViewById(R.id.ic_russian);
        ic_english = findViewById(R.id.ic_english);
        ic_logo_large = findViewById(R.id.ic_logo_large);
        ic_logo_small = findViewById(R.id.ic_logo_small);
        ic_logo_small_two = findViewById(R.id.ic_logo_small_two);
        ic_play = findViewById(R.id.ic_play);
        ic_book = findViewById(R.id.ic_book);
        ic_developer = findViewById(R.id.ic_developer);
        PushImage();
        Font();

        ic_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.LangRu();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Settings.this);
                builder.setTitle(getString(R.string.about_developer))
                        .setMessage("Тут будет какой-то текст")
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setNegativeButton(getString(R.string.back),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }

        });
        ic_spain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeLanguage change = new ChangeLanguage();
                change.Spain();
            }
        });
        ic_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeLanguage change = new ChangeLanguage();
                change.Russian();
            }
        });
        ic_russian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeLanguage change = new ChangeLanguage();
                change.English();
            }
        });
        ic_deutch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeLanguage change = new ChangeLanguage();
                change.Germany();
            }
        });
    }

    public static Context getContexSetings() {
        return context_settings;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(Settings.this, MainMenu.class);
        startActivity(back);
    }

    public void PushImage() {
        int first = R.drawable.crocko_green;
        int second = R.drawable.language;
        int third = R.drawable.gaming;
        int four = R.drawable.ninj;
        int five = R.drawable.germany;
        int six = R.drawable.england;
        int seven = R.drawable.russian;
        int eight = R.drawable.spain;
        Glide
                .with(this)
                .load(first)
                .into(ic_logo_large);
        Glide
                .with(this)
                .load(first)
                .into(ic_logo_small);
        Glide
                .with(this)
                .load(first)
                .into(ic_logo_small_two);
        Glide
                .with(this)
                .load(second)
                .into(ic_play);
        Glide
                .with(this)
                .load(third)
                .into(ic_book);
        Glide
                .with(this)
                .load(four)
                .into(ic_developer);
        Glide
                .with(this)
                .load(five)
                .into(ic_deutch);
        Glide
                .with(this)
                .load(six)
                .into(ic_russian);
        Glide
                .with(this)
                .load(seven)
                .into(ic_english);
        Glide
                .with(this)
                .load(eight)
                .into(ic_spain);
    }

    public void Font() {
        txt_settings.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_change_lang.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_we_plays.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_about_developer.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_do.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_choice.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }
}
