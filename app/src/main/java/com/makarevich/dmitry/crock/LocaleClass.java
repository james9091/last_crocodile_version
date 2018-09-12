package com.makarevich.dmitry.crock;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LocaleClass extends AppCompatActivity {

    public void Check_Locale() {

        Context applicationContext = Registration.getContextOfApplication();
        PackageManager packageManager = applicationContext.getPackageManager();
        Resources resources = null;

        DataBase dataBase = new DataBase(Registration.getContextOfApplication());
        final SQLiteDatabase sqLiteDatabase = dataBase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        sqLiteDatabase.delete("Words", null, null);
        try {
            resources = packageManager.getResourcesForApplication("android");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


        // загружаем все русские словари
        InputStream is = getResources().openRawResource(R.raw.animal_ru);
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = br.readLine()) != null) {
                contentValues.put("rus_animal", line);
            }
            br.close();
        } catch (IOException e) {
        }
    }


    // считывание с txt
    public void Test() {
        InputStream is = getResources().openRawResource(R.raw.animal_ru);
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                // text.append('\n');
            }
            br.close();
        } catch (IOException e) {
        }
    }
}
