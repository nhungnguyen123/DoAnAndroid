package com.uiapp.doan.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.uiapp.doan.MainApplication;

/**
 * Created by hongnhung on 10/23/16.
 */

public class CommonUtils {public static void showSnackBar(View view, String content, int time) {
    Snackbar.make(view, content, time).show();
}
    public static void showToast(Context context , String text){
        Toast.makeText(context,text, Toast.LENGTH_LONG).show();
    }


    public static boolean isNetworkConnect(){
        ConnectivityManager connectivityManager =
                (ConnectivityManager) MainApplication.getContext()
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return  networkInfo!= null;
    }
}
