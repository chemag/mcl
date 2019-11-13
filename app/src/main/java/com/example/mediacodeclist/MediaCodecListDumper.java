package com.example.mediacodeclist;

import android.media.MediaCodecList;
import android.media.MediaCodecInfo;
import java.util.Vector;
import java.util.Collections;


public class MediaCodecListDumper {

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
}
