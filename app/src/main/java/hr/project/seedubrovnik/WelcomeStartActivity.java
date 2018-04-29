package hr.project.seedubrovnik;

import android.content.Intent;
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

public class WelcomeStartActivity extends AppCompatActivity {
    //Navbar include *start*
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    //Navbar include *end*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_start);

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


    public void onClickStart(View view) {
        Intent intent = new Intent(this, PickDestination.class);
        startActivity(intent);
    }
}
