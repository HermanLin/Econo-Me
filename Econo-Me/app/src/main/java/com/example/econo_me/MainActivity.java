package com.example.econo_me;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        final Intent intent = new Intent(this, AddItemActivity.class);
        final ConstraintLayout constraintLayout = new ConstraintLayout(this);
        //RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
        ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        constraintLayout.setLayoutParams(layoutParams);

        Calendar cal = Calendar.getInstance();
        Date currDate =  cal.getTime();
        Long ms = currDate.getTime();
        System.out.println(ms);
        TextView textView = new TextView(this);
        textView.setText(ms.toString());
        ViewGroup.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(layoutParams1);
        constraintLayout.addView(textView);
        float fx = (float) 550.0;
        float fy = (float) 600.0;
        //textView.setTranslationX(fx);
        //textView.setTranslationY(fy);
        setContentView(constraintLayout);
        final Button addItemButton = new Button(this);
        Button seeItemsButton = new Button(this);
        Button settingsButton = new Button(this);
        String aib = "Add an Item";
        String sib = "See Items";
        String sb = "Settings";
        addItemButton.setText(aib);
        seeItemsButton.setText(sib);
        settingsButton.setText(sb);
        addItemButton.setTranslationX(fx);
        seeItemsButton.setTranslationX(fx);
        settingsButton.setTranslationX(fx);
        addItemButton.setTranslationY(fy);
        seeItemsButton.setTranslationY(fy + 150);
        settingsButton.setTranslationY(fy + 300);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                //AddItemActivity aia = new AddItemActivity();
                //EditText textBox = new EditText(addItemButton.getContext());
                //constraintLayout.addView(textBox);
            }
        });
        seeItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        constraintLayout.addView(addItemButton);
        constraintLayout.addView(seeItemsButton);
        constraintLayout.addView(settingsButton);

    }
}
