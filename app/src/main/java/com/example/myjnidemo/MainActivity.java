package com.example.myjnidemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    String [] perms = {Manifest.permission.MODIFY_AUDIO_SETTINGS,Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        String msg = SayHello.sayHello();
        tv.setText(msg);
        tv.append("\n"+LameUtils.getLameVersion());
        Log.d("ddebug","jni str = " + msg);

        ActivityCompat.requestPermissions(this, perms, 1);
    }

    public void start(View tv) {
        Log.d("ddebug","---start---");

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
    public void record(View tv) {
        startActivity(new Intent(this,TestAudioRecord.class));
    }
}