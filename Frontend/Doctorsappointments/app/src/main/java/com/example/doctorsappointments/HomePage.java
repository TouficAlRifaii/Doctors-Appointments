package com.example.doctorsappointments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private TextView dr_name;
    private TextView dr_name1;
    private TextView dr_name2;
    private TextView dr_name3;
    private int img_id1;
    private int img_id2;
    private int img_id3;
    private int img_id4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();
        dr_name=(TextView) findViewById(R.id.txtv);
        dr_name1=(TextView) findViewById(R.id.txtv2);
        dr_name2=(TextView) findViewById(R.id.txtv3);
        dr_name3=(TextView) findViewById(R.id.txtv4);
        img_id1=R.id.icDr2;
        img_id2=R.id.icDr1;
        img_id3=R.id.icDr3;
        img_id4=R.id.icDr4;


    }
    public void visitDoc(View v){
        Intent i = new Intent(getApplicationContext(),DoctorProfile.class);
        //check phone number of dr and then change to the other activity with the data so that i can customize ir as i see fit
        startActivity(i);
    }
}