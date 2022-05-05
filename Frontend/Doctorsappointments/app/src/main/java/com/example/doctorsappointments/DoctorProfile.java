package com.example.doctorsappointments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class DoctorProfile extends AppCompatActivity {

    private String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String sessionId = getIntent().getStringExtra("key");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
    }
}