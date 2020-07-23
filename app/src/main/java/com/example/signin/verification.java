package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class verification extends AppCompatActivity {
    Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        loginbtn = findViewById(R.id.button3);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(verification.this,login.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void onBackPressed(){
        Intent h= new Intent(verification.this,login.class);
        startActivity(h);

    }
}