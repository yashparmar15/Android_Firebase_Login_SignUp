package com.example.signin;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
    public boolean OnCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public boolean OnOptionsItemSelected(MenuItem item){
        RelativeLayout main_view = (RelativeLayout) findViewById(R.id.lay1);
        if(item.getItemId()==R.id.action_settings){
            FirebaseAuth.getInstance().signOut();
            Intent intToMain = new Intent(Main2Activity.this, login.class);


            startActivity(intToMain);
            finish();


        }
        return true;
    }
    public void onBackPressed() {

        Intent t= new Intent(Main2Activity.this,Main2Activity.class);
        Toast.makeText(Main2Activity.this, "Please log out", Toast.LENGTH_SHORT).show();
        startActivity(t);
        FirebaseAuth.getInstance().signOut();

    }
}
