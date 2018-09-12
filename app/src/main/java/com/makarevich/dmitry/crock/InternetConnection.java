package com.makarevich.dmitry.crock;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetConnection {
    public static String isOnline() {
        String bad = "bad";
        Context applicationContext = SpalshScreen.getContexSplashScreen();
        ConnectivityManager cm =
                (ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return "good";

        }
        return bad;
    }
}
