package com.planny.jimunjaapp.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.core.graphics.drawable.IconCompat;

import com.planny.jimunjaapp.R;

public class Prototype {

    public static final int IMAGE = 0;
    private final Context context;
    private ViewGroup viewGroup;
    private int count = 1;

    public Prototype(Context context) {
        this.context = context;
    }

    public Prototype(Context context, ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
        this.context = context;
    }

    public View MakeView(int type, String code) {
        ImageView imageView = null;
        switch (type) {
            case 0:
                imageView = new ImageView(this.context);
                imageView.setId(count);
                Bitmap bitmap = Decoder.decode(code);
                imageView.setImageBitmap(bitmap);
                break;
            default:
                break;
        }
        count++;
        return imageView;
    }
}
