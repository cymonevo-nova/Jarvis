package com.cymonevo.nova.template.core.compressor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import id.zelory.compressor.Compressor;

public class CompressorClient {
    public static File compressFile(Context context, File file) {
        try {
            return new Compressor(context).compressToFile(file);
        } catch (IOException e) {
            return file;
        }
    }

    public static Bitmap fileToBitmap(Context context, File file) {
        try {
            return new Compressor(context).compressToBitmap(file);
        } catch (IOException e) {
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
    }

    public static Bitmap drawableToBitmap(Context context, int resId, int quality) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), resId);
        bmp.compress(Bitmap.CompressFormat.JPEG, quality, os);
        byte[] data = os.toByteArray();
        return BitmapFactory.decodeByteArray(data, 0, data.length);
    }

    public static Bitmap drawableToBitmap(Context context, int resId) {
        return drawableToBitmap(context, resId, 50);
    }
}
