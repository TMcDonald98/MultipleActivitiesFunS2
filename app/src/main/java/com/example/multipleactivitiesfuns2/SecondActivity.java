package com.example.multipleactivitiesfuns2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        // good practice
        if (intent != null) {
            String username = intent.getStringExtra("username");
            int pin = intent.getIntExtra("pin", 0);
            // if "username" isn't in intent, null is returned
            // if "pin" isn't in intent, 0 is returned
            Toast.makeText(this, username + " " + pin, Toast.LENGTH_SHORT).show();
        }

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 3.
                Intent intent = new Intent();
                intent.putExtra("result", "sucessful"); // dummy example
                setResult(Activity.RESULT_OK, intent);

                // 1.
                SecondActivity.this.finish();
            }
        });
    }
}
