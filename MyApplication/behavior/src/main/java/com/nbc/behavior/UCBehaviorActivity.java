package com.nbc.behavior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class UCBehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_uc_behavior);
    }

}
