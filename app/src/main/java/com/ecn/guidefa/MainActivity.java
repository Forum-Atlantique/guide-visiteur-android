package com.ecn.guidefa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.io.*;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    CompanyListFragment companyListFragment = new CompanyListFragment();
    MapFragment mapFragment = new MapFragment();
    CvFragment cvFragment = new CvFragment();
    NotesFragment notesFragment = new NotesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.companies);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.companies:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, companyListFragment).commit();
                return true;
            case R.id.map:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();
                return true;
            case R.id.notes:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, notesFragment).commit();
                return true;
            case R.id.cv:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, cvFragment).commit();
                return true;
        }
        return false;
    }

}