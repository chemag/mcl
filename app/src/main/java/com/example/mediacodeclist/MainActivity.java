package com.example.mediacodeclist;

import android.media.MediaCodecList;
import android.media.MediaCodecInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;
import java.util.Vector;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    MediaCodecListDumper mMediaCodecListDumper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_codec_list);
        mMediaCodecListDumper = new MediaCodecListDumper();
        String str = mMediaCodecListDumper.getMediaCodecListString();
        // dump the string to the logcat

        // display the string in the TextView
        TextView mediaCodecList = findViewById(R.id.media_codec_list);
        mediaCodecList.setMovementMethod(new ScrollingMovementMethod());
        mediaCodecList.setText(str);
    }
}
