/*package hr.project.seedubrovnik;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class hometemp extends AppCompatActivity
        {
    private Set<Integer> green = new HashSet<>(Arrays.asList(12, 186, 40 ));
    private Set<Integer> blue = new HashSet<>(Arrays.asList(20, 4, 173));

    private ImageView map;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_start);
        DrawNav();
        addOnTuchListtener();

    }

    public void makeToastLong(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void makeToastShort(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


    public void addOnTuchListtener() {
        map = (ImageView) findViewById(R.id.mapPic);
        map.setDrawingCacheEnabled(true);
        map.buildDrawingCache(true);
        // LISTENER FOR MAPIMAGE
        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == android.view.MotionEvent.ACTION_UP){
                    bitmap = map.getDrawingCache();
                    int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());

                    Integer r = Color.red(pixel);
                    Integer g = Color.green(pixel);
                    Integer b = Color.blue(pixel);
                    TextView abus = (TextView) findViewById(R.id.about_us);
                    abus.setBackgroundColor(Color.rgb(r, g, b));

                    Set<Integer> pixColor = new HashSet<>(Arrays.asList(r, g, b));
                    for (Integer c : pixColor) {
                        System.out.println(c);
                    }

                    if (r.compareTo(g) > 0 && r.compareTo(b) > 0) {
                        makeToastShort("Crvena");
                        Intent intent = new Intent(WelcomeStartActivity.this, MidActivity.class);
                        intent.putExtra("stringName", "Old Town");
                        WelcomeStartActivity.this.startActivity(intent);
                    }

                }



                return true;

            }
        });

    }

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
// ------------------###############################-------------- NAVBAR*END* -------------------------###############################------------------------------------------------------

}

*/