package jukify.jukify;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Event> listEvents;

    public MyAdapter(List<Event> listEvents, Context context) {
        this.listEvents = listEvents;
        this.context = context;
    }

    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewDesc;
        public MyViewHolder(View v) {
            super(v);
            textViewName = (TextView) itemView.findViewById(R.id.TextViewEventName);
            textViewDesc = (TextView) itemView.findViewById(R.id.TextViewEventDescription);

        }
    }

    public MyAdapter(List<Event> list_Events) {
        listEvents = list_Events;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view , parent,false);
        return new MyViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Event listEvent = listEvents.get(position);
        holder.textViewName.setText("Event Name: "+ listEvent.getName());
        holder.textViewDesc.setText("Hosted by: " + listEvent.getHost());
    }

    // Return the size of the feed (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listEvents.size();
    }
}