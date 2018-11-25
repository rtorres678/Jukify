package jukify.jukify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import static java.lang.StrictMath.abs;

public class Settings extends AppCompatActivity {

    public TextView scoreThresholdTextView;
    public CheckBox superSkipperCB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        scoreThresholdTextView = findViewById(R.id.textViewScore);
        superSkipperCB = findViewById(R.id.superSkipper);

    }
    public void addSong(View v){
        int scoreThreshold = Integer.parseInt(scoreThresholdTextView.getText().toString());
        scoreThreshold = -1 * abs(scoreThreshold);
        boolean superSkipper = superSkipperCB.isChecked();


        Intent intent = new Intent();
        intent.putExtra("Threshold", scoreThreshold);
        if(superSkipper)
            intent.putExtra("Skipper", 1);
        else
            intent.putExtra("Skipper", 0);
        setResult(RESULT_OK, intent);
        finish();
    }
}
