package com.example.ueb4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ueb4.R;

import com.example.ueb4.music.view.MyMusicFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    private void setupDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,R.string.openDrawer, R.string.closeDrawer);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    private void init() {
        setupUiComponents();
        setupToolbar();
        setupDrawerToggle();
        setupNavigationDrawer();
        switchFragment(R.id.menu_nav_item_travel_stream);
    }

    private void setupUiComponents() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mNavigationView = findViewById(R.id.main_navigation_view);


    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
    }

    private void setupNavigationDrawer() {
        // Check the first item in the NavigationView
        mNavigationView.getMenu().getItem(0).setChecked(true);
        NavigationView.OnNavigationItemSelectedListener mListener = new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switchFragment(item.getItemId());
                mDrawerLayout.closeDrawers();
                return false;
            }
        };
        mNavigationView.setNavigationItemSelectedListener(mListener);


    }

    private void switchFragment(int menuItemId) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.alpha_transition_in, R.anim.alpha_transition_out);
        Fragment containerFragment = fragmentManager.findFragmentById(R.id.main_container);

        Fragment newFragment = getFragmentById(containerFragment, menuItemId);
        if (newFragment != null) {
            fragmentTransaction.replace(R.id.main_container, newFragment);
            fragmentTransaction.commit();
        }

    }

    private Fragment getFragmentById(Fragment containerFragment, int menuItemId) {
        switch (menuItemId) {
            case R.id.menu_nav_item_travel_stream:
                // Check if fragment is already there - prevent unnecessary replacement
                if (!(containerFragment instanceof com.example.ueb4.travelStream.view.TravelStreamFragment))
                    return com.example.ueb4.travelStream.view.TravelStreamFragment.newInstance(getString(R.string.nav_item_title_travel_stream));
                break;
            case R.id.menu_nav_items_music:
                if (!(containerFragment instanceof MyMusicFragment))
                    return MyMusicFragment.newInstance(getString(R.string.nav_item_title_my_music));
                break;
            default:
                return null;
        }
        // Return null if no change should occur
        return null;
    }


}
