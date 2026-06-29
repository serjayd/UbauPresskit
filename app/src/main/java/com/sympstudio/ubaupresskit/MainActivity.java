package com.sympstudio.ubaupresskit;

import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;
import com.sympstudio.ubaupresskit.fragments.ContactFragment;
import com.sympstudio.ubaupresskit.fragments.DevelopersFragment;
import com.sympstudio.ubaupresskit.fragments.FaqFragment;
import com.sympstudio.ubaupresskit.fragments.GoodiesFragment;
import com.sympstudio.ubaupresskit.fragments.HomeFragment;
import com.sympstudio.ubaupresskit.fragments.MediaFragment;
import com.sympstudio.ubaupresskit.fragments.PresskitFragment;
import com.sympstudio.ubaupresskit.fragments.TeamFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find elements in Main Activity
        drawerLayout = findViewById(R.id.drawerLayout);
        ImageButton menuButton = findViewById(R.id.menuButton);
        NavigationView navigationView = findViewById(R.id.navigationView);

        // Open burger Menu
        menuButton.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        // Open Home Fragment as the app opens
        if (savedInstanceState == null) {
            replaceFragment(new HomeFragment());
            navigationView.setCheckedItem(R.id.nav_home); // Show the selected page
        }

        // onClick events for nav links in menu
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                 replaceFragment(new HomeFragment());
            } else if (id == R.id.nav_media) {
                 replaceFragment(new MediaFragment());
            } else if (id == R.id.nav_team) {
                 replaceFragment(new TeamFragment());
            } else if (id == R.id.nav_developers) {
                 replaceFragment(new DevelopersFragment());
            } else if (id == R.id.nav_presskit) {
                 replaceFragment(new PresskitFragment());
            } else if (id == R.id.nav_goodies) {
                replaceFragment(new GoodiesFragment());
            } else if (id == R.id.nav_faq) {
                 replaceFragment(new FaqFragment());
            } else if (id == R.id.nav_contact) {
                 replaceFragment(new ContactFragment());
            }

            // Close menu after nav link clicked
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    // Method to change fragment containers (e.g., pages) inside the Main Activity
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}

// Goodies Form change substitle to blue dark
// goodies Form change `Select your rewards` to green