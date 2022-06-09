package com.example.webmailqr;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    Button btnScanCode;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        btnScanCode=findViewById(R.id.btnScanCode);
        btnScanCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CameraScan.class));
            }

        });
        getSupportActionBar().hide();

        videoView = findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mobile);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                mp.setLooping(true);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    @Override
    protected void onResume() {
        videoView.resume();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        videoView.start();
        super.onRestart();
    }

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    @Override
    protected void onPause() {
        videoView.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        videoView.stopPlayback();
        super.onDestroy();
    }


}


