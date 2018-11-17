package jukify.jukify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class playlistScreen extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Song> listSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_screen);


        mRecyclerView = (RecyclerView) findViewById(R.id.song_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        listSongs = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Song song = new Song("Ice Ice Baby", "Queen", 1, 0, 1, false, "spotify:track:3XVozq1aeqsJwpXrEZrDJ9");
            listSongs.add(song);
        };

        mAdapter = new SongAdapter(listSongs, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void upVote(View view) {

    }

    public void downVote(View view) {

    }
}
