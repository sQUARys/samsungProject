package com.example.mac.suchik.UI.main_window;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mac.suchik.R;
import com.example.mac.suchik.UI.settings_page.VH;
import com.example.mac.suchik.WeatherData.Forecasts;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Response;
import response.kudago.UI.AsyncResponseKudago;
import response.kudago.UI.Event;
import response.kudago.UI.RequestAsyncTaskKudago;

public class Adapter_of_events extends RecyclerView.Adapter<VH_ForEvents> {
    private String[] ArrayData;
    public Adapter_of_events(String[] data) {
        super();
        ArrayData = data;
    }
    @Override
    public VH_ForEvents onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_events, parent, false);
        return new VH_ForEvents(view);
    }

    public void onBindViewHolder(final VH_ForEvents holder, int position) {
        RequestAsyncTaskKudago newTask = new RequestAsyncTaskKudago(new AsyncResponseKudago() {
            @Override
            public void processFinish(Response result) {
                String resultString = "";
                try{
                    resultString = result.body().string();
                }catch (IOException e){
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                Event posts = gson.fromJson(resultString, Event.class);
                posts = gson.fromJson(posts.getResults().get(0), Event.class);
                holder.tv_events.setText(posts.getTitle());
            }
        });
        newTask.execute();

    }

    @Override
    public int getItemCount() {
        return 10;
    }
    public void setList(List<String> new_elements){
    }

}
