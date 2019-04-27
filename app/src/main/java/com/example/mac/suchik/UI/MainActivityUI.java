package com.example.mac.suchik.UI;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mac.suchik.InternetDialogFragment;
import com.example.mac.suchik.R;
import com.example.mac.suchik.Storage;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivityUI extends AppCompatActivity implements InternetDialogFragment.InternetDialogListener {
    public android.support.v7.app.ActionBar actionbar;

    public static final int MAIN_WINDOW_FRAGMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#84B3D5")));//change color of action bar
        Storage.getOrCreate(getApplicationContext());
        actionbar.setTitle("WAW");
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
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            selectedFragment).commit();

                    return true;
                }
            };

    public static boolean hasConnection(final Context context)
    {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected())
        {
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