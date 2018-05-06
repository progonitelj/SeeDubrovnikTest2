package hr.project.seedubrovnik;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Bottom_Activity extends AppCompatActivity {

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_);
        final Intent intent = getIntent();

        name = intent.getStringExtra("stringName");
        TextView tvName = (TextView) findViewById(R.id.textime);
        tvName.setText(name);

        final String geo = intent.getStringExtra("geo");
        ImageButton bLocation = (ImageButton) findViewById(R.id.location);
        bLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + geo + "&mode=w"));
                    intent.setPackage("com.google.android.apps.maps");
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + geo + "?q=" + name ));
                    intent.setPackage("com.google.android.apps.maps");
                    startActivity(intent);
                }

            }
        });

        String descript = intent.getStringExtra("desc");
        TextView tvDescript = (TextView) findViewById(R.id.descript);
        tvDescript.setText(descript);

        final String pot = intent.getStringExtra("pot");
        //TextView tvPot = (TextView) findViewById(R.id.pot);
        //tvPot.setText(pot);


        int image = getIntent().getExtras().getInt("img");
        ImageView ivImage = (ImageView) findViewById(R.id.endimage);
        ivImage.setImageResource(image);

        DrawNav();

        ImageButton back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bottom_Activity.this, MidActivity.class);
                intent.putExtra("stringName", pot);
                startActivity(intent);
            }
        });
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public void makeToastLong(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void makeToastShort(String text){
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
