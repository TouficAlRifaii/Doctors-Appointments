package com.example.doctorsappointments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        getSupportActionBar().hide();
    }
    public void signup(View v){
        //link to database
        startActivity(new Intent(getApplicationContext(),Menu.class));
    }
    public void toLogin(View v){
        Intent intent = new Intent(this , LoginPage.class);
        startActivity(intent);
    }
}