package com.example.multipleactivitiesfuns2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MultipleActivitiesFunTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d(TAG, "onClick: ");
                // intent: a message to the Android OS
                // specifying our "intent" to start another activity
                // if the intent looks good, the OS will start the activity
                // explicit intent: we know the name of the activity class we
                // want to start
                // implicit intent: we don't know the name...
                // but we do know the action we want the activity to perform
                // examples of actions
                // Intent.ACTION_VIEW
                // Intent.ACTION_SEND
                // Intent.ACTION_WEB_SEARCH
                // Intent.ACTION_DIAL

                // 1. explicit intent example
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // source, destination
                startActivity(intent);
            }
        });
    }
}
