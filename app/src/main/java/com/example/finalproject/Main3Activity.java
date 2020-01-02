package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class Main3Activity extends AppCompatActivity {
    public VideoView myVideo2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
//        myVideo2= findViewById(R.id.myVideo);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               acc();
            }
        });



    }
    public void acc(){
        try {
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.rat);
                    VideoView myVideo2 = new VideoView(this);
            setContentView(myVideo2);
            myVideo2.setVideoURI(uri);
            myVideo2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(false);
                }
            });
            myVideo2.start();
        } catch (Exception e) {

        }

    }
}
