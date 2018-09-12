package com.makarevich.dmitry.crock;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainStore extends AppCompatActivity {
    private ImageView ic_croc_one, ic_croc_two, ic_croc_three, ic_play, ic_book, ic_settings, ic_buy;
    private TextView txt_crocodile, txt_noisy, txt_party, txt_buy_coins, txt_buy_game, txt_buy_dictionary, txt_earn_coins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_store);
        txt_crocodile = findViewById(R.id.txt_crocodile);
        txt_noisy = findViewById(R.id.txt_noisy);
        txt_party = findViewById(R.id.txt_party);
        txt_buy_coins = findViewById(R.id.txt_buy_coins);
        txt_buy_game = findViewById(R.id.txt_buy_game);
        txt_buy_dictionary = findViewById(R.id.txt_buy_dictionary);
        txt_earn_coins = findViewById(R.id.txt_earn_coins);
        ic_croc_one = findViewById(R.id.ic_croc_one);
        ic_croc_two = findViewById(R.id.ic_croc_two);
        ic_croc_three = findViewById(R.id.ic_croc_three);
        ic_play = findViewById(R.id.ic_play);
        ic_book = findViewById(R.id.ic_book);
        ic_settings = findViewById(R.id.ic_settings);
        ic_buy = findViewById(R.id.ic_buy);
        RelativeLayout one = findViewById(R.id.rel_one);
        RelativeLayout two = findViewById(R.id.rel_two);
        RelativeLayout fit = findViewById(R.id.rel_three);
        RelativeLayout fitsn = findViewById(R.id.rel_four);
        PushPic();
        Font();
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent one = new Intent(MainStore.this, Store.class);
                startActivity(one);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent two = new Intent(MainStore.this, EarnCoins.class);
                startActivity(two);
            }
        });
        fit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fit = new Intent(MainStore.this, BuyCoinForCash.class);
                startActivity(fit);
            }
        });
        fitsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainStore.this, getString(R.string.are_you_buy_game), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(MainStore.this, MainMenu.class);
        startActivity(back);
    }

    private void PushPic() {

        int first = R.drawable.crocko_green;
        int second = R.drawable.alphabet;
        int third = R.drawable.watch;
        int four = R.drawable.coin_wallet;
        int five = R.drawable.buy;

        Glide
                .with(this)
                .load(first)
                .into(ic_croc_one);
        Glide
                .with(this)
                .load(first)
                .into(ic_croc_two);
        Glide
                .with(this)
                .load(first)
                .into(ic_croc_three);
        Glide
                .with(this)
                .load(second)
                .into(ic_play);
        Glide
                .with(this)
                .load(third)
                .into(ic_book);
        Glide
                .with(this)
                .load(four)
                .into(ic_settings);
        Glide
                .with(this)
                .load(five)
                .into(ic_buy);

    }

    public void Font() {
        txt_crocodile.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_noisy.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_party.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_buy_coins.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_buy_game.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_buy_dictionary.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_earn_coins.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

}
