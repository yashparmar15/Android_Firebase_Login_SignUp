package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class homescreen extends AppCompatActivity {
    Button btnLogout;
    TextView tt;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        btnLogout = findViewById(R.id.logout);
        tt = findViewById(R.id.textView3);


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(homescreen.this, login.class);


                startActivity(intToMain);
                finish();


            }
        });




    }

    public void onBackPressed() {

        Intent t= new Intent(homescreen.this,homescreen.class);
        Toast.makeText(homescreen.this, "Please log out", Toast.LENGTH_SHORT).show();
        startActivity(t);
        FirebaseAuth.getInstance().signOut();

    }
    protected void onStart() {
        super.onStart();


    }
}

