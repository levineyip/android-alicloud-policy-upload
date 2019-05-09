package com.nbc.behavior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class EasyBehaviorActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_behavior);

        btnTest = findViewById(R.id.btnBehavior);
        btnTest.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            v.setX(event.getRawX() - v.getWidth() / 2);
            v.setY(event.getRawY() - v.getHeight() / 2);
        }
        return false;
    }

}
