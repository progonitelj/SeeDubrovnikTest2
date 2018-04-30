package hr.project.seedubrovnik;

import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class PickDestination extends AppCompatActivity {

    private static final String TAG = "PickDestination";
    RecyclerView recyclerView;
    RecyclerViewListAdapter lsViewAdapter;
    List<PartsOfTown> lsPartsOfTown;
    //Navbar include *start*
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    //Navbar include *end*


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_destination);
        Log.d(TAG, "onCreate: Started!! ");
        SeeDubrovnikDatabaseHellper helper;
        lsPartsOfTown = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        try {
            helper = new SeeDubrovnikDatabaseHellper(this);
            Log.d(TAG, "onCreate: database connected!");
            makeToastShort("Connected to database!");
            Cursor locationsCursor = helper.getLocations();
            Log.d(TAG, "onCreate:got locations!!");
            while (locationsCursor.moveToNext()){
                PartsOfTown el= new PartsOfTown(locationsCursor.getString(1), locationsCursor.getInt(4), locationsCursor.getString(3));
                lsPartsOfTown.add(el);

            }
        }catch (SQLException e){
            makeToastShort("Can not connect to database!");
        }

        //Navbar prepare *start*
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Navbar prepare *end*





        /*PartsOfTown p1 = new PartsOfTown("Old Town", R.drawable.oldtown_icon, "The old town of Dubrovnik");
        PartsOfTown p2 = new PartsOfTown("Lapad", R.drawable.lapad_icon, "Urban Part of Dubrovnik");
        PartsOfTown p3 = new PartsOfTown("Gruz", R.drawable.gruz_icon, "Urban part of dubrovnik/port");
        PartsOfTown p4 = new PartsOfTown("Kolocep", R.drawable.kolocep, "First Elafiti island");
        PartsOfTown p5 = new PartsOfTown("Cavatat", R.drawable.cavtat_icon, "Small Town close to Dubrovnik");
        PartsOfTown p6 = new PartsOfTown("Lokrum", R.drawable.lokrum_icon, "Small island close to Dubrovnik");


        lsPartsOfTown.add(p1);
        lsPartsOfTown.add(p2);
        lsPartsOfTown.add(p3);
        lsPartsOfTown.add(p4);
        lsPartsOfTown.add(p5);
        lsPartsOfTown.add(p6);


*/







        lsViewAdapter = new RecyclerViewListAdapter(this, lsPartsOfTown);
        recyclerView.setAdapter(lsViewAdapter);

    }
    //Navbar hamburger icon function *start*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //Navbar hamburger icon function *start*


    public void makeToastLong(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void makeToastShort(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
