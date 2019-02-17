package com.example.econo_me;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import java.util.ArrayList;
import android.widget.TextView;

public class SeeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ConstraintLayout constraintLayout = new ConstraintLayout(this);
        ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        constraintLayout.setLayoutParams(layoutParams);

        ArrayList<Item> pendingItems = Database.viewPending();
        System.out.println(pendingItems.size());
        for(int i = 0;i < pendingItems.size();i++){
            TextView tv = new TextView(this);
            tv.setText(pendingItems.get(i).getName());
            tv.setTranslationX(400);
            tv.setTranslationY(400 + 150 * i);
            constraintLayout.addView(tv);
        }
        setContentView(constraintLayout);
    }
}
