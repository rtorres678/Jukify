package jukify.jukify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class displayFeedActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Event> listEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_feed);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        listEvents = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            Event event = new Event("Event", "host", "id");
            listEvents.add(event);
        };

        mAdapter = new MyAdapter(listEvents, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void joinEvent(View view) {
        Intent intent = new Intent(this, playlistScreen.class);
        startActivity(intent);
    }

    public void createEvent(View view) {
        Intent intent = new Intent(this, newPlaylistScreen.class);
        startActivity(intent);
    }

}
