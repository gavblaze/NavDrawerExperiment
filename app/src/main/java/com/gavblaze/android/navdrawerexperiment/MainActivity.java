package com.gavblaze.android.navdrawerexperiment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*Add the nav drawer button*/
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_open_drawer);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.im_port:
                        displayToast(getString(R.string.im_port));
                        break;
                    case R.id.gallery:
                        displayToast(getString(R.string.gallery));
                        break;
                    case R.id.slideshow:
                        displayToast(getString(R.string.slideshow));
                        break;
                    case R.id.tools:
                        displayToast(getString(R.string.tools));
                        break;
                    case R.id.share:
                        displayToast(getString(R.string.share));
                        break;
                    case R.id.send:
                        displayToast(getString(R.string.send));
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    /*Open the drawer when the button is tapped*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
