package com.cymonevo.nova.jarvis.core.exoplayer;

import android.content.Context;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;

public class ExoClient {
    SimpleExoPlayer client;

    public ExoClient(Context context) {
        client = ExoPlayerFactory.newSimpleInstance(context);
    }
}
