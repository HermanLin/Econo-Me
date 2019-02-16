package com.example.econo_me;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout = new ConstraintLayout(this);
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
        setContentView(constraintLayout);



    }
}
