package com.makarevich.dmitry.crock;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class RulesComand extends AppCompatActivity {
    private Button btn_skip_rules_comand;
    private ImageView ic_rules_comand;
    private TextView txt_rules_comand, txt_comand, txt_rules_comand_main;
    DataBase dataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules__comand);
        dataBase = new DataBase(this);
        btn_skip_rules_comand = findViewById(R.id.btn_skip_rules_comand);
        ic_rules_comand = findViewById(R.id.ic_rules_comand);
        txt_rules_comand = findViewById(R.id.txt_rules_comand);
        txt_comand = findViewById(R.id.txt_comand);
        txt_rules_comand_main = findViewById(R.id.txt_rules_comand_main);
        btn_skip_rules_comand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dictionary = new Intent(RulesComand.this, DictionaryAll.class);
                startActivity(dictionary);
            }
        });
        PushImage();
        Font();
    }


    @Override
    public void onBackPressed() {
        Intent back = new Intent(RulesComand.this, Play_Mode.class);
        startActivity(back);
    }

    public void PushImage() {
        int first = R.drawable.rules;
        Glide
                .with(this)
                .load(first)
                .into(ic_rules_comand);
    }

    public void Font() {
        txt_rules_comand.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_comand.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_rules_comand_main.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        btn_skip_rules_comand.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }
}
