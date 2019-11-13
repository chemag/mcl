package com.example.mediacodeclist;

import android.media.MediaCodecList;
import android.media.MediaCodecInfo;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class MediaCodecListDumper {

    protected String getMediaCodecListString() {
        // https://stackoverflow.com/a/22719891
        int numCodecs = MediaCodecList.getCodecCount();
        // create a vector of codec names
				TreeMap<String, String> codecVector = new TreeMap<>();
        for (int i = 0; i < numCodecs; i++) {
            MediaCodecInfo mediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
            String codec_name = mediaCodecInfo.getName();
						// get properties
						StringBuilder str = new StringBuilder();
            str.append(" name: " + mediaCodecInfo.getName());
            //str.append(" canonical_name: " + mediaCodecInfo.getCanonicalName());
            str.append(" type [");
            for (String tp: mediaCodecInfo.getSupportedTypes()) {
               str.append(" " + tp);
            }
            str.append(" ]");
            //str.append(" is_alias: " + mediaCodecInfo.isAlias());
            //str.append(" is_encoder: " + mediaCodecInfo.isEncoder());
            //str.append(" is_hardware_accelerated: " + mediaCodecInfo.isHardwareAccelerated());
            //str.append(" is_software_only: " + mediaCodecInfo.isSoftwareOnly());
            //str.append(" is_vendor: " + mediaCodecInfo.isVendor());
            // str += " type: " + (mediaCodecInfo.isEncoder() ? "encoder" : "decoder");
            for (String type : mediaCodecInfo.getSupportedTypes()) {
                boolean ap = mediaCodecInfo.getCapabilitiesForType(type).isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_AdaptivePlayback);
                //str += "  supports adaptive playback: " + ap + "\n";
            }
            codecVector.put(codec_name, str.toString());
        }
        // convert the vector into a string
        String str = "numCodecs: " + numCodecs + "\n";
				Set<Map.Entry<String, String>> set = codecVector.entrySet();
				for (Map.Entry<String, String> me : set) {
          //str += me.getKey() + ": " + me.getValue() + "\n";
          str += me.getValue() + "\n";
				}
        return str;
    }
}
