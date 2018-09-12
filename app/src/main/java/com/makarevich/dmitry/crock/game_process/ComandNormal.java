package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

public class ComandNormal extends AppCompatActivity {
    private ImageView ic_pic_one, ic_pic_two, ic_pic_three, ic_pic_four, ic_refresh, ic_add_player, ic_complete;
    private Button btn_back, btn_plus, btn_close, btn_add_player, btn_close_score;
    private RelativeLayout rel_three, rel_add_player, rel_command_score;
    private EditText edit_player_name;
    private ListView listvi;
    TextView txt_player_game, txt_main_word, txt_command, txt_simple_mode, txt_add_players, txt_show_word, txt_player, txt_what;
    @SuppressLint("StaticFieldLeak")
    public static Context context_command_normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comand__normal);
        context_command_normal = getApplicationContext();
        ic_pic_one = findViewById(R.id.ic_pic_one);
        ic_pic_two = findViewById(R.id.ic_pic_two);
        ic_pic_three = findViewById(R.id.ic_pic_three);
        ic_pic_four = findViewById(R.id.ic_pic_four);
        edit_player_name = findViewById(R.id.edit_player_name);
        ic_refresh = findViewById(R.id.ic_refresh);
        ic_add_player = findViewById(R.id.ic_add_player);
        ic_complete = findViewById(R.id.ic_complete);
        btn_plus = findViewById(R.id.btn_plus);
        txt_player_game = findViewById(R.id.txt_player_game);
        txt_main_word = findViewById(R.id.txt_main_word);
        txt_show_word = findViewById(R.id.txt_show_word);
        txt_what = findViewById(R.id.txt_what);
        txt_player = findViewById(R.id.txt_player);
        btn_back = findViewById(R.id.btn_back);
        btn_close_score = findViewById(R.id.btn_close_score);
        btn_close = findViewById(R.id.btn_close);
        btn_add_player = findViewById(R.id.btn_add_player);
        txt_command = findViewById(R.id.txt_command);
        txt_simple_mode = findViewById(R.id.txt_simple_mode);
        txt_add_players = findViewById(R.id.txt_add_players);
        rel_add_player = findViewById(R.id.rel_add_player);
        rel_command_score = findViewById(R.id.rel_command_score);
        rel_three = findViewById(R.id.rel_three);
        listvi = findViewById(R.id.listvi);
        PushPic();
        Font();
        final List<String> linkedList = new LinkedList<>();
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rel_three.setVisibility(View.GONE);
                rel_add_player.setVisibility(View.VISIBLE);
                PushAddPlayerPIc();
            }
        });
        btn_add_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ic_refresh.setVisibility(View.VISIBLE);
                ic_complete.setVisibility(View.VISIBLE);
                String player = edit_player_name.getText().toString();
                linkedList.add(player);
                Toast.makeText(ComandNormal.this, getString(R.string.you_add_player_to_com) + player, Toast.LENGTH_SHORT).show();
                edit_player_name.setText("");
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ComandNormal.this,
                        R.layout.list_item, R.id.label, linkedList);
                listvi.setAdapter(adapter);
                listvi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                            long id) {
                        String ok = ((EditText) itemClicked.findViewById(R.id.edit)).getText().toString();
                        int score = Integer.parseInt(ok) + 1;
                        String complete = String.valueOf(score);
                        ((EditText) itemClicked.findViewById(R.id.edit)).setText(complete);
                        Toast.makeText(getApplicationContext(), "Игрок " + ((TextView) itemClicked.findViewById(R.id.label)).getText() + " зарабатывает 1 балл",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rel_add_player.setVisibility(View.GONE);
                rel_three.setVisibility(View.VISIBLE);


            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(ComandNormal.this, Play_Mode.class);
                startActivity(back);
            }
        });
        ic_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_show_word.setVisibility(View.VISIBLE);
                txt_player.setVisibility(View.VISIBLE);
                try {
                    int linked_size = linkedList.size();
                    Random rnd = new Random(System.currentTimeMillis());
                    int number = rnd.nextInt(linked_size + 1);
                    String test = linkedList.get(number);
                    txt_player_game.setText(test);
                    WordsComandNormal();
                } catch (Exception e) {
                }
            }
        });
        ic_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rel_command_score.setVisibility(View.VISIBLE);
            }
        });
        btn_close_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rel_command_score.setVisibility(View.INVISIBLE);
                WordsComandNormal();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ComandNormal.this, MainMenu.class);
        startActivity(back);
    }

    public void Font() {
        txt_command.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_simple_mode.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        btn_back.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        btn_add_player.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        btn_close.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_add_players.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        btn_plus.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_what.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

    public static Context getContexCommandNormal() {
        return context_command_normal;
    }

    private void PushPic() {

        int first = R.drawable.man_first;
        int second = R.drawable.man_second;
        int third = R.drawable.man_third;
        int four = R.drawable.man_four;
        int five = R.drawable.refresh;
        int six = R.drawable.ok;

        Glide
                .with(this)
                .load(first)
                .into(ic_pic_one);
        Glide
                .with(this)
                .load(second)
                .into(ic_pic_two);
        Glide
                .with(this)
                .load(third)
                .into(ic_pic_three);
        Glide
                .with(this)
                .load(four)
                .into(ic_pic_four);
        Glide
                .with(this)
                .load(five)
                .into(ic_refresh);
        Glide
                .with(this)
                .load(six)
                .into(ic_complete);
    }

    private void PushAddPlayerPIc() {

        int first = R.drawable.hands_add;


        Glide
                .with(this)
                .load(first)
                .into(ic_add_player);
    }

    public void WordsComandNormal() {
        Context applicationContext = ComandNormal.getContexCommandNormal();
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
