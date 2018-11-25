package jukify.jukify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewSong extends AppCompatActivity {
    public TextView songNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_song);
        songNameTextView = findViewById(R.id.songName);
    }

    public void addSong(View v){
        String songName = songNameTextView.getText().toString();


        Intent intent = new Intent();
        intent.putExtra("Name", songName);
        setResult(RESULT_OK, intent);
        finish();
    }

}
