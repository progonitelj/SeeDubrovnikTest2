package hr.project.seedubrovnik;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MidActivity extends AppCompatActivity {
    //Navbar include *start*
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    //Navbar include *end*
    private static final String TAG = "MidActivity";

    RecyclerView lsMonuments;
    RecyclerViewListAdapterTur lsMonumentsAdapter;
    List<TuristicObject> lsObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid);
        Log.d(TAG, "onCreate: Started!!");

        Intent intent = getIntent();
        String name = intent.getStringExtra("stringName");

        SeeDubrovnikDatabaseHellper helper;
        lsObjects = new ArrayList<>();
        lsMonuments = (RecyclerView) findViewById(R.id.monuments);
        lsMonuments.setHasFixedSize(true);
        lsMonuments.setLayoutManager(new LinearLayoutManager(this));


        helper = new SeeDubrovnikDatabaseHellper(this);
        Cursor ObjectsCursor = helper.getObjectsOf(name);
        while (ObjectsCursor.moveToNext()){
            TuristicObject el= new TuristicObject(ObjectsCursor.getString(0), name, ObjectsCursor.getString(1), ObjectsCursor.getString(2), ObjectsCursor.getInt(3), ObjectsCursor.getString(4));
            lsObjects.add(el);

            }

        lsMonumentsAdapter = new RecyclerViewListAdapterTur(this, lsObjects);
        lsMonuments.setAdapter(lsMonumentsAdapter);

        //Navbar prepare *start*
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Navbar prepare *end*




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



