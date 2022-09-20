package com.example.doctorreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Popup extends Activity {

        Button finalSync;

        EditText ignCheck;

        DatabaseReference reference;
        FirebaseDatabase rootNode;

        @Override
        protected void onCreate(Bundle savedInstance) {
            super.onCreate(savedInstance);
            setContentView(R.layout.popup);

            finalSync = findViewById(R.id.FinalSync);

            ignCheck = findViewById(R.id.IgnSyncCheck);

            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

            int width = displayMetrics.widthPixels;
            int length = displayMetrics.heightPixels;

            getWindow().setLayout((int)(width * .8), (int)(length * .6));

            checkSync();
        }

        private void checkSync() {
            finalSync.setMovementMethod(LinkMovementMethod.getInstance());
            finalSync.setOnClickListener(view -> {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Users");
                if (ignCheck.getText().toString().trim() != reference.toString()) {
                    Toast.makeText(getApplicationContext(), "Invalid IGN, check again", Toast.LENGTH_LONG);
                } // else {} sync data from this sync'd ign to the main page.
            });
        }
}
