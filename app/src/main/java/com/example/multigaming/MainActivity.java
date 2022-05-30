package com.example.multigaming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn, play, exit;
    AlertDialog.Builder builder;
    DrawerLayout drawerLayout;
    NavigationView navigationView2;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        List<Affirmation> myDataset =  new Datasource().loadAffirmations();
       // MyListAdapter adapter = new MyListAdapter(myListData);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
//
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        ItemAdapter adapter  = new ItemAdapter(MainActivity.this , myDataset);
//
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.botton_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeActivity()).commit();

        drawerLayout = findViewById(R.id.main_layout_1);
        navigationView2 = findViewById(R.id.nav_side_view);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView2.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.side_home) {
                    drawerLayout.closeDrawer(GravityCompat.START);

                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new HomeActivity()).commit();
                } else if (item.getItemId() == R.id.side_settings) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new SettingsActivity()).commit();
                } else if (item.getItemId() == R.id.side_share) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new ShareActivity()).commit();
                }
                else if (item.getItemId() == R.id.side_logout) {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
                    startActivity(intent);

                }

                return true;
            }

        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    if (item.getItemId() == R.id.home_menu) {
                        selectedFragment = new HomeActivity();

                    } else if (item.getItemId() == R.id.favourite_menu) {
                        selectedFragment = new FavoriteActivity();
                    } else if (item.getItemId() == R.id.search_menu) {
                        selectedFragment = new SearchActivity();
                    }

                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }

            };
}