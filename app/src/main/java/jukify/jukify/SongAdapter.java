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

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private List<Song> listSongs;
    SongViewHolder holder2;

    public SongAdapter(List<Song> listSongs, Context context) {
        this.listSongs = listSongs;
        this.context = context;
    }


    private Context context;

    public static class SongViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewArt;
        public TextView textViewScore;
        public Button upsButton;
        public Button downsButton;
        public SongViewHolder(View v) {
            super(v);
            textViewName = (TextView) itemView.findViewById(R.id.TextViewSongName);
            textViewArt = (TextView) itemView.findViewById(R.id.TextViewArtistName);
            textViewScore = (TextView) itemView.findViewById(R.id.textViewScore);
            upsButton = (Button) itemView.findViewById(R.id.upsButton);
            downsButton = (Button) itemView.findViewById(R.id.downsButton);
        }
    }

    public SongAdapter(List<Song> list_Songs) {
        listSongs = list_Songs;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SongAdapter.SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_text_view , parent,false);
        return new SongViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {

        final Song listSong = listSongs.get(position);
        holder.textViewName.setText("Song Name: "+ listSong.getName());
        holder.textViewArt.setText("By: " + listSong.getArtist());
        holder.textViewScore.setText("" +listSong.getScore());


        holder.upsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //holder2.textViewScore.setText(listSong.getScore());
            }
        });

        holder.downsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //holder2.textViewScore.setText(listSong.getScore());
            }
        });
    }

    // Return the size of the feed (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listSongs.size();
    }
}