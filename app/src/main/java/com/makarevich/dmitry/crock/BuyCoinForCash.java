package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BuyCoinForCash extends AppCompatActivity {

    private ImageView ic_main_logo, ic_coin_wallet, ic_coin_bag, ic_gold_mine, ic_pile;
    private TextView txt_crocodile, txt_coins, txt_buy_coins, txt_coin_bag, txt_buy_pile_c, txt_buy_gold_mine, txt_crocko_shop, txt_buy_coin_bag, txt_gold_mine, txt_buy_pile;
    @SuppressLint("StaticFieldLeak")
    public static Context contex_cash_coins;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_coin_for_cash);
        contex_cash_coins = getApplicationContext();
        txt_crocodile = findViewById(R.id.txt_crocodile);
        txt_buy_coins = findViewById(R.id.txt_buy_coins);
        txt_coin_bag = findViewById(R.id.txt_coin_bag);
        txt_buy_pile_c = findViewById(R.id.txt_buy_pile_c);
        txt_buy_gold_mine = findViewById(R.id.txt_buy_gold_mine);
        txt_buy_coin_bag = findViewById(R.id.txt_buy_coin_bag);
        txt_gold_mine = findViewById(R.id.txt_gold_mine);
        txt_buy_pile = findViewById(R.id.txt_buy_pile);
        txt_coins = findViewById(R.id.txt_coins);
        txt_crocko_shop = findViewById(R.id.txt_crocko_shop);
        ic_main_logo = findViewById(R.id.ic_main_logo);
        ic_coin_wallet = findViewById(R.id.ic_coin_wallet);
        ic_coin_bag = findViewById(R.id.ic_coin_bag);
        ic_gold_mine = findViewById(R.id.ic_gold_mine);
        ic_pile = findViewById(R.id.ic_pile);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        txt_crocko_shop.startAnimation(anim);
        Font();
        PushImage();
        String test = SharedPref.getCoinShop();
        txt_coins.setText(test + " " + getString(R.string.coinss));
    }

    public static Context getContexCoinsCash() {
        return contex_cash_coins;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(BuyCoinForCash.this, MainMenu.class);
        startActivity(back);
    }

    public void Font() {
        txt_crocodile.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_coin_bag.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_buy_pile_c.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_buy_coins.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_buy_gold_mine.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_crocko_shop.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_buy_coin_bag.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_gold_mine.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_buy_pile.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_coins.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

    public void PushImage() {

        int first = R.drawable.crocko_green;
        int third = R.drawable.wallet;
        int seven = R.drawable.chest_one;
        int eight = R.drawable.chest_two;
        int nine = R.drawable.chest_three;

        Glide
                .with(this)
                .load(first)
                .into(ic_main_logo);
        Glide
                .with(this)
                .load(third)
                .into(ic_coin_wallet);
        Glide
                .with(this)
                .load(seven)
                .into(ic_coin_bag);
        Glide
                .with(this)
                .load(eight)
                .into(ic_pile);
        Glide
                .with(this)
                .load(nine)
                .into(ic_gold_mine);
    }
}
