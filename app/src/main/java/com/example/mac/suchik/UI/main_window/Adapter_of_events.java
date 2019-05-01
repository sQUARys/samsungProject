package com.example.mac.suchik.UI.main_window;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mac.suchik.R;
import com.example.mac.suchik.UI.settings_page.VH;
import com.example.mac.suchik.WeatherData.Forecasts;

import java.util.List;

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

    public void onBindViewHolder(VH_ForEvents holder, int position) {
               holder.tv_events.setText("Привет");
    }

    @Override
    public int getItemCount() {
        return 10;
    }
    public void setList(List<String> new_elements){
    }

}
