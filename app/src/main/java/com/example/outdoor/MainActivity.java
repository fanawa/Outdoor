package com.example.outdoor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

public class MainActivity extends AppCompatActivity {


    public static final String API_KEY = "AIzaSyAnf4fUNdT8ANFpCZ4LfnS_AWqAlHnidJ8";  //APIキー6
    public static final String API_KEY2 = "AIzaSyBttLfs4-WNNgqOBSMMKeY9NN7jPmvUJto";  //APIキー7
    public static final String API_KEY3 = "";
    public static final String API_KEY4 = "";
    public static final String VIDEO_ID = "CQ6dbUmU__o";
    public static final String VIDEO_ID1 ="AsKf_wNiqsc&t=26s";    //video1
    public static final String VIDEO_ID2 = "bMirF_WKEQA";         //video2
    public static final String VIDEO_ID3 = "zZECV1OYzL0";         //video3
    public static final String VIDEO_ID4 = "UWC8kDkv3Hg";         //video4


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("log", "onCreate");

        //video1
        YouTubePlayerFragment youTubePlayerFragment = (YouTubePlayerFragment) getFragmentManager()
                .findFragmentById(R.id.fragment1);

        youTubePlayerFragment.initialize
                (
                        API_KEY,
                        new YouTubePlayer.OnInitializedListener() {
                            @Override
                            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
                                youTubePlayer.setFullscreenControlFlags(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_ORIENTATION |
                                        YouTubePlayer.FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE);

                                if (!wasRestored) {
                                    youTubePlayer.cueVideo(VIDEO_ID1);

                                    Log.i("log", "onInitializationSuccess");
                                }
                            }

                            @Override
                            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
                                final int REQUEST_CODE = 1;

                                if (error.isUserRecoverableError()) {
                                    error.getErrorDialog(MainActivity.this, REQUEST_CODE).show();
                                } else {
                                    String errorMessage = String.format("There was an error initializing the YoutubePlayer (%1$s)", error.toString());
                                    Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                );
        //video1 ここまで


    }

}