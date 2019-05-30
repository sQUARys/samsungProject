package com.example.mac.suchik.UI;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.mac.suchik.InternetDialogFragment;
import com.example.mac.suchik.R;
import com.example.mac.suchik.Storage;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.IOException;

import AllForFragment.Dialog;
import okhttp3.Response;
import response.kudago.UI.AsyncResponseKudago;
import response.kudago.UI.Event;
import response.kudago.UI.RequestAsyncTaskKudago;



public class MainActivityUI extends AppCompatActivity implements InternetDialogFragment.InternetDialogListener {
    public android.support.v7.app.ActionBar actionbar;
    public static final  Dialog ButtonChoice = new Dialog();
    public static final String TAG = "СМОТРИ ЧТО ЗДЕСЬ ЕСТЬ ";
    public boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#84B3D5")));//change color of action bar
        Storage.getOrCreate(getApplicationContext());
        actionbar.setTitle("WAW");
        getSupportActionBar().hide();
        ButtonChoice.setAlert("Init");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .build();
        Fragment selected = new MainWindowFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                selected).commit();
        ImageLoader.getInstance().init(config);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = new MainWindowFragment();
                    switch (item.getItemId()) {
                        case R.id.main_window_btn:
                            selectedFragment = new MainWindowFragment();
                            break;
                        case R.id.event_fragment_btn:
                            selectedFragment = new EventListFragment();
                            if(flag){
                                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivityUI.this);
                                alert.setTitle("HI");

                                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ButtonChoice.setAlert("Yes");
                                        ButtonChoice.setFlag();
                                    }
                                });
                                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ButtonChoice.setAlert("No");
                                        ButtonChoice.setFlag();
                                    }
                                });
                                alert.create().show();
                                flag = false;
                            }
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            selectedFragment).commit();

                    return true;
                }
            };

    public static boolean hasConnection(final Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public void onDialogPositiveClick(DialogFragment dialog) {
        if (!hasConnection(this)) {
            (new InternetDialogFragment()).show(getSupportFragmentManager(), "WAW");
        }
    }

    public void onDialogNegativeClick(DialogFragment dialog) {
        System.exit(0);
    }
}