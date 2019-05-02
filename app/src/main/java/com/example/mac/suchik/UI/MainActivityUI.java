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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mac.suchik.InternetDialogFragment;
import com.example.mac.suchik.R;
import com.example.mac.suchik.Storage;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.IOException;

import okhttp3.Response;
import response.kudago.UI.AsyncResponseKudago;
import response.kudago.UI.Event;
import response.kudago.UI.RequestAsyncTaskKudago;

public class MainActivityUI extends AppCompatActivity implements InternetDialogFragment.InternetDialogListener {
    public android.support.v7.app.ActionBar actionbar;

    public static final String TAG = "СМОТРИ ЧТО ЗДЕСЬ ЕСТЬ ";

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

//        //HERE IS A START INQUIRE KUDAGO
//
//        RequestAsyncTaskKudago newTask = new RequestAsyncTaskKudago(new AsyncResponseKudago() {
//            @Override
//            public void processFinish(Response result) {
//                String resultString = "";
//                try{
//                    resultString = result.body().string();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//                Gson gson = new Gson();
//                Event posts = gson.fromJson(resultString, Event.class);
//                posts = gson.fromJson(posts.getResults().get(0), Event.class);
//                Log.d(TAG ,      posts.getId() + "\n" + posts.getTitle() + "\n" + posts.getSlug() );
//            }
//        });
//        newTask.execute();
//
//        //HERE IS A END INQUIRE KUDAGO

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