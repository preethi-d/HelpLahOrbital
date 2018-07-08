package com.example.preethidevarajan.helplahorbital;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toolbar;
import android.support.v7.app.ActionBarDrawerToggle;

public class HomeActivity extends AppCompatActivity {
    /*private DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mActionBarDrawerToggle;
    */
    ImageButton drawerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerButton = (ImageButton) findViewById(R.id.drawerButton);

        drawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //what happend when they click sign up
                openNavigationActivity();
            }

        });
    }

    public void openNavigationActivity() {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }


        // mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        
        /*drawerLayout = findViewById(R.id.drawer_layout);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //ActionBar actionbar = getSupportActionBar();
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        //set item as selected to persist highlight
                        item.setChecked(true);
                        //close drawer when item is tapped
                       // DrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });



        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open_drawer, R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    */

}

