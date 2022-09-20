package com.example.doctorreport;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataSync extends AppCompatActivity {

    DatabaseReference reference;
    FirebaseDatabase rootNode;

    Button newUser, returningUser;

    EditText ign, lmd, orundum;

    int parsedLmd, parsedOrundum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_sync);

        newUser = findViewById(R.id.CreateNewProfile);
        returningUser = findViewById(R.id.SyncOldUser);

        ign = findViewById(R.id.InputIGNText);
        lmd = findViewById(R.id.LMDinput);
        orundum = findViewById(R.id.OrundumInput);

        parsedLmd = Integer.parseInt(lmd.getText().toString().trim());
        parsedOrundum = Integer.parseInt((orundum.getText().toString().trim()));

        createUserProfile();
        syncReturningUser();
    }

    private void createUserProfile() {
        NewProfile newuser = new NewProfile(parsedLmd, parsedOrundum);
        newUser.setMovementMethod(LinkMovementMethod.getInstance());
        newUser.setOnClickListener(view -> {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Users").child(ign.getText().toString());
        reference.setValue(newuser);
        startActivity(new Intent(DataSync.this, MainActivity.class));
        });
    }

    private void syncReturningUser() {
        returningUser.setMovementMethod(LinkMovementMethod.getInstance());
        returningUser.setOnClickListener(view -> {
            startActivity(new Intent(DataSync.this, Popup.class));
        });
    }

}
