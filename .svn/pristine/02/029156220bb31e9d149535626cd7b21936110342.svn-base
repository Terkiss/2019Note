package com.dotge.navigationdrawbar_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout ;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        drawerLayout = findViewById( R.id.main_drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close){};

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.main_drawer_view);
        View headerView = navigationView.getHeaderView(0);

        ImageView imageView = headerView.findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "zzz", Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.navi_camera)
                {
                    Toast.makeText(getApplicationContext(), "camera", Toast.LENGTH_LONG).show();
                }
                else  if(id == R.id.navi_gallery)
                {
                    Toast.makeText(getApplicationContext(), "gallart", Toast.LENGTH_LONG).show();
                }
                else if(id == R.id.navi_slidshow)
                {
                    Toast.makeText(getApplicationContext(), "slidshow", Toast.LENGTH_LONG).show();
                }
                else  if(id == R.id.navi_share)
                {
                    Toast.makeText(getApplicationContext(), "share", Toast.LENGTH_LONG).show();
                }
                else if(id == R.id.navi_manage)
                {
                    Toast.makeText(getApplicationContext(), "manage", Toast.LENGTH_LONG).show();
                }
                else  if(id == R.id.navi_send)
                {
                    Toast.makeText(getApplicationContext(), "send", Toast.LENGTH_LONG).show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
}
