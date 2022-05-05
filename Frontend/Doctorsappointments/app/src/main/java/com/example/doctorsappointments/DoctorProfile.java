package com.example.doctorsappointments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DoctorProfile extends AppCompatActivity {
    private int CALL  = 1;
    private String value;
    private String number;//phone number of the dr to be initialized 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        //take data form previous activities to know which dr profile to show

    }

    public void contact(View v){
        makePhoneCall();

    }
    public void makePhoneCall(){
        if (ContextCompat.checkSelfPermission(DoctorProfile.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(DoctorProfile.this, new String[] {Manifest.permission.CALL_PHONE}, CALL);

        }
        else{
            String dial = "tel: "+ number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }

    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CALL){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }
            else{
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void back(View v){
        startActivity(new Intent(getApplicationContext(),Menu.class));
    }
    public void addToFav(View v){
        //link to database and add this dr to the user's favorites
    }
}