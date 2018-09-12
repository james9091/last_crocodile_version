package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makarevich.dmitry.crock.room.De_Animal;
import com.makarevich.dmitry.crock.room.De_Easy;
import com.makarevich.dmitry.crock.room.De_Hard;
import com.makarevich.dmitry.crock.room.De_Medium;
import com.makarevich.dmitry.crock.room.De_Planet;
import com.makarevich.dmitry.crock.room.De_Professions;
import com.makarevich.dmitry.crock.room.De_Transport;
import com.makarevich.dmitry.crock.room.Eng_Animal;
import com.makarevich.dmitry.crock.room.Eng_Easy;
import com.makarevich.dmitry.crock.room.Eng_Hard;
import com.makarevich.dmitry.crock.room.Eng_Medium;
import com.makarevich.dmitry.crock.room.Eng_Planet;
import com.makarevich.dmitry.crock.room.Eng_Professions;
import com.makarevich.dmitry.crock.room.Eng_Transport;
import com.makarevich.dmitry.crock.room.Es_Animal;
import com.makarevich.dmitry.crock.room.Es_Easy;
import com.makarevich.dmitry.crock.room.Es_Hard;
import com.makarevich.dmitry.crock.room.Es_Medium;
import com.makarevich.dmitry.crock.room.Es_Planet;
import com.makarevich.dmitry.crock.room.Es_Professions;
import com.makarevich.dmitry.crock.room.Es_Transport;
import com.makarevich.dmitry.crock.room.MyAppDataBase;
import com.makarevich.dmitry.crock.room.Rus_Animal;
import com.makarevich.dmitry.crock.room.Rus_H;
import com.makarevich.dmitry.crock.room.Rus_M;
import com.makarevich.dmitry.crock.room.Rus_Planet;
import com.makarevich.dmitry.crock.room.Rus_Professions;
import com.makarevich.dmitry.crock.room.Rus_Transport;
import com.makarevich.dmitry.crock.room.Words;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class One_Normal extends AppCompatActivity {
    private ImageView ic_player_one, ic_player_two, ic_ok_left, ic_ok_right;
    private Button btn_back_normal, btn_start_game;
    private TextView txt_player, txt_score_one, txt_score_two, txt_main_word, txt_one_vs_one_norm, txt_simple_mode, txt_count, txt_back_counter;
    private RelativeLayout reel_back_norm;
    @SuppressLint("StaticFieldLeak")
    public static Context context_one_normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one__normal);
        context_one_normal = getApplicationContext();
        ic_player_one = findViewById(R.id.ic_player_one);
        ic_player_two = findViewById(R.id.ic_player_two);
        ic_ok_left = findViewById(R.id.ic_ok_left);
        ic_ok_right = findViewById(R.id.ic_ok_right);
        txt_player = findViewById(R.id.txt_player);
        txt_score_one = findViewById(R.id.txt_score_one);
        txt_score_two = findViewById(R.id.txt_score_two);
        txt_main_word = findViewById(R.id.txt_main_word);
        txt_count = findViewById(R.id.txt_count);
        txt_one_vs_one_norm = findViewById(R.id.txt_one_vs_one_norm);
        reel_back_norm = findViewById(R.id.reel_back_norm);
        txt_back_counter = findViewById(R.id.txt_back_counter);
        txt_simple_mode = findViewById(R.id.txt_simple_mode);
        btn_back_normal = findViewById(R.id.btn_back_normal);
        btn_start_game = findViewById(R.id.btn_start_game);
        PushImage();
        Font();
        btn_back_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(One_Normal.this, Play_Mode.class);
                startActivity(back);
            }
        });
        ic_player_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerOne();
                WordsOneNormal();
            }
        });
        ic_player_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerTwo();
                WordsOneNormal();
            }
        });
        btn_start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackCount();
            }
        });
    }

    private void BackCount() {
        btn_start_game.setVisibility(View.INVISIBLE);
        txt_count.setVisibility(View.VISIBLE);
        txt_back_counter.setVisibility(View.VISIBLE);
        final CountDownTimer yourCountDownTimer = new CountDownTimer(6000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                txt_count.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                txt_count.setVisibility(View.INVISIBLE);
                txt_back_counter.setVisibility(View.INVISIBLE);
                reel_back_norm.setVisibility(View.INVISIBLE);
                WordsOneNormal();
                PlayerOne();
            }
        }.start();
    }

    public void Font() {
        txt_one_vs_one_norm.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_simple_mode.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        btn_back_normal.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

    public static Context getContexOneNormal() {
        return context_one_normal;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(One_Normal.this, Play_Mode.class);
        startActivity(back);
    }

    public void PushImage() {
        int second = R.drawable.ok;
        int third = R.drawable.player_one;
        int four = R.drawable.player_two;
        Glide
                .with(this)
                .load(second)
                .into(ic_ok_left);
        Glide
                .with(this)
                .load(second)
                .into(ic_ok_right);
        Glide
                .with(this)
                .load(third)
                .into(ic_player_one);
        Glide
                .with(this)
                .load(four)
                .into(ic_player_two);
    }

    private void PlayerOne() {
        txt_player.setText(getString(R.string.player_one_g));
        ic_ok_left.setVisibility(View.VISIBLE);
        ic_ok_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ic_ok_left.setVisibility(View.INVISIBLE);
                txt_main_word.setText(" ");
                int score = Integer.parseInt(txt_score_one.getText().toString()) + 1;
                txt_score_one.setText(String.valueOf(score));
                txt_player.setText(" ");
                WordsOneNormal();
                PlayerTwo();
            }
        });
    }

    private void PlayerTwo() {
        txt_player.setText(getString(R.string.player_two_g));
        ic_ok_right.setVisibility(View.VISIBLE);
        ic_ok_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ic_ok_right.setVisibility(View.INVISIBLE);
                int score = Integer.parseInt(txt_score_two.getText().toString()) + 1;
                txt_score_two.setText(String.valueOf(score));
                txt_player.setText(" ");
                txt_main_word.setText(" ");
                WordsOneNormal();
                PlayerOne();
            }
        });
    }

    public void WordsOneNormal() {
        Context applicationContext = One_Normal.getContexOneNormal();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String play_game = sharedPreferences.getString("DICTIONARY_PLAY", "");
        Random rnd = new Random(System.currentTimeMillis());
        if (def_locale.contains("ru")) {
            if (play_game.contains("easy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Words> wordss = myAppDataBase.myinterface().getEasy_rus();
                for (Words wod : wordss) {
                    linkedList.add(wod.getEasy_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_EASY_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);

            }
            if (play_game.contains("medium")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_M> wordss = myAppDataBase.myinterface().getMedium_rus();
                for (Rus_M rus_m : wordss) {
                    linkedList.add(rus_m.getMedium_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_MEDIUM_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("hard")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_H> wordss = myAppDataBase.myinterface().getHard_rus();
                for (Rus_H rus_h : wordss) {
                    linkedList.add(rus_h.getHard_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_HARD_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("mixsy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_H> wordss = myAppDataBase.myinterface().getHard_rus();
                for (Rus_H rus_h : wordss) {
                    linkedList.add(rus_h.getHard_rus());
                }
                int max_value = 700;
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("animal")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_Animal> wordss = myAppDataBase.myinterface().getAnimal_rus();
                for (Rus_Animal rus_animal : wordss) {
                    linkedList.add(rus_animal.getAnimal_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_ANIMAL_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("planet")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_Planet> wordss = myAppDataBase.myinterface().getPlanet_rus();
                for (Rus_Planet rus_planet : wordss) {
                    linkedList.add(rus_planet.getPlanet_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_PLANET_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("profession")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_Professions> wordss = myAppDataBase.myinterface().getProfessions_rus();
                for (Rus_Professions rus_professions : wordss) {
                    linkedList.add(rus_professions.getProfessions_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_PROFESSIONS_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("transport")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Rus_Transport> wordss = myAppDataBase.myinterface().getTransport_rus();
                for (Rus_Transport rus_transport : wordss) {
                    linkedList.add(rus_transport.getTransport_rus());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("RU_TRANSPORT_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }

        }

        if (def_locale.contains("en")) {
            if (play_game.contains("easy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Easy> wordss = myAppDataBase.myinterface().getEasy_eng();
                for (Eng_Easy eng_easy : wordss) {
                    linkedList.add(eng_easy.getEasy_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_EASY_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);

            }
            if (play_game.contains("medium")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Medium> wordss = myAppDataBase.myinterface().getMedium_eng();
                for (Eng_Medium eng_medium : wordss) {
                    linkedList.add(eng_medium.getMedium_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_MEDIUM_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("hard")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Hard> wordss = myAppDataBase.myinterface().getHard_eng();
                for (Eng_Hard eng_hard : wordss) {
                    linkedList.add(eng_hard.getHard_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_HARD_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("mixsy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Hard> wordss = myAppDataBase.myinterface().getHard_eng();
                for (Eng_Hard eng_hard : wordss) {
                    linkedList.add(eng_hard.getHard_eng());
                }
                int max_value = 700;
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("animal")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Animal> wordss = myAppDataBase.myinterface().getAnimal_eng();
                for (Eng_Animal eng_animal : wordss) {
                    linkedList.add(eng_animal.getAnimal_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_ANIMAL_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("planet")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Planet> wordss = myAppDataBase.myinterface().getPlanet_eng();
                for (Eng_Planet eng_planet : wordss) {
                    linkedList.add(eng_planet.getPlanet_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_PLANET_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("profession")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Professions> wordss = myAppDataBase.myinterface().getProfessions_eng();
                for (Eng_Professions eng_professions : wordss) {
                    linkedList.add(eng_professions.getProfessions_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_PROFESSIONS_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("transport")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Eng_Transport> wordss = myAppDataBase.myinterface().getTransport_eng();
                for (Eng_Transport eng_transport : wordss) {
                    linkedList.add(eng_transport.getTransport_eng());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("EN_TRANSPORT_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }

        }
        if (def_locale.contains("de")) {
            if (play_game.contains("easy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Easy> wordss = myAppDataBase.myinterface().getDeutch_easy();
                for (De_Easy de_easy : wordss) {
                    linkedList.add(de_easy.getDeutch_easy());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_EASY_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);

            }
            if (play_game.contains("medium")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Medium> wordss = myAppDataBase.myinterface().getDeutch_medium();
                for (De_Medium de_medium : wordss) {
                    linkedList.add(de_medium.getDeutch_medium());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_MEDIUM_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("hard")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Hard> wordss = myAppDataBase.myinterface().getDeutch_hard();
                for (De_Hard de_hard : wordss) {
                    linkedList.add(de_hard.getDeutch_hard());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_HARD_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("mixsy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Hard> wordss = myAppDataBase.myinterface().getDeutch_hard();
                for (De_Hard de_hard : wordss) {
                    linkedList.add(de_hard.getDeutch_hard());
                }
                int max_value = 700;
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("animal")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Animal> wordss = myAppDataBase.myinterface().getDeutch_animal();
                for (De_Animal de_animal : wordss) {
                    linkedList.add(de_animal.getDeutch_animal());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_ANIMAL_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("planet")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Planet> wordss = myAppDataBase.myinterface().getDeutch_planet();
                for (De_Planet de_planet : wordss) {
                    linkedList.add(de_planet.getDeutch_planet());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_PLANET_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("profession")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Professions> wordss = myAppDataBase.myinterface().getDeutch_professions();
                for (De_Professions de_professions : wordss) {
                    linkedList.add(de_professions.getDeutch_professions());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_PROFESSIONS_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("transport")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<De_Transport> wordss = myAppDataBase.myinterface().getDeutch_transport();
                for (De_Transport de_transport : wordss) {
                    linkedList.add(de_transport.getDeutch_transport());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("DE_TRANSPORT_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }

        }
        if (def_locale.contains("es")) {
            if (play_game.contains("easy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Easy> wordss = myAppDataBase.myinterface().getSpain_easy();
                for (Es_Easy es_easy : wordss) {
                    linkedList.add(es_easy.getSpain_easy());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_EASY_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);

            }
            if (play_game.contains("medium")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Medium> wordss = myAppDataBase.myinterface().getSpain_medium();
                for (Es_Medium es_medium : wordss) {
                    linkedList.add(es_medium.getSpain_medium());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_MEDIUM_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("hard")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Hard> wordss = myAppDataBase.myinterface().getHard_spain();
                for (Es_Hard es_hard : wordss) {
                    linkedList.add(es_hard.getHard_spain());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_HARD_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("mixsy")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Hard> wordss = myAppDataBase.myinterface().getHard_spain();
                for (Es_Hard es_hard : wordss) {
                    linkedList.add(es_hard.getHard_spain());
                }
                int max_value = 700;
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("animal")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Animal> wordss = myAppDataBase.myinterface().getAnimal_spain();
                for (Es_Animal es_animal : wordss) {
                    linkedList.add(es_animal.getAnimal_spain());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_ANIMAL_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("planet")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Planet> wordss = myAppDataBase.myinterface().getPlanet_spain();
                for (Es_Planet es_planet : wordss) {
                    linkedList.add(es_planet.getPlanet_spain());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_PLANET_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("profession")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Professions> wordss = myAppDataBase.myinterface().getProfesions_spain();
                for (Es_Professions es_professions : wordss) {
                    linkedList.add(es_professions.getProfesions_spain());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_PROFESSIONS_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
            if (play_game.contains("transport")) {
                MyAppDataBase myAppDataBase;
                myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
                List<String> linkedList = new LinkedList<>();
                List<Es_Transport> wordss = myAppDataBase.myinterface().getTransport_spain();
                for (Es_Transport es_transport : wordss) {
                    linkedList.add(es_transport.getTransport_spain());
                }
                int max_value = Integer.parseInt(sharedPreferences.getString("ES_TRANSPORT_CURSOR", ""));
                int number = 1 + rnd.nextInt(max_value - 1 + 1);
                String string_ok = linkedList.get(number);
                txt_main_word.setText(string_ok);
            }
        }
    }
}
