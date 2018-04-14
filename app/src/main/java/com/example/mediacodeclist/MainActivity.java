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

    protected String getMediaCodecListString() {
        // https://stackoverflow.com/a/22719891
        int numCodecs = MediaCodecList.getCodecCount();
        // create a vector of codec names
        Vector<String> codecVector = new Vector<>();
        for (int i = 0; i < numCodecs; i++) {
            MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i);
            String codec_name = codecInfo.getName();
            codecVector.add(codec_name);
            // str += " type: " + (codecInfo.isEncoder() ? "encoder" : "decoder");
            for (String type : codecInfo.getSupportedTypes()) {
                boolean ap = codecInfo.getCapabilitiesForType(type).isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_AdaptivePlayback);
                //str += "  supports adaptive playback: " + ap + "\n";
            }
        }
        // sort the vector
        Collections.sort(codecVector);
        // convert the vector into a string
        String str = "numCodecs: " + numCodecs + "\n";
        for (int i = 0; i < codecVector.size(); i++) {
            str += " " + codecVector.get(i) + "\n";
        }
        return str;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_codec_list);
        String str = getMediaCodecListString();
        // print the string
        TextView mediaCodecList = findViewById(R.id.media_codec_list);
        mediaCodecList.setMovementMethod(new ScrollingMovementMethod());
        mediaCodecList.setText(str);
    }
}
