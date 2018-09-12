package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Time_NoTime extends AppCompatActivity {
    private ImageView ic_time, ic_normal;
    private TextView txt_crocodile_main, txt_game_mode, txt_make_selection, txt_on_time, txt_normal, txt_round_time, txt_time;
    private Button btn_start_game, btn_plus_ten, btn_minus_ten;
    private RelativeLayout rel_small_white, rel_timer;
    @SuppressLint("StaticFieldLeak")
    public static Context contextTimeNoTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time__no_time);
        contextTimeNoTime = getApplicationContext();
        btn_start_game = findViewById(R.id.btn_start_game);
        btn_minus_ten = findViewById(R.id.btn_minus_ten);
        btn_plus_ten = findViewById(R.id.btn_plus_ten);
        ic_time = findViewById(R.id.ic_time);
        ic_normal = findViewById(R.id.ic_normal);
        txt_crocodile_main = findViewById(R.id.txt_crocodile_main);
        txt_game_mode = findViewById(R.id.txt_game_mode);
        txt_make_selection = findViewById(R.id.txt_make_selection);
        txt_on_time = findViewById(R.id.txt_on_time);
        txt_time = findViewById(R.id.txt_time);
        txt_normal = findViewById(R.id.txt_normal);
        txt_round_time = findViewById(R.id.txt_round_time);
        rel_small_white = findViewById(R.id.rel_small_white);
        rel_timer = findViewById(R.id.rel_timer);

        btn_start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NextP();
            }
        });
        PushImage();
        ic_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartTime();
            }
        });
        ic_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartNoTime();
            }
        });
        btn_plus_ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MinusTenSec();
            }
        });
        btn_minus_ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlusTenSec();
            }
        });
        Font();
    }

    public static Context getContextTimeNoTime() {
        return contextTimeNoTime;
    }

    private void Font() {
        txt_crocodile_main.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_game_mode.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_on_time.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_normal.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_make_selection.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        btn_start_game.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        btn_plus_ten.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        btn_minus_ten.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_round_time.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(Time_NoTime.this, Play_Mode.class);
        startActivity(back);
    }

    public void PushImage() {
        int second = R.drawable.time;
        int third = R.drawable.no_time;

        Glide
                .with(this)
                .load(second)
                .into(ic_time);
        Glide
                .with(this)
                .load(third)
                .into(ic_normal);

    }

    private void StartTime() {
        txt_normal.setTextColor(Color.parseColor("#FFFFFF"));
        txt_on_time.setTextColor(Color.parseColor("#8CCB5E"));
        rel_small_white.setVisibility(View.VISIBLE);
        rel_timer.setVisibility(View.VISIBLE);
        SharedPref.LastSetTime();
    }

    private void StartNoTime() {
        txt_on_time.setTextColor(Color.parseColor("#FFFFFF"));
        txt_normal.setTextColor(Color.parseColor("#8CCB5E"));
        rel_small_white.setVisibility(View.INVISIBLE);
        rel_timer.setVisibility(View.INVISIBLE);
        SharedPref.LastSetNoTime();
    }

    private void MinusTenSec() {
        int timer = Integer.parseInt(txt_time.getText().toString());
        if (timer > 20) {
            int ok = timer - 10;
            txt_time.setText(String.valueOf(ok));
        } else {
            Toast.makeText(contextTimeNoTime, "Длительность раунда не может быть менее 20 секунд", Toast.LENGTH_SHORT).show();
        }
    }

    private void PlusTenSec() {
        int timer = Integer.parseInt(txt_time.getText().toString());
        if (timer == 200) {
            Toast.makeText(contextTimeNoTime, "Данная игра не предусматривает такие длинные раунды", Toast.LENGTH_SHORT).show();
        } else {
            int ok = timer + 10;
            txt_time.setText(String.valueOf(ok));
        }
    }

    private void NextP() {
        String proof = SharedPref.ReturnLastSet();
        if (proof.contains("none")) {
            Toast.makeText(contextTimeNoTime, "Выберите режим игры в котором вы хотите играть", Toast.LENGTH_SHORT).show();
        } else {
            String time = txt_time.getText().toString();
            Context applicationContext = Time_NoTime.getContextTimeNoTime();
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("ROUND_TIME", time);
            edit.apply();
            edit.commit();
            if (proof.contains("time")) {
                Intent time_next = new Intent(Time_NoTime.this, One_Time.class);
                startActivity(time_next);
            }
            if (proof.contains("no")) {
                Intent time_next = new Intent(Time_NoTime.this, One_Normal.class);
                startActivity(time_next);
            }
        }
    }


}
