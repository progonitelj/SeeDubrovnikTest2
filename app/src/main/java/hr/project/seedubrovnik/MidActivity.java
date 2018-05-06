package hr.project.seedubrovnik;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MidActivity extends AppCompatActivity {

    private static final String TAG = "MidActivity";

    RecyclerView lsMonuments;
    RecyclerViewListAdapter lsMonumentsAdapter;
    List<TuristicObject> lsObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid);
        // DRAW THE NAVIGATION
        DrawNav();
        // DRAW THE NAVIGATION
        Log.d(TAG, "onCreate: Started!!");

        Intent intent = getIntent();
        String name = intent.getStringExtra("stringName");
        String table = intent.getStringExtra("table");


        SeeDubrovnikDatabaseHellper helper;
        lsObjects = new ArrayList<>();
        lsMonuments = (RecyclerView) findViewById(R.id.monuments);
        lsMonuments.setHasFixedSize(true);
        lsMonuments.setLayoutManager(new LinearLayoutManager(this));

        Cursor ObjectsCursor;
        helper = new SeeDubrovnikDatabaseHellper(this);

        if (table != null) {
            ObjectsCursor = helper.getObjectsByTable(table);
        } else {
            ObjectsCursor = helper.getObjectsByName(name);
        }


        while (ObjectsCursor.moveToNext()) {
            TuristicObject el = new TuristicObject(ObjectsCursor.getString(0), name, ObjectsCursor.getString(1), ObjectsCursor.getString(2), ObjectsCursor.getString(3), ObjectsCursor.getInt(4), ObjectsCursor.getString(5));
            lsObjects.add(el);

        }

        lsMonumentsAdapter = new RecyclerViewListAdapter(this, lsObjects);
        lsMonuments.setAdapter(lsMonumentsAdapter);


    }


    public void makeToastLong(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void makeToastShort(String text) { Toast.makeText(this, text, Toast.LENGTH_SHORT).show(); }


    //----------###############################-----NAVBAR *start* -----------###############################---------------------------------
    public DrawerLayout mDrawerLayout;
    public ActionBarDrawerToggle mToggle;

    public void onClickStart(View view) {
        Intent intent = new Intent(this, PickDestination.class);
        startActivity(intent);
    }

    //Navbar DRAW *start*
    public void DrawNav() {
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
                        if (id == R.id.home) {
                            Directions.GoHome(getBaseContext());
                        }
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



