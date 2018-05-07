package hr.project.seedubrovnik;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WelcomeStartActivity extends AppCompatActivity {
    private ImageView map;
    private Bitmap bitmap;
    RecyclerView recyclerView;
    RecyclerViewListAdapter2 adapter;
    List<PartsOfTown> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_start);
        DrawNav();
        list = new ArrayList<>();
        list.add(new PartsOfTown("Food", R.drawable.hrana,"Get relavant areas"));
        list.add(new PartsOfTown("Beaches", R.drawable.plaza,"Get relavant areas"));
        list.add(new PartsOfTown("Transport", R.drawable.autobus,"Get relavant areas"));
        list.add(new PartsOfTown("Monuments", R.drawable.tample,"Get relavant areas"));
        list.add(new PartsOfTown("Drinks", R.drawable.map_icon,"Get relavant areas"));
        list.add(new PartsOfTown("Emergencies", R.drawable.map_icon,"Get relavant areas"));

        adapter = new RecyclerViewListAdapter2(this, list);
        GridLayoutManager menager = new GridLayoutManager(this, 2);
        recyclerView = findViewById(R.id.RecyclerView3);
        recyclerView.setLayoutManager(menager);
        recyclerView.setAdapter(adapter);

        map = (ImageView) findViewById(R.id.map);
        map.setDrawingCacheEnabled(true);
        map.buildDrawingCache(true);
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


    public void makeToastLong(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void makeToastShort(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
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
// ------------------###############################-------------- NAVBAR*END* -------------------------###############################------------------------------------------------------

}


