package com.appspot.gychen.intentdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity {
    public final static String ACTION_NAME = "com.appspot.gychen.intentdemo.IntentActivity";

    private TextView mTextViewSignature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        mTextViewSignature = (TextView) findViewById(R.id.signature);

        ComponentName callingActivity = getCallingActivity();
        if (callingActivity == null) {
            Toast.makeText(this, "Not start this activity from startActivityForResult() function.", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        PackageManager pm = getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo(callingActivity.getPackageName(), PackageManager.GET_SIGNATURES);
            Signature signature = pi.signatures[0];
            String signature_s = signature.toCharsString();
            mTextViewSignature.setText(signature_s);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
