package hr.dbk.projects.seeDbk;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Objects;


public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";
    private ViewPager mViewPager;
    FragmentPagerAdapter fragmentPagerAdapter;
    Menu menu;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(mViewPager);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.botNavbar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                menu = bottomNavigationView.getMenu();
                MenuItem menuItem = menu.getItem(position);
                menuItem.setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        setmViewPager(0);
                        break;

                    case R.id.categories:
                        setmViewPager(1);
                        break;

                    case R.id.search:
                        break;

                    case R.id.info:
                        setmViewPager(0);

                }
                return true;
            }
        });


    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "HomeFragment");
        adapter.addFragment(new CategoryFragment(), "CategoryFragment");
        viewPager.setAdapter(adapter);
    }

    public void setmViewPager(int fragmentNumber) {
        mViewPager.setCurrentItem(fragmentNumber);

    }

}
