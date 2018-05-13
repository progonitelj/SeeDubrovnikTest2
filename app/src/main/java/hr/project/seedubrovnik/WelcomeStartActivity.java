package hr.project.seedubrovnik;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class WelcomeStartActivity  extends AppCompatActivity {
private ViewPager mViewPager;
FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        fragmentPagerAdapter  = new FragmentPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);


    }

    private void setupViewPager(ViewPager viewPager){
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(),"HomeFragment");
        adapter.addFragment(new CategoryFragment(),"CategoryFragment");
        viewPager.setAdapter(adapter);
    }
    public void setmViewPager(int fragmentNumber ){
        mViewPager.setCurrentItem(fragmentNumber);

    }

}

