package jukify.jukify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class newPlaylistScreen extends AppCompatActivity {
    EditText nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_playlist_screen);
        nameText  = findViewById(R.id.newPlaylistName);
    }

    void createNewPlaylist(View v)
    {
        String name = nameText.getText().toString();
        Event eventNew = new Event(name);

        Intent intent = new Intent(v.getContext(),  playlistScreen.class);
        intent.putExtra("Event", eventNew);
        v.getContext().startActivity(intent);
    }
}
