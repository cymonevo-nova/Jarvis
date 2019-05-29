package com.cymonevo.aurora.template.core.picasso;

import android.widget.ImageView;

import com.cymonevo.aurora.template.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class PicassoClient {
    public static void load(String url, ImageView dest) {
        apply(setPlaceholder(loadUrl(url).fit()), dest);
    }

    public static void loadSize(String url, int width, int height, ImageView dest) {
        apply(setPlaceholder(loadUrl(url).resize(width, height)), dest);
    }

    public static void loadSizeRes(String url, int widthRes, int heightRes, ImageView dest) {
        apply(setPlaceholder(loadUrl(url).resizeDimen(widthRes, heightRes)), dest);
    }

    private static RequestCreator loadUrl(String url) {
        return getInstance().load(url);
    }

    private static RequestCreator setPlaceholder(RequestCreator request) {
        return request.error(R.drawable.placeholder);
    }

    private static void apply(RequestCreator request, ImageView dest) {
        request.centerCrop().into(dest);
    }

    private static Picasso getInstance() {
        return Picasso.get();
    }
}
