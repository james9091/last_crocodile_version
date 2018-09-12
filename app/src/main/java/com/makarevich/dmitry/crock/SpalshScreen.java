package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.auth.FirebaseAuth;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

public class SpalshScreen extends AppCompatActivity {
    private ImageView ic_crock;
    private FirebaseAuth firebaseAuth;
    private ProgressBar pro;
    private TextView txt_crocodile_splash, txt_loading;
    @SuppressLint("StaticFieldLeak")
    public static Context contex_splash_screen;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh__screen);
        contex_splash_screen = getApplicationContext();
        dataBase = new DataBase(this);
        txt_crocodile_splash = findViewById(R.id.txt_crocodile_splash);
        txt_loading = findViewById(R.id.txt_loading);
        ic_crock = findViewById(R.id.ic_crock);
        pro = findViewById(R.id.progressBar2);
        firebaseAuth = FirebaseAuth.getInstance();
        ShimmerFrameLayout cont =
                findViewById(R.id.shimmer);
        cont.startShimmerAnimation();
        PushImage();
        Font();
        new AsyncLoad().execute();
        Сheck();
        ChangeLanguage change_language = new ChangeLanguage();
        change_language.MainLang();
        Podgr();
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(SpalshScreen.this, SpalshScreen.class);
        startActivity(back);
    }

    public static Context getContexSplashScreen() {
        return contex_splash_screen;
    }

    public void PushImage() {

        int first = R.drawable.crocko_green;


        Glide
                .with(this)
                .load(first)
                .into(ic_crock);

    }

    public void Font() {
        txt_crocodile_splash.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/cro.otf"));
        txt_loading.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/cro.otf"));

    }

    @SuppressLint("StaticFieldLeak")
    private class AsyncLoad extends AsyncTask<Void, Integer, Void> {
        private int load = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected Void doInBackground(Void... voids) {

            while (load < 65) {
                load++;
                publishProgress(load);
                SystemClock.sleep(55);

            }
            String s = SharedPref.SplashReturnPlay();

            if (s.contains("yes")) {
                // если в шареде есть yes то ничего не делаем
                if (firebaseAuth.getCurrentUser() != null) {
                    Intent menu = new Intent(SpalshScreen.this, MainMenu.class);
                    startActivity(menu);
                } else {
                    Intent registr = new Intent(SpalshScreen.this, Registration.class);
                    startActivity(registr);
                }
            } else {
                // если в шареде нету yes то делаем
                RoomDataBase();
                //CheckTwo();
                if (firebaseAuth.getCurrentUser() != null) {
                    Intent menu = new Intent(SpalshScreen.this, MainMenu.class);
                    startActivity(menu);
                } else {
                    Intent registr = new Intent(SpalshScreen.this, Registration.class);
                    startActivity(registr);
                }
            }


            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pro.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {

        }
    }

    public void Сheck() {
        String check = InternetConnection.isOnline();
        if (check.contains("bad")) {
            Toast.makeText(contex_splash_screen, getString(R.string.check_internet), Toast.LENGTH_SHORT).show();
            WifiManager Wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            assert Wifi != null;
            Wifi.setWifiEnabled(true);
        }
    }

    public void Podgr() {
        String s = SharedPref.SplashReturnPlay();
        if (s.contains("yes")) {

        } else {
            txt_loading.setText(getString(R.string.dictionary_downloads));
            Animation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(500);
            anim.setStartOffset(20);
            anim.setRepeatMode(Animation.REVERSE);
            anim.setRepeatCount(Animation.INFINITE);
            txt_loading.startAnimation(anim);
        }

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void RoomDataBase() {
        SharedPref.SplashScreenProof();
        //русские
        InputStream is = getResources().openRawResource(R.raw.animal_ru);
        InputStream two = getResources().openRawResource(R.raw.planeta_ru);
        InputStream three = getResources().openRawResource(R.raw.professions_ru);
        InputStream four = getResources().openRawResource(R.raw.transport_ru);
        InputStream five = getResources().openRawResource(R.raw.start_easy_ru);
        InputStream six = getResources().openRawResource(R.raw.start_medium_ru);
        InputStream seven = getResources().openRawResource(R.raw.start_hard_ru);
        //английские
        InputStream eight = getResources().openRawResource(R.raw.animal_en);
        InputStream nine = getResources().openRawResource(R.raw.planeta_en);
        InputStream ten = getResources().openRawResource(R.raw.professions_en);
        InputStream eleven = getResources().openRawResource(R.raw.transport_en);
        InputStream twelwe = getResources().openRawResource(R.raw.start_easy_en);
        InputStream thirteen = getResources().openRawResource(R.raw.start_medium_en);
        InputStream fourteen = getResources().openRawResource(R.raw.start_hard_en);
        //немецкие
        InputStream fifteen = getResources().openRawResource(R.raw.animal_de);
        InputStream sixteen = getResources().openRawResource(R.raw.planeta_de);
        InputStream seventeen = getResources().openRawResource(R.raw.professions_de);
        InputStream eightteen = getResources().openRawResource(R.raw.transport_de);
        InputStream nineteen = getResources().openRawResource(R.raw.start_easy_de);
        InputStream twenty = getResources().openRawResource(R.raw.start_medium_de);
        InputStream twentyone = getResources().openRawResource(R.raw.start_hard_de);
        //испанские
        InputStream twentytwo = getResources().openRawResource(R.raw.animal_es);
        InputStream twentythree = getResources().openRawResource(R.raw.planeta_es);
        InputStream twentyfour = getResources().openRawResource(R.raw.professions_es);
        InputStream twentyfive = getResources().openRawResource(R.raw.transport_es);
        InputStream twentysix = getResources().openRawResource(R.raw.start_easy_es);
        InputStream twentyseven = getResources().openRawResource(R.raw.start_medium_es);
        InputStream twentyeight = getResources().openRawResource(R.raw.start_hard_es);
        MyAppDataBase myAppDataBase;
        myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "allwords").allowMainThreadQueries().build();
        String test = Locale.getDefault().getLanguage();

        Context applicationContext = SpalshScreen.getContexSplashScreen();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("DEFAULT_LOCALE", test);
        edit.apply();
        edit.commit();

        if (test.contains("ru")) {
            // Подгружаем русские словари в Room
            // подгружаем рус изи
            try {
                Words words = new Words();
                BufferedReader br = new BufferedReader(new InputStreamReader(five));
                String line;

                while ((line = br.readLine()) != null) {
                    words.setEasy_rus(line);
                    myAppDataBase.myinterface().addWord(words);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем рус медиум
            try {
                Rus_M rus_m = new Rus_M();
                BufferedReader br = new BufferedReader(new InputStreamReader(six));
                String line;

                while ((line = br.readLine()) != null) {
                    rus_m.setMedium_rus(line);
                    myAppDataBase.myinterface().addMediumRus(rus_m);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем рус хард
            try {
                Rus_H rus_h = new Rus_H();
                BufferedReader br = new BufferedReader(new InputStreamReader(seven));
                String line;

                while ((line = br.readLine()) != null) {
                    rus_h.setHard_rus(line);
                    myAppDataBase.myinterface().addHardRus(rus_h);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем рус животные
            try {
                Rus_Animal rus_animal = new Rus_Animal();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;

                while ((line = br.readLine()) != null) {
                    rus_animal.setAnimal_rus(line);
                    myAppDataBase.myinterface().addRusAnimal(rus_animal);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем рус планета
            try {
                Rus_Planet rus_planet = new Rus_Planet();
                BufferedReader br = new BufferedReader(new InputStreamReader(two));
                String line;

                while ((line = br.readLine()) != null) {
                    rus_planet.setPlanet_rus(line);
                    myAppDataBase.myinterface().addRusPlanet(rus_planet);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем рус профессии
            try {
                Rus_Professions rus_professions = new Rus_Professions();
                BufferedReader br = new BufferedReader(new InputStreamReader(three));
                String line;

                while ((line = br.readLine()) != null) {
                    rus_professions.setProfessions_rus(line);
                    myAppDataBase.myinterface().addRusProfessions(rus_professions);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем рус транспорт
            try {
                Rus_Transport rus_transport = new Rus_Transport();
                BufferedReader br = new BufferedReader(new InputStreamReader(four));
                String line;

                while ((line = br.readLine()) != null) {
                    rus_transport.setTransport_rus(line);
                    myAppDataBase.myinterface().addRusTransport(rus_transport);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }

            /////////// русские подгрузки закончились
        }
        if (test.contains("en")) {
            // подгружаем английские словари
            // подгружаем eng изи
            try {
                Eng_Easy eng_easy = new Eng_Easy();
                BufferedReader br = new BufferedReader(new InputStreamReader(twelwe));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_easy.setEasy_eng(line);
                    myAppDataBase.myinterface().addEasyEng(eng_easy);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем eng медиум
            try {
                Eng_Medium eng_medium = new Eng_Medium();
                BufferedReader br = new BufferedReader(new InputStreamReader(thirteen));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_medium.setMedium_eng(line);
                    myAppDataBase.myinterface().addMediumEng(eng_medium);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем eng хард
            try {
                Eng_Hard eng_hard = new Eng_Hard();
                BufferedReader br = new BufferedReader(new InputStreamReader(fourteen));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_hard.setHard_eng(line);
                    myAppDataBase.myinterface().addHardEng(eng_hard);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем eng животные
            try {
                Eng_Animal eng_animal = new Eng_Animal();
                BufferedReader br = new BufferedReader(new InputStreamReader(eight));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_animal.setAnimal_eng(line);
                    myAppDataBase.myinterface().addEngAnimal(eng_animal);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем eng планета
            try {
                Eng_Planet eng_planet = new Eng_Planet();
                BufferedReader br = new BufferedReader(new InputStreamReader(nine));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_planet.setPlanet_eng(line);
                    myAppDataBase.myinterface().addEngPlanet(eng_planet);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем eng профессии
            try {
                Eng_Professions eng_professions = new Eng_Professions();
                BufferedReader br = new BufferedReader(new InputStreamReader(ten));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_professions.setProfessions_eng(line);
                    myAppDataBase.myinterface().addEngProfessions(eng_professions);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем eng транспорт
            try {
                Eng_Transport eng_transport = new Eng_Transport();
                BufferedReader br = new BufferedReader(new InputStreamReader(eleven));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_transport.setTransport_eng(line);
                    myAppDataBase.myinterface().addEngTransport(eng_transport);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
        }
        if (test.contains("de")) {
            // подгружаем немецкие словари
            // подгружаем de изи
            try {
                De_Easy de_easy = new De_Easy();
                BufferedReader br = new BufferedReader(new InputStreamReader(nineteen));
                String line;

                while ((line = br.readLine()) != null) {
                    de_easy.setDeutch_easy(line);
                    myAppDataBase.myinterface().addDeEasy(de_easy);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем de медиум
            try {
                De_Medium de_medium = new De_Medium();
                BufferedReader br = new BufferedReader(new InputStreamReader(twenty));
                String line;

                while ((line = br.readLine()) != null) {
                    de_medium.setDeutch_medium(line);
                    myAppDataBase.myinterface().addDeMedium(de_medium);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем de хард
            try {
                De_Hard de_hard = new De_Hard();
                BufferedReader br = new BufferedReader(new InputStreamReader(twentyone));
                String line;

                while ((line = br.readLine()) != null) {
                    de_hard.setDeutch_hard(line);
                    myAppDataBase.myinterface().addDeHard(de_hard);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем de животные
            try {
                De_Animal de_animal = new De_Animal();
                BufferedReader br = new BufferedReader(new InputStreamReader(fifteen));
                String line;

                while ((line = br.readLine()) != null) {
                    de_animal.setDeutch_animal(line);
                    myAppDataBase.myinterface().addDeAnimal(de_animal);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем de планета
            try {
                De_Planet de_planet = new De_Planet();
                BufferedReader br = new BufferedReader(new InputStreamReader(sixteen));
                String line;

                while ((line = br.readLine()) != null) {
                    de_planet.setDeutch_planet(line);
                    myAppDataBase.myinterface().addDePlanet(de_planet);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем de профессии
            try {
                De_Professions de_professions = new De_Professions();
                BufferedReader br = new BufferedReader(new InputStreamReader(seventeen));
                String line;

                while ((line = br.readLine()) != null) {
                    de_professions.setDeutch_professions(line);
                    myAppDataBase.myinterface().addDeProfessions(de_professions);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем de транспорт
            try {
                De_Transport de_transport = new De_Transport();
                BufferedReader br = new BufferedReader(new InputStreamReader(eightteen));
                String line;

                while ((line = br.readLine()) != null) {
                    de_transport.setDeutch_transport(line);
                    myAppDataBase.myinterface().addDeTransport(de_transport);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
        }
        if (test.contains("es")) {
            // подгружаем испанские словари
            // подгружаем es изи
            try {
                Es_Easy es_easy = new Es_Easy();
                BufferedReader br = new BufferedReader(new InputStreamReader(twentysix));
                String line;

                while ((line = br.readLine()) != null) {
                    es_easy.setSpain_easy(line);
                    myAppDataBase.myinterface().addEsEasy(es_easy);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем es медиум
            try {
                Es_Medium es_medium = new Es_Medium();
                BufferedReader br = new BufferedReader(new InputStreamReader(twentyseven));
                String line;

                while ((line = br.readLine()) != null) {
                    es_medium.setSpain_medium(line);
                    myAppDataBase.myinterface().addEsMedium(es_medium);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем es хард
            try {
                Es_Hard es_hard = new Es_Hard();
                BufferedReader br = new BufferedReader(new InputStreamReader(twentyeight));
                String line;

                while ((line = br.readLine()) != null) {
                    es_hard.setHard_spain(line);
                    myAppDataBase.myinterface().addEsHard(es_hard);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем es животные
            try {
                Es_Animal es_animal = new Es_Animal();
                BufferedReader br = new BufferedReader(new InputStreamReader(twentytwo));
                String line;

                while ((line = br.readLine()) != null) {
                    es_animal.setAnimal_spain(line);
                    myAppDataBase.myinterface().addEsAnimal(es_animal);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем es планета
            try {
                Es_Planet es_planet = new Es_Planet();
                BufferedReader br = new BufferedReader(new InputStreamReader(twentythree));
                String line;

                while ((line = br.readLine()) != null) {
                    es_planet.setPlanet_spain(line);
                    myAppDataBase.myinterface().addEsPlanet(es_planet);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем es профессия
            try {
                Es_Professions es_professions = new Es_Professions();
                BufferedReader br = new BufferedReader(new InputStreamReader(twentyfour));
                String line;

                while ((line = br.readLine()) != null) {
                    es_professions.setProfesions_spain(line);
                    myAppDataBase.myinterface().addEsProfessions(es_professions);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем es транспорт
            try {
                Es_Transport es_transport = new Es_Transport();
                BufferedReader br = new BufferedReader(new InputStreamReader(twentyfive));
                String line;

                while ((line = br.readLine()) != null) {
                    es_transport.setTransport_spain(line);
                    myAppDataBase.myinterface().addEsTransport(es_transport);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }

        }
        if (test.contains("ru") || test.contains("en") || test.contains("es") || test.contains("de")) {
            // если находим нашу локаль из этих то ничего не делаем
        } else {
            // если не находим то подгружаем английский словарь
            // в шаред в дефаулт локаль кидаем en
            edit.putString("DEFAULT_LOCALE", "en");
            edit.apply();
            edit.commit();
            try {
                Eng_Easy eng_easy = new Eng_Easy();
                BufferedReader br = new BufferedReader(new InputStreamReader(twelwe));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_easy.setEasy_eng(line);
                    myAppDataBase.myinterface().addEasyEng(eng_easy);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем eng медиум
            try {
                Eng_Medium eng_medium = new Eng_Medium();
                BufferedReader br = new BufferedReader(new InputStreamReader(thirteen));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_medium.setMedium_eng(line);
                    myAppDataBase.myinterface().addMediumEng(eng_medium);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем eng хард
            try {
                Eng_Hard eng_hard = new Eng_Hard();
                BufferedReader br = new BufferedReader(new InputStreamReader(fourteen));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_hard.setHard_eng(line);
                    myAppDataBase.myinterface().addHardEng(eng_hard);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем eng животные
            try {
                Eng_Animal eng_animal = new Eng_Animal();
                BufferedReader br = new BufferedReader(new InputStreamReader(eight));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_animal.setAnimal_eng(line);
                    myAppDataBase.myinterface().addEngAnimal(eng_animal);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем eng планета
            try {
                Eng_Planet eng_planet = new Eng_Planet();
                BufferedReader br = new BufferedReader(new InputStreamReader(nine));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_planet.setPlanet_eng(line);
                    myAppDataBase.myinterface().addEngPlanet(eng_planet);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем eng профессии
            try {
                Eng_Professions eng_professions = new Eng_Professions();
                BufferedReader br = new BufferedReader(new InputStreamReader(ten));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_professions.setProfessions_eng(line);
                    myAppDataBase.myinterface().addEngProfessions(eng_professions);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
            // подгружаем eng транспорт
            try {
                Eng_Transport eng_transport = new Eng_Transport();
                BufferedReader br = new BufferedReader(new InputStreamReader(eleven));
                String line;

                while ((line = br.readLine()) != null) {
                    eng_transport.setTransport_eng(line);
                    myAppDataBase.myinterface().addEngTransport(eng_transport);
                    Log.d("Log", line);
                }
                br.close();
            } catch (IOException ignored) {
            }
        }
    }
}


