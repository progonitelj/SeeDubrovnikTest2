package hr.project.seedubrovnik;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.Inflater;


public class HomeFragment extends Fragment {
    private static  final  String TAG ="HomeFragment";

   View view;
    private ImageView map;
    private Bitmap bitmap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //((WelcomeStartActivity)getActivity()).setmViewPager(); AKO ZELIMO ZVAT IZ FRAMENTA PROMJENU FRAGMENTA
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_home, container, false);
        addOnTuchListtener();
        return view;

    }
    public void addOnTuchListtener() {
        map = (ImageView) view.findViewById(R.id.map);

        map.setDrawingCacheEnabled(true);
        map.buildDrawingCache(true);
        // LISTENER FOR MAPIMAGE
        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == android.view.MotionEvent.ACTION_UP){
                    bitmap = map.getDrawingCache();
                    int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());

                    Integer r = Color.red(pixel);
                    Integer g = Color.green(pixel);
                    Integer b = Color.blue(pixel);
                    TextView abus = (TextView) getView().findViewById(R.id.about_us);
                    abus.setBackgroundColor(Color.rgb(r, g, b));

                    Set<Integer> pixColor = new HashSet<>(Arrays.asList(r, g, b));
                    for (Integer c : pixColor) {
                        System.out.println(c);
                    }

                    if (r.compareTo(g) > 0 && r.compareTo(b) > 0) {
                        makeToastShort("Crvena");

                    }

                }



                return true;

            }
        });

    }
    public void makeToastLong(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
    }

    public void makeToastShort(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

}

