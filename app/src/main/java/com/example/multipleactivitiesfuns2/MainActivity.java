package com.example.multipleactivitiesfuns2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MultipleActivitiesFunTag";
    static final int LOGIN_REQUEST_CODE = 1; // unique integer
    // for each of our requests for activity results
    // our activity might have multiple requests for activity results
    // the same callback onActivityResult() is called for all requests


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // this is a callback!!!
        // executes when a result from an activity is available

        // good practice
        if (requestCode == LOGIN_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // grab the "result" key's value out of data
            String result = data.getStringExtra("result");
            TextView tv = (TextView) findViewById(R.id.textView);
            tv.setText(result);
        }
    }

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

                // 2. passing data into second activity
                // we can add data to the intent via key-value pairs
                // like dictionary or hash map
                // lets say we want to pass a username and a pin to second activity
                // which needs these info for some reason
                String username = "spike";
                int pin = 1234;
                intent.putExtra("username", username);
                intent.putExtra("pin", pin);

                // 1. 2.
                //startActivity(intent);

                // 3.
                startActivityForResult(intent, LOGIN_REQUEST_CODE);
            }
        });

        Button viewButton = (Button) findViewById(R.id.viewButton);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 4. implicit intent example #1
                Intent intent = new Intent(Intent.ACTION_VIEW);
                // only three more lines of code
                Uri guUri = Uri.parse("https://www.gonzaga.edu");
                // uri - uniform resource identifier
                intent.setData(guUri);
                startActivity(intent);
            }
        });

        Button sendButton = (Button) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 5. implicit intent example #2
                Intent intent = new Intent(Intent.ACTION_SEND);
                // send a simple text message with some activity
                intent.setType("text/plain"); // mime type (media)
                intent.putExtra(Intent.EXTRA_TEXT, "My message to send :) :) :)");
                startActivity(intent);
            }
        });

        // task: create a new activity called ShareActivity and add textview
    }
}
