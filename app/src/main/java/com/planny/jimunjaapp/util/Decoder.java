package com.planny.jimunjaapp.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class Decoder {

    public static Bitmap decode(String code) {
        byte[] decoded = Base64.decode(code, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decoded, 0, decoded.length);
        return bitmap;
    }

}
