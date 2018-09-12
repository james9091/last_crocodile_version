package com.makarevich.dmitry.crock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class EarnCoins extends AppCompatActivity implements RewardedVideoAdListener {
    private ImageView ic_video_logo, ic_play, ic_coins;
    private TextView txt_start, txt_view, txt_available, txt_earn_coins, txt_see, txt_video, txt_coins;
    @SuppressLint("StaticFieldLeak")
    public static Context context_earn_coins;
    private static final String AD_UNIT_ID = "ca-app-pub-1771512599501543/8702164834";
    private static final String APP_ID = "ca-app-pub-1771512599501543~5943428142";
    private RewardedVideoAd rewardedVideoAd;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn__coins);
        context_earn_coins = getApplicationContext();
        txt_coins = findViewById(R.id.txt_coins);
        txt_start = findViewById(R.id.txt_start);
        txt_view = findViewById(R.id.txt_view);
        txt_available = findViewById(R.id.txt_available);
        txt_earn_coins = findViewById(R.id.txt_earn_coins);
        txt_see = findViewById(R.id.txt_see);
        txt_video = findViewById(R.id.txt_video);
        ic_video_logo = findViewById(R.id.ic_video_logo);
        ic_play = findViewById(R.id.ic_play);
        ic_coins = findViewById(R.id.ic_coins);
        PushPic();
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);
        MobileAds.initialize(this, APP_ID);
        ic_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startVideoAd();
            }
        });
        loadRewardedVideoAd();
        Font();
        String test = SharedPref.getCoin();
        txt_coins.setText(test + " " + getString(R.string.coinss));
    }

    public void startVideoAd() {
        if (rewardedVideoAd.isLoaded()) {
            rewardedVideoAd.show();
            Toast.makeText(this, getString(R.string.starting_watching), Toast.LENGTH_SHORT).show();
        }
    }

    private void loadRewardedVideoAd() {
        if (!rewardedVideoAd.isLoaded()) {
            rewardedVideoAd.loadAd(AD_UNIT_ID, new AdRequest.Builder().build());
        }
    }

    public static Context getContexEarnCoins() {
        return context_earn_coins;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(EarnCoins.this, MainMenu.class);
        startActivity(back);
    }

    private void PushPic() {

        int first = R.drawable.watch;
        int second = R.drawable.play_p;
        int third = R.drawable.coins;

        Glide
                .with(this)
                .load(first)
                .into(ic_video_logo);
        Glide
                .with(this)
                .load(second)
                .into(ic_play);
        Glide
                .with(this)
                .load(third)
                .into(ic_coins);

    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }


    @Override
    public void onRewardedVideoAdClosed() {

        Toast.makeText(context_earn_coins, getString(R.string.ok), Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onRewarded(RewardItem rewardItem) {
        SharedPref.Coins();
        String test = SharedPref.getCoin();
        Toast.makeText(context_earn_coins, getString(R.string.you_earned_coins), Toast.LENGTH_SHORT).show();
        txt_coins.setText(test + " " + getString(R.string.coinss));
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    public void Font() {
        txt_start.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_view.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_available.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_coins.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_earn_coins.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_video.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));
        txt_see.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/headers_three.ttf"));

    }
}
