package com.example.myfirstprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView MyVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        MyVideoPlayer = (VideoView)findViewById(R.id.videoView);
        Uri myVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pepevideofile);
        MyVideoPlayer.setVideoURI(myVideoUri);
        MediaController mediaController = new MediaController(this);
        MyVideoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(MyVideoPlayer);
    }

    public void onStartClick(View view) {
        MyVideoPlayer.start();
    }

    public void onPauseClick(View view){
        MyVideoPlayer.pause();
    }

    public void onStopclick(View view){
        MyVideoPlayer.stopPlayback();
        MyVideoPlayer.resume();
    }
}