package com.vogella.android.myapplication.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.vogella.android.myapplication.R;
import com.vogella.android.myapplication.View.MainActivity;

public class MainActivityp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityp);
    }

    public void ListP(View view){
        // Create an Intent to start the second activity
        Intent randomIntent = new Intent(this, MainActivity.class);

// Start the new activity.
        startActivity(randomIntent);
    }
}
