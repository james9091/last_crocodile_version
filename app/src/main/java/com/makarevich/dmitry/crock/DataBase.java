package com.makarevich.dmitry.crock;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context) {
        super(context, "db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Words (id integer primary key autoincrement , rus_easy text , rus_medium text , rus_hard text , eng_easy text , eng_medium text , eng_hard text , esp_easy text , esp_medium text , esp_hard text , fra_easy text , fra_medium text, fra_hard text , de_easy text , de_medium text , de_hard text  , rus_animal text , rus_planet text , rus_kids text , rus_proffession text ,rus_transport text, esp_animal text , esp_planet text , esp_kids text , esp_proffession text ,esp_transport text, de_animal text , de_planet text , de_kids text , de_proffession text ,de_transport text, fra_animal text , fra_planet text , fra_kids text , fra_proffession text ,fra_transport text, eng_animal text , eng_planet text , eng_kids text , eng_proffession text ,eng_transport text )");
        sqLiteDatabase.execSQL("create table User (id integer primary key autoincrement , rus_easy text , rus_medium text , rus_hard text , eng_easy text , eng_medium text , eng_hard text , esp_easy text , esp_medium text , esp_hard text , fra_easy text , fra_medium text, fra_hard text , de_easy text , de_medium text , de_hard text  , rus_animal text , rus_planet text , rus_kids text , rus_proffession text ,rus_transport text, esp_animal text , esp_planet text , esp_kids text , esp_proffession text ,esp_transport text, de_animal text , de_planet text , de_kids text , de_proffession text ,de_transport text, fra_animal text , fra_planet text , fra_kids text , fra_proffession text ,fra_transport text, eng_animal text , eng_planet text , eng_kids text , eng_proffession text ,eng_transport text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
