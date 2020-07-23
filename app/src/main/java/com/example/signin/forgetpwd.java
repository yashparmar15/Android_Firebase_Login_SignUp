package com.example.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetpwd extends AppCompatActivity {
    Button resetpwd,tologin;
    TextView email;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forgetpwd);
        email = findViewById(R.id.editText3);
         resetpwd = findViewById(R.id.button4);
         tologin = findViewById(R.id.button5);
        mFirebaseAuth = FirebaseAuth.getInstance();
        resetpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid = email.getText().toString();
                if(emailid.isEmpty()){
                    Toast.makeText(forgetpwd.this, "Please give your Registered Email Id", Toast.LENGTH_SHORT).show();
                }
                else{

                    mFirebaseAuth.sendPasswordResetEmail(emailid)

                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(forgetpwd.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(forgetpwd.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                    }


                                }
                            });
                }

            }
        });
        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(forgetpwd.this,login.class);
                startActivity(n);
            }
        });

    }
    public void onBackPressed() {
        Intent t= new Intent(forgetpwd.this,login.class);
        startActivity(t);
        finish();

    }
}
