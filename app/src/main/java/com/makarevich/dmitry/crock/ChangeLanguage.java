package com.makarevich.dmitry.crock;

import android.content.res.Configuration;
import android.widget.Toast;

import java.util.Locale;

public class ChangeLanguage {

    public void Germany() {
        SharedPref.LangDe();
        String languageToLoad = "de";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        Settings.getContexSetings().getResources().updateConfiguration(config,
                Settings.getContexSetings().getResources().getDisplayMetrics());
        Toast.makeText(Settings.getContexSetings(), "Sprache wurde auf Deutsch geändert", Toast.LENGTH_SHORT).show();
    }

    public void English() {
        SharedPref.LangEng();
        String languageToLoad = "en";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        Settings.getContexSetings().getResources().updateConfiguration(config,
                Settings.getContexSetings().getResources().getDisplayMetrics());
        Toast.makeText(Settings.getContexSetings(), "Language changed to English", Toast.LENGTH_SHORT).show();
    }

    public void Spain() {
        SharedPref.LangEsp();
        String languageToLoad = "es";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        Settings.getContexSetings().getResources().updateConfiguration(config,
                Settings.getContexSetings().getResources().getDisplayMetrics());
        Toast.makeText(Settings.getContexSetings(), "El idioma cambió a español", Toast.LENGTH_SHORT).show();
    }

    public void Russian() {
        SharedPref.LangRu();
        String languageToLoad = "ru";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        Settings.getContexSetings().getResources().updateConfiguration(config,
                Settings.getContexSetings().getResources().getDisplayMetrics());
        Toast.makeText(Settings.getContexSetings(), "Переведено на русский", Toast.LENGTH_SHORT).show();
    }


    public void MainLang() {
        String test = SharedPref.getsLanguage();
        if (test.contains("ru")) {
            String languageToLoad = "ru";
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            SpalshScreen.getContexSplashScreen().getResources().updateConfiguration(config,
                    SpalshScreen.getContexSplashScreen().getResources().getDisplayMetrics());
        }
        if (test.contains("de")) {
            String languageToLoad = "de";
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            SpalshScreen.getContexSplashScreen().getResources().updateConfiguration(config,
                    SpalshScreen.getContexSplashScreen().getResources().getDisplayMetrics());
        }
        if (test.contains("en")) {
            String languageToLoad = "en";
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            SpalshScreen.getContexSplashScreen().getResources().updateConfiguration(config,
                    SpalshScreen.getContexSplashScreen().getResources().getDisplayMetrics());
        }
        if (test.contains("en")) {
            String languageToLoad = "en";
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            SpalshScreen.getContexSplashScreen().getResources().updateConfiguration(config,
                    SpalshScreen.getContexSplashScreen().getResources().getDisplayMetrics());
        }
    }
}
