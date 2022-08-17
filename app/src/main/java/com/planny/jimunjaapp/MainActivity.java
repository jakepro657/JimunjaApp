package com.planny.jimunjaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.planny.jimunjaapp.listener.OnSwipeTouchListener;
import com.planny.jimunjaapp.task.RequestTask;
import com.planny.jimunjaapp.util.Adapter;
import com.planny.jimunjaapp.util.Prototype;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    EditText editText;
    Button button;
    ImageView imageView;
    Prototype prototype;
    CardView cardView;
    //RecyclerView recyclerView;
    Adapter adapter;
    View view;
    TextView owl;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        linearLayout = findViewById(R.id.linear);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        cardView = findViewById(R.id.cardView);
        owl = findViewById(R.id.owl);
        //recyclerView = findViewById(R.id.recycle);

        ImageView initialImage = new ImageView(getApplicationContext());
        initialImage.setId(0);
        initialImage.setImageIcon(Icon.createWithResource(getApplicationContext(), R.mipmap.ic_launcher));
        adapter = Adapter.getAdapter();
        adapter.insert(initialImage);
        adapter.setCardView(cardView);
        adapter.setOwl(owl);
        view = adapter.init();


        cardView.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            public void onSwipeTop() {
                Toast.makeText(getApplicationContext(), "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {

                cardView.removeView(view);

                if (!adapter.isFirst()) {
                    view = adapter.left();
                } else {
                    cardView.addView(view);
                }

                Toast.makeText(getApplicationContext(), "right", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeft() {
                cardView.removeView(view);

                if (!adapter.isLast()) {
                    view = adapter.right();
                } else {
                    cardView.addView(view);
                }
                Toast.makeText(getApplicationContext(), "left", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeBottom() {
                Toast.makeText(getApplicationContext(), "bottom", Toast.LENGTH_SHORT).show();
            }
        });

        prototype = new Prototype(getApplicationContext(), cardView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicked!");
                String keyword = editText.getText().toString();
                RequestTask task = new RequestTask(keyword, prototype);
                task.execute();
            }
        });


    }

}

