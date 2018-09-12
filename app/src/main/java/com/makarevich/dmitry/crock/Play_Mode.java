package com.makarevich.dmitry.crock;

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

public class Play_Mode extends AppCompatActivity {
    private ImageView ic_crock_one, ic_crock_two, ic_crock_three, ic_man_one, ic_man_two, ic_woman_one, ic_man_ten, ic_man_four, ic_man_five, ic_woman_two, ic_man_six, ic_man_seven, ic_man_eight;
    private TextView txt_main_name, txt_noisy, txt_party, txt_oneone, txt_comandcom, txt_comandcomand;
    @SuppressLint("StaticFieldLeak")
    public static Context context_play_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__mode);
        context_play_mode = getApplicationContext();
        txt_main_name = findViewById(R.id.txt_main_name);
        txt_noisy = findViewById(R.id.txt_noisy);
        txt_party = findViewById(R.id.txt_party);
        txt_oneone = findViewById(R.id.txt_oneone);
        txt_comandcom = findViewById(R.id.txt_comandcom);
        txt_comandcomand = findViewById(R.id.txt_comandcomand);
        ic_crock_one = findViewById(R.id.ic_crock_one);
        ic_crock_two = findViewById(R.id.ic_crock_two);
        ic_crock_three = findViewById(R.id.ic_crock_three);
        ic_man_one = findViewById(R.id.ic_man_one);
        ic_man_two = findViewById(R.id.ic_man_two);
        ic_woman_one = findViewById(R.id.ic_woman_one);
        ic_man_ten = findViewById(R.id.ic_man_ten);
        ic_man_four = findViewById(R.id.ic_man_four);
        ic_man_five = findViewById(R.id.ic_man_five);
        ic_woman_two = findViewById(R.id.ic_woman_two);
        ic_man_six = findViewById(R.id.ic_man_six);
        ic_man_seven = findViewById(R.id.ic_man_seven);
        ic_man_eight = findViewById(R.id.ic_man_eight);
        RelativeLayout one = findViewById(R.id.rel_one);
        RelativeLayout two = findViewById(R.id.rel_two);
        RelativeLayout three = findViewById(R.id.rel_five);
        PushImg();
        Font();
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getOne();
                Intent one = new Intent(Play_Mode.this, RulesOneToOne.class);
                startActivity(one);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comand = new Intent(Play_Mode.this, RulesComand.class);
                startActivity(comand);
                SharedPref.getTwo();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comvscom = new Intent(Play_Mode.this, RulesCommandToCommand.class);
                startActivity(comvscom);
                SharedPref.getTree();
            }
        });
    }

    public static Context getContextPlayMode() {
        return context_play_mode;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(Play_Mode.this, MainMenu.class);
        startActivity(back);

    }

    private void PushImg() {
        int first = R.drawable.crocko_green;
        int second = R.drawable.man_two;
        int third = R.drawable.man_three;
        int four = R.drawable.man_one;
        int five = R.drawable.wom_one;
        Glide
                .with(this)
                .load(first)
                .into(ic_crock_one);
        Glide
                .with(this)
                .load(first)
                .into(ic_crock_two);
        Glide
                .with(this)
                .load(first)
                .into(ic_crock_three);
        Glide
                .with(this)
                .load(second)
                .into(ic_man_one);
        Glide
                .with(this)
                .load(third)
                .into(ic_man_two);
        Glide
                .with(this)
                .load(five)
                .into(ic_woman_one);
        Glide
                .with(this)
                .load(four)
                .into(ic_man_ten);
        Glide
                .with(this)
                .load(third)
                .into(ic_man_four);
        Glide
                .with(this)
                .load(second)
                .into(ic_man_five);
        Glide
                .with(this)
                .load(five)
                .into(ic_woman_two);
        Glide
                .with(this)
                .load(third)
                .into(ic_man_six);
        Glide
                .with(this)
                .load(four)
                .into(ic_man_seven);
        Glide
                .with(this)
                .load(second)
                .into(ic_man_eight);
    }

    public void Font() {
        txt_main_name.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_oneone.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_comandcom.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_comandcomand.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_noisy.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_party.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }
}
