package com.example.mac.suchik.UI.main_window;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mac.suchik.R;
import com.example.mac.suchik.UI.EventListFragment;
import com.example.mac.suchik.UI.MainActivityUI;
import com.example.mac.suchik.UI.settings_page.VH;
import com.example.mac.suchik.WeatherData.Forecasts;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import java.io.IOException;
import java.security.acl.LastOwnerException;
import java.util.List;

import AllForFragment.Dialog;
import okhttp3.Response;
import response.kudago.UI.AsyncResponseKudago;
import response.kudago.UI.Event;
import response.kudago.UI.RequestAsyncTaskKudago;

public class Adapter_of_events extends RecyclerView.Adapter<VH_ForEvents> {
    private String[] categoriesEventIfYES;
    private String[] categoriesEventIfNO;
    private int[] ArrayIfWeFind;
    private String[] dataToViewAdapter;
    private String[] dataTitleToViewAdapter;
    EventListFragment eventListFragment = new EventListFragment();


    public Adapter_of_events(String[] data, String[] dataNo , String[] dataToView , String[] dataTitleToView) {
        super();
        categoriesEventIfYES = data;
        categoriesEventIfNO = dataNo;
        dataToViewAdapter = dataToView;
        dataTitleToViewAdapter =dataTitleToView;
    }

    @Override
    public VH_ForEvents onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_events, parent, false);
        return new VH_ForEvents(view);
    }

    public void onBindViewHolder(final VH_ForEvents holder, final int position) {
        Picasso.get().load(dataToViewAdapter[position]).into(holder.im_events);
        holder.tv_events.setText(dataTitleToViewAdapter[position]);
    }

            @Override
            public int getItemCount () {
                return dataToViewAdapter.length;
            }
            public void setList (List < String > new_elements) {
            }

}