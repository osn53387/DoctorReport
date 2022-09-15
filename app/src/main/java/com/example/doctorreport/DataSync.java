package com.example.doctorreport;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class DataSync extends AppCompatActivity {

    DatabaseReference reference;
    FirebaseDatabase rootNode;

    Button newUser;

    EditText ign, lmd, orundum;

    int parsedLmd, parsedOrundum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_sync);

        newUser = findViewById(R.id.CreateNewProfile);

        ign = findViewById(R.id.InputIGNText);
        lmd = findViewById(R.id.LMDinput);
        orundum = findViewById(R.id.OrundumInput);

        parsedLmd = Integer.parseInt(lmd.getText().toString().trim());
        parsedOrundum = Integer.parseInt((orundum.getText().toString().trim()));

        createUserProfile();
    }

    private void createUserProfile() {
        NewProfile newuser = new NewProfile(ign.getText().toString(), parsedLmd, parsedOrundum);
        newUser.setMovementMethod(LinkMovementMethod.getInstance());
        newUser.setOnClickListener(view -> {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Users");
        reference.setValue(newuser);
        startActivity(new Intent(DataSync.this, MainActivity.class));
        });
    }

}
