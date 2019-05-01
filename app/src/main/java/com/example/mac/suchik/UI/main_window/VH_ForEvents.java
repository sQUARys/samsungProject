package com.example.mac.suchik.UI.main_window;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mac.suchik.R;

public class VH_ForEvents extends RecyclerView.ViewHolder {
    public TextView tv_events;
    public ImageView im_events;

    public VH_ForEvents(View view){
        super(view);
        tv_events = view.findViewById(R.id.textView_events);
        im_events = view.findViewById(R.id.image_event);
    }
}
