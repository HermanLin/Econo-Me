package com.example.econo_me;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        final ConstraintLayout constraintLayout = new ConstraintLayout(this);
        ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        constraintLayout.setLayoutParams(layoutParams);

        final EditText nameBox = new EditText(this);
        final EditText descBox = new EditText(this);
        String defaultName = "Purchase Name";
        String defaultDesc = "Description (optional)";
        nameBox.setHint(defaultName);
        descBox.setHint(defaultDesc);
        nameBox.setTranslationX(400);
        descBox.setTranslationX(400);
        nameBox.setTranslationY(500);
        descBox.setTranslationY(700);
        constraintLayout.addView(nameBox);
        constraintLayout.addView(descBox);
        setContentView(constraintLayout);

        Button submitButton = new Button(this);
        submitButton.setText("Submit");
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameBox.getText().toString();
                String desc = descBox.getText().toString();
                Database.addItem(name,desc);
            }
        });
        submitButton.setTranslationX(600);
        submitButton.setTranslationY(1000);
        constraintLayout.addView(submitButton);
    }
}
