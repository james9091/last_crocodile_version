package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends AppCompatActivity {
    private ImageView ic_logo_one, ic_logo_two, ic_logo_three, ic_play, ic_book, ic_settings,ic_coins;
    private ImageView ic_exit, ic_share;
    private FirebaseAuth firebaseAuth;
    private TextView txt_crocodile;
    private TextView txt_start_game;
    private TextView txt_play_store;
    private TextView txt_settings;
    private TextView txt_noisy;
    private TextView txt_party;
    @SuppressLint("StaticFieldLeak")
    public static Context context_main_menu;
    DataBase dataBase;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        dataBase = new DataBase(this);
        context_main_menu = getApplicationContext();
        txt_crocodile = findViewById(R.id.txt_crocodile);
        txt_start_game = findViewById(R.id.txt_start_game);
        txt_play_store = findViewById(R.id.txt_play_store);
        txt_settings = findViewById(R.id.txt_settings);
        TextView txt_coins = findViewById(R.id.txt_coins);
        txt_noisy = findViewById(R.id.txt_noisy);
        txt_party = findViewById(R.id.txt_party);
        firebaseAuth = FirebaseAuth.getInstance();
        ic_logo_one = findViewById(R.id.ic_logo_one);
        ic_logo_two = findViewById(R.id.ic_logo_two);
        ic_logo_three = findViewById(R.id.ic_logo_three);
        ic_play = findViewById(R.id.ic_play);
        ic_coins=findViewById(R.id.ic_coins);
        ic_book = findViewById(R.id.ic_book);
        ic_settings = findViewById(R.id.ic_settings);
        ic_exit = findViewById(R.id.ic_exit);
        ic_share = findViewById(R.id.ic_share);
        RelativeLayout one = findViewById(R.id.rel_one);
        RelativeLayout two = findViewById(R.id.rel_two);
        RelativeLayout fit = findViewById(R.id.rel_three);
        PushPic();
        Font();
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //android.os.Process.killProcess(android.os.Process.myPid());
                //finishAffinity();
                Intent play_mode = new Intent(MainMenu.this, Play_Mode.class);
                startActivity(play_mode);

            }
        });
        fit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(MainMenu.this, Settings.class);
                startActivity(next);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent store = new Intent(MainMenu.this, MainStore.class);
                startActivity(store);
            }
        });
        ic_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExitAcc();
            }
        });
        ic_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareIt();
            }
        });
        SharedPref.MainMenuSetNone();
        String test = SharedPref.GetMainMenuCoins();
        txt_coins.setText(test + " " + getString(R.string.coinss));
    }

    public static Context getContextMainMenu() {
        return context_main_menu;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, getString(R.string.pereh_naz), Toast.LENGTH_SHORT).show();
    }

    private void PushPic() {

        int first = R.drawable.crocko_green;
        int second = R.drawable.joystick;
        int four = R.drawable.dollar;
        int five = R.drawable.settings;
        int six = R.drawable.exit;
        int seven = R.drawable.share;
        int eight = R.drawable.coins_three;

        Glide
                .with(this)
                .load(first)
                .into(ic_logo_one);
        Glide
                .with(this)
                .load(first)
                .into(ic_logo_two);
        Glide
                .with(this)
                .load(first)
                .into(ic_logo_three);
        Glide
                .with(this)
                .load(second)
                .into(ic_play);
        Glide
                .with(this)
                .load(four)
                .into(ic_book);
        Glide
                .with(this)
                .load(five)
                .into(ic_settings);
        Glide
                .with(this)
                .load(six)
                .into(ic_exit);
        Glide
                .with(this)
                .load(seven)
                .into(ic_share);
        Glide
                .with(this)
                .load(eight)
                .into(ic_coins);
    }

    public void Font() {
        txt_crocodile.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_start_game.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_play_store.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_settings.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_noisy.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_party.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
    }

    private void ExitAcc() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                MainMenu.this);
        Resources res = getResources();
        String one = res.getString(R.string.exit);
        String two = res.getString(R.string.yes);
        String three = res.getString(R.string.noo);

        quitDialog.setTitle(one);

        quitDialog.setPositiveButton(two, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        firebaseAuth.signOut();
                        finish();
                        Intent exit = new Intent(MainMenu.this, LogIn.class);
                        startActivity(exit);

                    }
                }
        );

        quitDialog.setNegativeButton(three, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), R.string.continu, Toast.LENGTH_SHORT).show();

            }
        });

        quitDialog.show();
    }

    private void ShareIt() {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String textToSend = getString(R.string.sha_ref);
        intent.putExtra(Intent.EXTRA_TEXT, textToSend);
        try {
            startActivity(Intent.createChooser(intent, getString(R.string.crocodile)));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }
}
