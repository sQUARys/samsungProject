package com.example.mac.suchik.UI;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import AllForFragment.Dialog;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.suchik.R;
import com.example.mac.suchik.UI.main_window.Adapter_of_events;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import AllForFragment.Adapter_for_fragment_event;
import AllForFragment.Dialog;
import okhttp3.Response;
import response.kudago.UI.AsyncResponseKudago;
import response.kudago.UI.Event;
import response.kudago.UI.RequestAsyncTaskKudago;



public class EventListFragment extends Fragment {
    RecyclerView rv;
    JsonArray arrayResult;
    public static String[] imageToShow = new String[10];
    public static String[] titleToShow = new String[10];
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.event_fragment, container, false);
        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rv = view.findViewById(R.id.rv_event_fragment);
        final String[] categoriesEventIfYES = getResources().getStringArray(R.array.categoriesEventIfYES);
        final String[] categoriesEventIfNO = getResources().getStringArray(R.array.categoriesEventIfNO);

        RequestAsyncTaskKudago newTask = new RequestAsyncTaskKudago(new AsyncResponseKudago() {
            @Override
            public void processFinish(Response result) {

                String resultString = "";
                try {
                    resultString = result.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                Event posts = gson.fromJson(resultString, Event.class);
                arrayResult = posts.getResults();
                Event[] ArrayOfEvent = new Event[arrayResult.size()];
                Event[] ArrayOfImages = new Event[arrayResult.size()];
                String[] ArrayOfCategories = new String[arrayResult.size()];

                for (int i = 0; i < arrayResult.size(); i++) {
                    ArrayOfEvent[i] = gson.fromJson(arrayResult.get(i), Event.class);
                    ArrayOfImages[i] = gson.fromJson(ArrayOfEvent[i].getImages().get(0), Event.class);
                    ArrayOfCategories[i] = ArrayOfEvent[i].getCategories()[0];
                }
                int value;
                if (MainActivityUI.ButtonChoice.isFlag()) {
                    switch (MainActivityUI.ButtonChoice.getAlert()) {
                        case "Yes":
                            value = 0;
                            for (int i = 0; i < ArrayOfCategories.length; i++) {
                                for (int j = 0; j < categoriesEventIfYES.length; j++) {
                                    if (ArrayOfCategories[i].equals(categoriesEventIfYES[j])) {
                                        imageToShow[value] = ArrayOfImages[i].getImage();
                                        titleToShow[value] = ArrayOfEvent[i].getTitle();
                                        if(value < 9) {
                                            value++;
                                        }else {
                                            return;
                                        }
                                    }
                                }
                            }
                            break;
                        case "No":
                            value = 0;
                            for (int i = 0; i < ArrayOfCategories.length; i++) {
                                for (int j = 0; j < categoriesEventIfNO.length; j++) {
                                    if (ArrayOfCategories[i].equals(categoriesEventIfNO[j])) {
                                        imageToShow[value] = ArrayOfImages[i].getImage();
                                        titleToShow[value] = ArrayOfEvent[i].getTitle();
                                        if(value < 9) {
                                            value++;
                                            Log.e("VALUE" , value + "");
                                        }else {
                                            return;
                                        }
                                    }
                                }
                            }
                            break;
                    }
                }


            }
        });
        newTask.execute();
        Adapter_of_events events_adapter = new Adapter_of_events(categoriesEventIfYES , categoriesEventIfNO , imageToShow ,titleToShow );
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL , false));
        rv.setAdapter(events_adapter);
        super.onViewCreated(view, savedInstanceState);
    }
}

