package AllForFragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mac.suchik.R;

public class VH_for_event_fragment extends RecyclerView.ViewHolder {
    public TextView tv_events;

    public VH_for_event_fragment(View view){
        super(view);
        tv_events = view.findViewById(R.id.text_view_for_fragment_event);
    }
}
