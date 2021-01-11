package com.example.myconvertmp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.example.myjnidemo.LameUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    String [] perms = {Manifest.permission.MODIFY_AUDIO_SETTINGS,Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, perms, 1);
    }

    public void start(View v){
        new Thread(){
            @Override
            public void run() {
                super.run();
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "temp/out.wav";//"temp/test123.wav";
                String pathTaret = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "temp/out123.mp3";
                LameUtils.convertmp3(path,pathTaret);
            }
        }.start();
    }
}