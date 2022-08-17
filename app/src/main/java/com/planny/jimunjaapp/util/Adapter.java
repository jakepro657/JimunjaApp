package com.planny.jimunjaapp.util;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class Adapter {

    private static Adapter adapter = new Adapter();
    private ArrayList<View> views = new ArrayList<>();
    int count = 0;
    private CardView cardView;
    private View view;
    private TextView owl;

    public static Adapter getAdapter() {
        return adapter;
    }

    public void setCardView(CardView cardView) {
        this.cardView = cardView;
    }

    public void setOwl(TextView owl) {
        this.owl = owl;
    }

    public void insert(View view) {
        views.add(view);
    }

    public View init() {

        String text = (count + 1) + "/" + views.size();
        owl.setText(text);
        view = views.get(count);
        cardView.addView(view);
        return view;

    }

    public View left() {

        view = views.get(--count);
        String text = (count + 1) + "/" + views.size();
        owl.setText(text);
        cardView.addView(view);
        return view;

    }

    public View right() {

        view = views.get(++count);
        String text = (count + 1) + "/" + views.size();
        owl.setText(text);
        cardView.addView(view);
        return view;

    }

    public boolean isLast() {
        return count == views.size() - 1;
    }

    public boolean isFirst() {
        return count == 0;
    }

    public void setOwlText(String text) {
        owl.setText(text);
    }

    public int getViewListSize() {
        return this.views.size();
    }
}
