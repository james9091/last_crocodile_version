package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class LastStorePage extends AppCompatActivity {

    private ImageView ic_logo, ic_wallet, ic_coins, ic_shop_cart, ic_sale, ic_easy, ic_hard, ic_medium;
    private TextView txt_crocodile, txt_buy_new_words, txt_easy, txt_hard, txt_medium, txt_crocko_shop, txt_buy_easy, txt_buy_medium, txt_buy_hard;
    private TextView txt_easy_you, txt_hard_you, txt_medium_you, txt_coins;
    @SuppressLint("StaticFieldLeak")
    public static Context context_last_store_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_store_page);
        context_last_store_page = getApplicationContext();
        txt_easy_you = findViewById(R.id.txt_easy_you);
        txt_hard_you = findViewById(R.id.txt_hard_you);
        txt_medium_you = findViewById(R.id.txt_medium_you);
        txt_crocodile = findViewById(R.id.txt_crocodile);
        txt_buy_new_words = findViewById(R.id.txt_buy_new_words);
        txt_coins = findViewById(R.id.txt_coins);
        txt_easy = findViewById(R.id.txt_easy);
        txt_hard = findViewById(R.id.txt_hard);
        txt_medium = findViewById(R.id.txt_medium);
        txt_buy_easy = findViewById(R.id.txt_buy_easy);
        txt_buy_medium = findViewById(R.id.txt_buy_medium);
        txt_buy_hard = findViewById(R.id.txt_buy_hard);
        txt_crocko_shop = findViewById(R.id.txt_crocko_shop);
        ic_logo = findViewById(R.id.ic_logo);
        ic_wallet = findViewById(R.id.ic_wallet);
        ic_shop_cart = findViewById(R.id.ic_shop_cart);
        ic_sale = findViewById(R.id.ic_sale);
        ic_coins = findViewById(R.id.ic_coins);
        ic_easy = findViewById(R.id.ic_easy);
        ic_hard = findViewById(R.id.ic_hard);
        ic_medium = findViewById(R.id.ic_medium);
        RelativeLayout one = findViewById(R.id.rel_one);
        RelativeLayout two = findViewById(R.id.rel_two);
        RelativeLayout three = findViewById(R.id.rel_three);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        txt_crocko_shop.startAnimation(anim);
        Font();
        PushImage();
        getC();
        GetDicCount();
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LastStorePage.this);
                builder.setTitle(getString(R.string.play_store_c))
                        .setMessage(getString(R.string.message1))
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.yes),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        BuyStartEasy();
                                    }
                                })
                        .setNegativeButton(getString(R.string.back),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LastStorePage.this);
                builder.setTitle(getString(R.string.play_store_c))
                        .setMessage(getString(R.string.message2))
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.yes),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        BuyStartMedium();
                                    }
                                })
                        .setNegativeButton(getString(R.string.back),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LastStorePage.this);
                builder.setTitle(getString(R.string.play_store_c))
                        .setMessage(getString(R.string.message3))
                        .setIcon(R.drawable.crocko_green)
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.yes),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        BuyStartHard();
                                    }
                                })
                        .setNegativeButton(getString(R.string.back),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }

    public static Context getContextLastStorePage() {
        return context_last_store_page;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(LastStorePage.this, MainMenu.class);
        startActivity(back);
    }

    public void Font() {
        txt_crocodile.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_easy.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_hard.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_buy_new_words.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_medium.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_crocko_shop.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_buy_easy.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_buy_medium.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_buy_hard.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

    public void PushImage() {

        int first = R.drawable.crocko_green;
        int third = R.drawable.wallet;
        int four = R.drawable.cart;
        int five = R.drawable.sale;
        int seven = R.drawable.easy;
        int eight = R.drawable.medium;
        int nine = R.drawable.hard;
        int ten = R.drawable.coins;
        Glide
                .with(this)
                .load(first)
                .into(ic_logo);
        Glide
                .with(this)
                .load(third)
                .into(ic_wallet);
        Glide
                .with(this)
                .load(four)
                .into(ic_shop_cart);
        Glide
                .with(this)
                .load(five)
                .into(ic_sale);
        Glide
                .with(this)
                .load(seven)
                .into(ic_easy);
        Glide
                .with(this)
                .load(eight)
                .into(ic_hard);
        Glide
                .with(this)
                .load(nine)
                .into(ic_medium);
        Glide
                .with(this)
                .load(ten)
                .into(ic_coins);
    }

    @SuppressLint("SetTextI18n")
    private void GetDicCount() {

        Context apl = LastStorePage.getContextLastStorePage();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(apl);
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");

        if (def_locale.contains("ru")) {
            String easy_ru = sharedPreferences.getString("RU_EASY_CURSOR", "");
            String medium_ru = sharedPreferences.getString("RU_MEDIUM_CURSOR", "");
            String hard_ru = sharedPreferences.getString("RU_HARD_CURSOR", "");
            txt_easy_you.setText(getString(R.string.good) + "\n" + easy_ru + "\n" + getString(R.string.word));
            txt_hard_you.setText(getString(R.string.good) + "\n" + medium_ru + "\n" + getString(R.string.word));
            txt_medium_you.setText(getString(R.string.good) + "\n" + hard_ru + "\n" + getString(R.string.word));

        }
        if (def_locale.contains("en")) {
            String easy_en = sharedPreferences.getString("EN_EASY_CURSOR", "");
            String medium_en = sharedPreferences.getString("EN_MEDIUM_CURSOR", "");
            String hard_en = sharedPreferences.getString("EN_HARD_CURSOR", "");
            txt_easy_you.setText(getString(R.string.good) + "\n" + easy_en + "\n" + getString(R.string.word));
            txt_hard_you.setText(getString(R.string.good) + "\n" + medium_en + "\n" + getString(R.string.word));
            txt_medium_you.setText(getString(R.string.good) + "\n" + hard_en + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("de")) {
            String easy_de = sharedPreferences.getString("DE_EASY_CURSOR", "");
            String medium_de = sharedPreferences.getString("DE_MEDIUM_CURSOR", "");
            String hard_de = sharedPreferences.getString("DE_HARD_CURSOR", "");
            txt_easy_you.setText(getString(R.string.good) + "\n" + easy_de + "\n" + getString(R.string.word));
            txt_hard_you.setText(getString(R.string.good) + "\n" + medium_de + "\n" + getString(R.string.word));
            txt_medium_you.setText(getString(R.string.good) + "\n" + hard_de + "\n" + getString(R.string.word));
        }
        if (def_locale.contains("es")) {
            String easy_es = sharedPreferences.getString("ES_EASY_CURSOR", "");
            String medium_es = sharedPreferences.getString("ES_MEDIUM_CURSOR", "");
            String hard_es = sharedPreferences.getString("ES_HARD_CURSOR", "");
            txt_easy_you.setText(getString(R.string.good) + "\n" + easy_es + "\n" + getString(R.string.word));
            txt_hard_you.setText(getString(R.string.good) + "\n" + medium_es + "\n" + getString(R.string.word));
            txt_medium_you.setText(getString(R.string.good) + "\n" + hard_es + "\n" + getString(R.string.word));
        }
    }

    @SuppressLint("SetTextI18n")
    public void getC() {
        Context applicationContext = LastStorePage.getContextLastStorePage();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        String coins = sharedPreferences.getString("COIN", "");
        txt_coins.setText(coins + " " + getString(R.string.coinss));
    }

    public void BuyStartEasy() {
        Context applicationContext = LastStorePage.getContextLastStorePage();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String coins = sharedPreferences.getString("COIN", "");
        int easy_rus = Integer.parseInt(sharedPreferences.getString("RU_EASY_CURSOR", ""));
        int easy_eng = Integer.parseInt(sharedPreferences.getString("EN_EASY_CURSOR", ""));
        int easy_de = Integer.parseInt(sharedPreferences.getString("DE_EASY_CURSOR", ""));
        int easy_es = Integer.parseInt(sharedPreferences.getString("ES_EASY_CURSOR", ""));
        int coin = Integer.parseInt(coins);
        if (coin > 110) {
            if (def_locale.contains("ru") && easy_rus < 980) {
                int animal = Integer.parseInt(sharedPreferences.getString("RU_EASY_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("RU_EASY_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("en") && easy_eng < 980) {
                int animal = Integer.parseInt(sharedPreferences.getString("EN_EASY_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("EN_EASY_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("de") && easy_de < 980) {
                int animal = Integer.parseInt(sharedPreferences.getString("DE_EASY_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("DE_EASY_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("es") && easy_es < 980) {
                int animal = Integer.parseInt(sharedPreferences.getString("ES_EASY_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("ES_EASY_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
        } else {
            Toast.makeText(applicationContext, getString(R.string.no_coin_store), Toast.LENGTH_SHORT).show();
        }
    }

    public void BuyStartMedium() {
        Context applicationContext = LastStorePage.getContextLastStorePage();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String coins = sharedPreferences.getString("COIN", "");
        int medium_rus = Integer.parseInt(sharedPreferences.getString("RU_MEDIUM_CURSOR", ""));
        int medium_eng = Integer.parseInt(sharedPreferences.getString("EN_MEDIUM_CURSOR", ""));
        int medium_de = Integer.parseInt(sharedPreferences.getString("DE_MEDIUM_CURSOR", ""));
        int medium_es = Integer.parseInt(sharedPreferences.getString("ES_MEDIUM_CURSOR", ""));
        int coin = Integer.parseInt(coins);
        if (coin > 110) {
            if (def_locale.contains("ru") && medium_rus < 2310) {
                int animal = Integer.parseInt(sharedPreferences.getString("RU_MEDIUM_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("RU_MEDIUM_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("en") && medium_eng < 2310) {
                int animal = Integer.parseInt(sharedPreferences.getString("EN_MEDIUM_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("EN_MEDIUM_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("de") && medium_de < 2310) {
                int animal = Integer.parseInt(sharedPreferences.getString("DE_MEDIUM_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("DE_MEDIUM_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("es") && medium_es < 2310) {
                int animal = Integer.parseInt(sharedPreferences.getString("ES_MEDIUM_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("ES_MEDIUM_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
        } else {
            Toast.makeText(applicationContext, getString(R.string.no_coin_store), Toast.LENGTH_SHORT).show();
        }
    }

    public void BuyStartHard() {
        Context applicationContext = LastStorePage.getContextLastStorePage();
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        String def_locale = sharedPreferences.getString("DEFAULT_LOCALE", "");
        String coins = sharedPreferences.getString("COIN", "");
        int hard_rus = Integer.parseInt(sharedPreferences.getString("RU_HARD_CURSOR", ""));
        int hard_eng = Integer.parseInt(sharedPreferences.getString("EN_HARD_CURSOR", ""));
        int hard_de = Integer.parseInt(sharedPreferences.getString("DE_HARD_CURSOR", ""));
        int hard_es = Integer.parseInt(sharedPreferences.getString("ES_HARD_CURSOR", ""));
        int coin = Integer.parseInt(coins);
        if (coin > 110) {
            if (def_locale.contains("ru") && hard_rus < 2020) {
                int animal = Integer.parseInt(sharedPreferences.getString("RU_HARD_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("RU_HARD_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("en") && hard_eng < 2020) {
                int animal = Integer.parseInt(sharedPreferences.getString("EN_HARD_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("EN_HARD_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("de") && hard_de < 2020) {
                int animal = Integer.parseInt(sharedPreferences.getString("DE_HARD_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("DE_HARD_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
            if (def_locale.contains("es") && hard_es < 2020) {
                int animal = Integer.parseInt(sharedPreferences.getString("ES_HARD_CURSOR", "")) + 10;
                String animal_s = String.valueOf(animal);
                edit.putString("ES_HARD_CURSOR", animal_s);
                edit.apply();
                edit.commit();
                int coinss = Integer.parseInt(sharedPreferences.getString("COIN", "")) - 110;
                String coinss_s = String.valueOf(coinss);
                edit.putString("COIN", coinss_s);
                edit.apply();
                edit.commit();
                Toast.makeText(applicationContext, getString(R.string.succes_complete), Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(LastStorePage.this, LastStorePage.class);
                startActivity(refresh);
            }
        } else {
            Toast.makeText(applicationContext, getString(R.string.no_coin_store), Toast.LENGTH_SHORT).show();
        }
    }
}