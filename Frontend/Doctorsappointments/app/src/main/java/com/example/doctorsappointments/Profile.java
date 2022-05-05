package com.example.doctorsappointments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String[] arraySpinner = new String[] {//here is what you store in the spinner
                "1", "2", "3", "4", "5", "6", "7"
        };
        Spinner s = (Spinner) findViewById(R.id.drList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {//this method will be changed so that when we select a dr it takes us to their page
                // TODO Auto-generated method stub
                Toast.makeText(getBaseContext(), arraySpinner[position], Toast.LENGTH_SHORT).show();
            }


            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
    public void goBack(View v){
        startActivity(new Intent(getApplicationContext(), Menu.class));
    }
}