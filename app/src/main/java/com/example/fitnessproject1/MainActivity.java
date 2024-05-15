package com.example.fitnessproject1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnv = findViewById(R.id.buttonnavigation);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, new Diet())
                .commit();

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nb_diet) {
                    Fragment fragment1 = new Diet();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment1).commit();

                }else if(id == R.id.nb_profile) {
                    Fragment fragment2 = new Profile();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment2).commit();

                }else if (id == R.id.nb_logout) {
                    FirebaseAuth.getInstance().signOut();

                    Intent loginIntent = new Intent(MainActivity.this, Login.class);
                    startActivity(loginIntent);
                    finish(); //
                }


                return true;
                }

        });


    }


}