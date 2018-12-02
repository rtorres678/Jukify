package jukify.jukify;

import android.content.Intent;
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
    private boolean superSkipper = false;
    private int scoreThreshold = 0;
    private boolean Host = false;

    private List<Song> listSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_screen);
        String hostInt= getIntent().getStringExtra("Host");
        //int hostInt = Integer.parseInt((String)getIntent().getSerializableExtra("Host"));
        if(hostInt != null && hostInt.equals("true")) {
            Host = true;
        }
        else Host = false;


        mRecyclerView = (RecyclerView) findViewById(R.id.song_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        listSongs = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Song song = new Song("Ice Ice Baby", "Queen", 1, 0, 1, false, "spotify:track:3XVozq1aeqsJwpXrEZrDJ9");
            listSongs.add(song);
        };

        mAdapter = new SongAdapter(listSongs, this, Host);
        mRecyclerView.setAdapter(mAdapter);



    }

    public void editSettings(View view) {
        if(Host == true) {
            //EditText editText = (EditText) findViewById(R.id.editText);
            Intent intent = new Intent(this, Settings.class);

            //EditText editText2 = (EditText) findViewById(R.id.editText2);
            //String message = editText.getText().toString() + editText2.getText().toString();
            //intent.putExtra(EXTRA_MESSAGE, message);
            startActivityForResult(intent, 1);
        }
    }

    public void newSong(View v){
        Intent intent = new Intent(this, NewSong.class);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, 0);
        //does song exist in spotify?

        //if so update the playlist
    }
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String newSongName = (String) data.getSerializableExtra("Name");
                //check that song exists on spotify
                //add song to playlist
                Song song = new Song(newSongName, "Queen", 1, 0, 1, false, "spotify:track:3XVozq1aeqsJwpXrEZrDJ9");
                listSongs.add(song);
                mAdapter.notifyDataSetChanged();
            }
        }
        else if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                scoreThreshold =  Integer.parseInt((String)data.getSerializableExtra("Threshold"));
                int superSkipperInt = Integer.parseInt((String)data.getSerializableExtra("Skipper"));
                if(superSkipperInt == 1)
                    superSkipper = true;
                else
                    superSkipper = false;
            }
        }
    }

}
