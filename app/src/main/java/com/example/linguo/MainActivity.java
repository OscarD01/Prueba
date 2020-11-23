package com.example.linguo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.linguo.fragments.Course_Fragment;
import com.example.linguo.fragments.League_Fragment;
import com.example.linguo.fragments.Profile_Fragment;
import com.example.linguo.fragments.Shop_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.course_menu){
                    showSelectedFragment(new Course_Fragment());
                }

                if (item.getItemId() == R.id.profile_menu){
                    showSelectedFragment(new Profile_Fragment());
                }

                if (item.getItemId() == R.id.league_menu){
                    showSelectedFragment(new League_Fragment());
                }

                if (item.getItemId() == R.id.shop_menu){
                    showSelectedFragment(new Shop_Fragment());
                }

                return true;
            }
        });
    }

    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}