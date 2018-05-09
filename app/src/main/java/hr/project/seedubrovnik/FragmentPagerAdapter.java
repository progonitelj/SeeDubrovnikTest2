package hr.project.seedubrovnik;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {
    private  final List<Fragment> mFragmentList=new ArrayList<>();
    private  final List<String> mFragmentTitleList=new ArrayList<>();
    public FragmentPagerAdapter(FragmentManager fm) {



        super(fm);
    }
   public void addFragment(Fragment fragment,String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);

    }
    @Override
    public Fragment getItem(int position) {


        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }





}