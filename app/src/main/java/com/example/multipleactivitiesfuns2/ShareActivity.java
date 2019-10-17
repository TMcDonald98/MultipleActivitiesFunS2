package com.example.multipleactivitiesfuns2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Intent intent = getIntent();
        // good practice
        if (intent != null) {
            // good practice
            String action = intent.getAction();
            String type = intent.getType();
            if (action.equals(Intent.ACTION_SEND) && type.equals("text/plain")) {
                String message = intent.getStringExtra(Intent.EXTRA_TEXT);
                TextView tv = (TextView) findViewById(R.id.shareTextView);
                tv.setText(message);
            }
        }
    }
}
