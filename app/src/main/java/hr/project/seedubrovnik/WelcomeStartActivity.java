package hr.project.seedubrovnik;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;


//hello world
//back to old

public class WelcomeStartActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_start);
        DrawNav();
    }



    //----------###############################-----NAVBAR *start* -----------###############################---------------------------------
    public DrawerLayout mDrawerLayout;
    public ActionBarDrawerToggle mToggle;

    public void onClickStart(View view) {
        Intent intent = new Intent(this, PickDestination.class);
        startActivity(intent);
    }

    //Navbar DRAW *start*
    public void DrawNav(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.view_nav);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        // set item as selected to persist highlight
                        item.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        int id = item.getItemId();

                        if (id == R.id.destination) {
                            Directions.GoDestinations(getBaseContext());
                        }
                        if (id == R.id.restaurants) {
                            Directions.GoRestaurant(getBaseContext());

                        }
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
// ------------------###############################-------------- NAVBAR*END* -------------------------###############################------------------------------------------------------

}
