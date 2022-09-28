package com.example.doctorreport;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RunCounter extends AppCompatActivity {

    Button increase, decrease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.run_counter);

        increase = findViewById(R.id.IncreaseRun);
        decrease = findViewById(R.id.DecreaseRun);
    }

}
