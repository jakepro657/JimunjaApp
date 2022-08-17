package com.planny.jimunjaapp.listener;


import android.view.View;
import android.widget.EditText;

import com.planny.jimunjaapp.MainActivity;
import com.planny.jimunjaapp.R;

public class OnTaskButtonClicked implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        EditText editText = view.findViewById(R.id.editText);
        String text = editText.getText().toString();

    }
}
