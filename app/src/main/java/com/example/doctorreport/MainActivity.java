package com.example.doctorreport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button syncButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        syncButton = findViewById(R.id.SyncButton);

        toSyncingPage();
    }

    private void toSyncingPage() {
        syncButton.setMovementMethod(LinkMovementMethod.getInstance());
        syncButton.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, DataSync.class));
        });
    }

}