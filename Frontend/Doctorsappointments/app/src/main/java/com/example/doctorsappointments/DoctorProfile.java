package com.example.doctorsappointments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DoctorProfile extends AppCompatActivity {

    private String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        //take data form previous activities to know which dr profile to show

    }
    public void contact(View v){
        //calls the dr's number
    }
    public void back(View v){
        startActivity(new Intent(getApplicationContext(),Menu.class));
    }
}