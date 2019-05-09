package AllForFragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mac.suchik.R;
import com.example.mac.suchik.UI.main_window.VH_ForEvents;

public class Adapter_for_fragment_event extends RecyclerView.Adapter<VH_for_event_fragment> {
    private String[] ArrayData;
    public Adapter_for_fragment_event(String[] data) {
        super();
        ArrayData = data;
    }

    @NonNull
    @Override
    public VH_for_event_fragment onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_for_event_in_fragment, viewGroup, false);
        return new VH_for_event_fragment(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH_for_event_fragment holder, int i) {
        holder.tv_events.setText(ArrayData[i]);
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
