package jukify.jukify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.ImageView;

//Spotify
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;

import com.spotify.protocol.types.ImageUri;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;


import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Login extends AppCompatActivity {

    //Authentication
    public static final String EXTRA_MESSAGE = "";
    private static final String CLIENT_ID = "65d4b1cd6094484e8677788458422337";
    private static final String REDIRECT_URI = "https://developer.spotify.com/dashboard/applications/65d4b1cd6094484e8677788458422337";
    private static final int REQUEST_CODE = 1337;
    private SpotifyAppRemote mSpotifyAppRemote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signIn(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        Intent intent = new Intent(this, displayFeedActivity.class);

        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString() + editText2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();

        //Open LoginActivity
        AuthenticationRequest.Builder builder =
                new AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI);
        builder.setScopes(new String[]{"streaming"});
        AuthenticationRequest request = builder.build();

        AuthenticationClient.openLoginActivity(this, REQUEST_CODE, request);

        //Connect to Spotify App Remote
        // Set the connection parameters
        ConnectionParams connectionParams =
                new ConnectionParams.Builder(CLIENT_ID)
                        .setRedirectUri(REDIRECT_URI)
                        .showAuthView(true)
                        .build();
        SpotifyAppRemote.connect(this, connectionParams,
                new Connector.ConnectionListener() {

                    @Override
                    public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                        mSpotifyAppRemote = spotifyAppRemote;
                        Log.d("Login", "Connected! Yay!");

                        // Now you can start interacting with App Remote
                        connected();
                    }

                    @Override
                    public void onFailure(Throwable throwable) {

                        // Something went wrong when attempting to connect! Handle errors here
                        Log.e("Login", throwable.getMessage(), throwable);
                    }
                });

        }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // Check if result comes from the correct activity
        if (requestCode == REQUEST_CODE) {
            AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, intent);

            switch (response.getType()) {
                // Response was successful and contains auth token
                case TOKEN:
                    // Handle successful response
                    break;

                // Auth flow returned an error
                case ERROR:
                    // Handle error response
                    break;

                // Most likely auth flow was cancelled
                default:
                    // Handle other cases
            }
        }
    }


    private void connected() {
        // Play a playlist
        mSpotifyAppRemote.getPlayerApi().play("spotify:user:spotify:playlist:37i9dQZF1DX2sUQwD7tbmL");


        mSpotifyAppRemote.getImagesApi().getImage(new ImageUri("spotify:user:spotify:playlist:37i9dQZF1DX2sUQwD7tbmL"));
       // ImageView.setImageURI( mSpotifyAppRemote.getImagesApi().getImage(new ImageUri("spotify:user:spotify:playlist:37i9dQZF1DX2sUQwD7tbmL")));
        mSpotifyAppRemote.getPlayerApi().setShuffle(true);
    }

    public void skipButtonClick(View v)
    {
        Button button=(Button) v;
        ((Button) v).setText("CLICKED");
        mSpotifyAppRemote.getPlayerApi().skipNext();

    }
    @Override
    protected void onStop() {
        super.onStop();
        SpotifyAppRemote.disconnect(mSpotifyAppRemote);
    }
}
