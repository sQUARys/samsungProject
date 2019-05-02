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
import com.google.gson.JsonArray;

import org.json.JSONArray;

import java.io.IOException;
import java.util.List;

import okhttp3.Response;
import response.kudago.UI.AsyncResponseKudago;
import response.kudago.UI.Event;
import response.kudago.UI.RequestAsyncTaskKudago;

public class Adapter_of_events extends RecyclerView.Adapter<VH_ForEvents> {
    private String[] ArrayData;
    public JsonArray arrayResult;

    public Adapter_of_events(String[] data) {
        super();
        ArrayData = data;
    }
    @Override
    public VH_ForEvents onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_events, parent, false);
        return new VH_ForEvents(view);
    }

    public void onBindViewHolder(final VH_ForEvents holder, final int position ) {
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
                arrayResult = posts.getResults();
                 Event[] ArrayOfEvent = new Event[arrayResult.size()];

                for(int i = 0 ; i < arrayResult.size() ; i++){
                    ArrayOfEvent[i] = gson.fromJson(arrayResult.get(i) , Event.class);
                }
                holder.tv_events.setText(ArrayOfEvent[position].getTitle());
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
