package com.appspot.gychen.intentdemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    protected void initView() {
        Button startIntentButton = (Button) findViewById(R.id.start_intent_button);
        startIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStartIntentButtonClick(view);
            }
        });
    }

    public void onStartIntentButtonClick(View view) {
        Intent intent = new Intent(IntentActivity.ACTION_NAME);
        startActivityForResult(intent, 4413);
    }
}
