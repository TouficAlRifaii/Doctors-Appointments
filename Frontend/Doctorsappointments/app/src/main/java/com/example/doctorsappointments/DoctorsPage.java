package com.example.doctorsappointments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DoctorsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_page);
    }
    public void chooseDr(View v){
        startActivity(new Intent(getApplicationContext(),DoctorProfile.class));
    }
    public void backToMenu(View v){
        startActivity(new Intent(getApplicationContext(),Menu.class));

    }
}