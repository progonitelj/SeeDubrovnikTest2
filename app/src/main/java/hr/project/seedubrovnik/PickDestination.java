package hr.project.seedubrovnik;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

        try {
            SQLiteOpenHelper seeDubrovnikSQLHelper = new SeeDubrovnikDatabaseHellper(this);
            SQLiteDatabase db = seeDubrovnikSQLHelper.getReadableDatabase();
        }catch (SQLException e){
            Toast error = Toast.makeText(this, "DATABASE OPENING FAILED!!!", Toast.LENGTH_SHORT);
            error.show();
        }

        //Navbar prepare *start*
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Navbar prepare *end*


        lsPartsOfTown = new ArrayList<>();

        Log.d(TAG, "onCreate: TuristObjects List Created!!");
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView1);
        Log.d(TAG, "onCreate: RecyclerView binded to id!");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.d(TAG, "onCreate: RecyclerView created!");



        PartsOfTown p1 = new PartsOfTown("Old Town", R.drawable.oldtown_icon, "The old town of Dubrovnik");
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
}
