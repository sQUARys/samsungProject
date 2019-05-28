package com.example.mac.suchik.UI.main_window;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mac.suchik.R;
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
    public JsonArray arrayResult;

    public Adapter_of_events(String[] data , String[] dataNo) {
        super();
        categoriesEventIfYES = data;
        categoriesEventIfNO = dataNo;
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
                Event[] ArrayOfImages = new Event[arrayResult.size()];
                String[] ArrayOfCategories = new String[arrayResult.size()];
                for(int i = 0 ; i < 5 ; i++){
                    ArrayOfEvent[i] = gson.fromJson(arrayResult.get(i) , Event.class);
                    ArrayOfImages[i] = gson.fromJson(ArrayOfEvent[i].getImages().get(0) , Event.class);
                    ArrayOfCategories[i] = ArrayOfEvent[i].getCategories()[0];
                }

                if (MainActivityUI.ButtonChoice.isFlag()) {
                    switch (MainActivityUI.ButtonChoice.getAlert()) {
                        case "Yes":

                                for (int i = 0; i < categoriesEventIfYES.length; i++) {
                                    int value = 0;
                                    if (categoriesEventIfYES[i].equals(ArrayOfCategories[value])) {
                                        //this is working if you tap yes
                                        Picasso.get().load(ArrayOfImages[position].getImage()).into(holder.im_events);
                                        holder.tv_events.setText(ArrayOfEvent[position].getTitle());
                                        value++;
                                    }
                                }
                            break;
                        case "No":
                            for (int i = 0; i < categoriesEventIfNO.length; i++) {
                                if (categoriesEventIfNO[i].equals(ArrayOfCategories[i])) {
                                    //this is working if you tap yes
                                    Picasso.get().load(ArrayOfImages[position].getImage()).into(holder.im_events);
                                    holder.tv_events.setText(ArrayOfEvent[position].getTitle());
                                }
                            }

                            break;
                    }
                }


            }
        });
        newTask.execute();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
    public void setList(List<String> new_elements){
    }

}
