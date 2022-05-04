package com.example.doctorsappointments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        getSupportActionBar().hide();
    }
    public void toSignUp(View v){
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
    }
    public void logIn(View v){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}