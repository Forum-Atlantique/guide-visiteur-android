package com.ecn.guidefa;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    CompanyListFragment companyListFragment = new CompanyListFragment();
    MapFragment mapFragment = new MapFragment();
    CvFragment cvFragment = new CvFragment();
    NotesFragment notesFragment = new NotesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // base settings
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // custom title bar
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.titlebar, null);
        actionBar.setCustomView(view);

        // bottom navigation bar
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.companies);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(item.toString());
        switch (item.getItemId()) {
            case R.id.companies:
                ft.replace(R.id.container, companyListFragment).commit();
                return true;
            case R.id.map:
                ft.replace(R.id.container, mapFragment).commit();
                return true;
            case R.id.notes:
                ft.replace(R.id.container, notesFragment).commit();
                return true;
            case R.id.cv:
                ft.replace(R.id.container, cvFragment).commit();
                return true;
        }
        return false;
    }

    public boolean goBackOnClick(View v){
        super.onBackPressed();
        return true;
    }



}