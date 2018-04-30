package hr.project.seedubrovnik;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Bottom_Activity extends AppCompatActivity {
    //Navbar include *start*
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    //Navbar include *end*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_);
        Intent intent = getIntent();

        String descript = intent.getStringExtra("desc");
        TextView tvDescript = (TextView) findViewById(R.id.descript);
        tvDescript.setText(descript);

        String pot = intent.getStringExtra("pot");
        TextView tvPot = (TextView) findViewById(R.id.pot);
        tvPot.setText(pot);

        String name = intent.getStringExtra("stringName");
        TextView tvName = (TextView) findViewById(R.id.textime);
        tvName.setText(name);


        int image = getIntent().getExtras().getInt("img");
        ImageView ivImage = (ImageView) findViewById(R.id.endimage);
        ivImage.setImageResource(image);

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
