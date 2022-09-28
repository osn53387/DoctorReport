package com.example.doctorreport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button syncButton, lmdButton, rockButton;

    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        syncButton = findViewById(R.id.SyncButton);
        lmdButton = findViewById(R.id.LMDGrindtime);
        rockButton = findViewById(R.id.OneDashSeven);
        time = findViewById(R.id.Time);

        toSyncingPage();
        updateRealTime();
        lmdGrindTime();
    }

    private void toSyncingPage() {
        syncButton.setOnClickListener(view -> {
            startActivity(new Intent(this, DataSync.class));
            finish();
        });
    }

    private void updateRealTime() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                // display your time here...
                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                time.setText(currentDateTimeString);
            }
        }, 1000); // here 1 seconds to refresh time after 1 seconds
    }

    private void lmdGrindTime() {
        lmdButton.setOnClickListener(view -> {
            startActivity(new Intent(this, RunCounter.class));
        });
    }

    private void oneDashSevenTime() {
        rockButton.setOnClickListener(view -> {
            startActivity(new Intent(this, RunCounter.class));
        });
    }
}