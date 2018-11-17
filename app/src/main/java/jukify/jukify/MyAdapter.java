package jukify.jukify;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        public Button joinButton;
        public MyViewHolder(View v) {
            super(v);
            textViewName = (TextView) itemView.findViewById(R.id.TextViewEventName);
            textViewDesc = (TextView) itemView.findViewById(R.id.TextViewEventDescription);
            joinButton = (Button) itemView.findViewById(R.id.button5);

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

        final Event listEvent = listEvents.get(position);
        holder.textViewName.setText("Event Name: "+ listEvent.getName());
        holder.textViewDesc.setText("Hosted by: " + listEvent.getHost());


        holder.joinButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),  Playlist_screen.class);
                intent.putExtra("Event", listEvent);
                v.getContext().startActivity(intent);
            }
        });
    }

    // Return the size of the feed (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listEvents.size();
    }
}