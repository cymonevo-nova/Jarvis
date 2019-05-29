package com.cymonevo.nova.template.core.picasso;

import android.widget.ImageView;

import com.cymonevo.nova.template.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class PicassoClient {
    public static void load(String url, ImageView dest, boolean isCover) {
        if (isCover) {
            applyCover(setPlaceholder(loadUrl(url).fit()), dest);
        } else {
            applyInside(setPlaceholder(loadUrl(url).fit()), dest);
        }
    }

    public static void loadWithSize(String url, int width, int height, ImageView dest, boolean isCover) {
        if (isCover) {
            applyCover(setPlaceholder(loadUrl(url).resize(width, height)), dest);
        } else {
            applyInside(setPlaceholder(loadUrl(url).resize(width, height)), dest);
        }
    }

    public static void loadWithSizeRes(String url, int widthRes, int heightRes, ImageView dest, boolean isCover) {
        if (isCover) {
            applyCover(setPlaceholder(loadUrl(url).resizeDimen(widthRes, heightRes)), dest);
        } else {
            applyInside(setPlaceholder(loadUrl(url).resizeDimen(widthRes, heightRes)), dest);
        }
    }

    private static RequestCreator loadUrl(String url) {
        return getInstance().load(url);
    }

    private static RequestCreator setPlaceholder(RequestCreator request) {
        return request.error(R.drawable.placeholder);
    }

    private static void applyCover(RequestCreator request, ImageView dest) {
        request.fit().centerCrop().into(dest);
    }

    private static void applyInside(RequestCreator request, ImageView dest) {
        request.fit().centerInside().into(dest);
    }

    private static Picasso getInstance() {
        return Picasso.get();
    }
}
