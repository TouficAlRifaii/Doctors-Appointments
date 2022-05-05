package com.example.doctorsappointments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }
    public void toHome (View v) {
        startActivity(new Intent(this , HomePage.class));
    }
    public void toFavorites(View v) {
        startActivity(new Intent(this , FavoritesPage.class));
    }
    public void toDoctors (View v) {
        startActivity(new Intent(this , DoctorsPage.class));
    }
    public void toProfile (View v) {
        startActivity(new Intent(this , Profile.class));
    }


}