package com.example.mac.suchik.UI;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mac.suchik.R;
import com.example.mac.suchik.UI.main_window.Adapter_of_events;

import AllForFragment.Adapter_for_fragment_event;

public class EventListFragment extends Fragment {
    RecyclerView rv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.event_fragment, container, false);
        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rv = view.findViewById(R.id.rv_event_fragment);
        String[] varChar = {"Привет" , "Как дела" , "Я родился" , "Что-то еще" , "Что-то еще", "Что-то еще", "Что-то еще", "Что-то еще", "Что-то еще", "Что-то еще", "Что-то еще"};
        Adapter_of_events events_adapter = new Adapter_of_events(varChar);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL , false));
        rv.setAdapter(events_adapter);
        super.onViewCreated(view, savedInstanceState);
    }
}
