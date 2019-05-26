package com.example.mac.suchik.UI;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mac.suchik.R;
import com.example.mac.suchik.UI.main_window.Adapter_of_events;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.IOException;

import AllForFragment.Adapter_for_fragment_event;
import AllForFragment.Dialog;
import okhttp3.Response;
import response.kudago.UI.AsyncResponseKudago;
import response.kudago.UI.Event;
import response.kudago.UI.RequestAsyncTaskKudago;

public class EventListFragment extends Fragment {
    RecyclerView rv;
    TextView tv;
    String[] arrayResult;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.event_fragment, container, false);
        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rv = view.findViewById(R.id.rv_event_fragment);
        tv = view.findViewById(R.id.text_view_event_list);
        String[] categoriesForEquals = getResources().getStringArray(R.array.categoriesEvent);
        Adapter_of_events events_adapter = new Adapter_of_events(categoriesForEquals);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL , false));
        rv.setAdapter(events_adapter);
        super.onViewCreated(view, savedInstanceState);
    }

}
