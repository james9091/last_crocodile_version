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

public class RulesOneToOne extends AppCompatActivity {
    private Button btn_skip_rules_onetoone;
    private TextView txt_rules_one, txt_one_vs_one, txt_rules_one_main;
    private ImageView ic_rules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules__one_to_one);
        btn_skip_rules_onetoone = findViewById(R.id.btn_skip_rules_onetoone);
        txt_rules_one = findViewById(R.id.txt_rules_one);
        txt_one_vs_one = findViewById(R.id.txt_one_vs_one);
        txt_rules_one_main = findViewById(R.id.txt_rules_one_main);
        ic_rules = findViewById(R.id.ic_rules);
        btn_skip_rules_onetoone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dictionary = new Intent(RulesOneToOne.this, DictionaryAll.class);
                startActivity(dictionary);
            }
        });
        PushImage();
        Font();
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(RulesOneToOne.this, Play_Mode.class);
        startActivity(back);
    }

    public void PushImage() {
        int first = R.drawable.rules;
        Glide
                .with(this)
                .load(first)
                .into(ic_rules);
    }

    public void Font() {
        txt_rules_one.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_one_vs_one.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_rules_one_main.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        btn_skip_rules_onetoone.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }
}
