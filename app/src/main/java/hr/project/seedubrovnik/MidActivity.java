package hr.project.seedubrovnik;

import android.content.Intent;
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

        //Navbar prepare *start*
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Navbar prepare *end*

        lsObjects = new ArrayList<>();

        Log.d(TAG, "onCreate: TuristObjects List Created!!");
        lsMonuments = (RecyclerView) findViewById(R.id.monuments);
        Log.d(TAG, "onCreate: RecyclerView binded to id!");
        lsMonuments.setHasFixedSize(true);
        lsMonuments.setLayoutManager(new LinearLayoutManager(this));

        Log.d(TAG, "onCreate: RecyclerView created!");


        if(name.equals("Old Town")){
            String stradunUri = "geo:0,0?q=Stradun, Croatia";
            Uri stradunGeo = Uri.parse(stradunUri);

            String svVlahoUri = "geo:0,0?q=Crkva svetog Vlaha,Luža ul. 2, 20000, Dubrovnik, Croatia";
            Uri svVlahogeo = Uri.parse(svVlahoUri);

            String mincetaUri =  "geo:0,0?q=Tvrđava Minčeta,Ul. Ispod Minčete 9, 20000, Dubrovnik,g Croatia";
            Uri mincetraGeo = Uri.parse(mincetaUri);


            String revelinUri =  "geo:0,0?q=Culture club Revelin, Ul. Svetog Dominika 3, 20000, Dubrovnik, Croatia";
            Uri revelinGeo = Uri.parse(revelinUri);

            String svIvanUri =  "geo:0,0?q=Tvrđava Sv. Ivana, 20000, Dubrovnik, Croatia";
            Uri svIvanGeo = Uri.parse(svIvanUri);

            String bokarUri =  "geo:0,0?q=Tvrđava Bokar, Od Puća 20, 20000, Dubrovnik, Croatia";
            Uri bokarGeo = Uri.parse(bokarUri);


            //TuristicObject ob1 = new TuristicObject("Zidine", "Old Town", "Wallz sorounding old town", "drawable://" + R.drawable.zidine_icon, );
            TuristicObject ob2 = new TuristicObject("Minceta", name, "It is a large circular tower with a massive battlement suspended by stone sup-porters.The first, smaller, quadrangular tower was constructed by Nikifor Ranjina in 1319. The Florentine architect Michelozzo Michelozzi gave the monumental present time form to the Fort, which was completed in 1464 according to the design of the renowned Renaissance builder Juraj Dalmatinac.", "Sight-seeing", R.drawable.miceta_icon, mincetraGeo);
            TuristicObject ob3 = new TuristicObject("Revelin", name, "Revelin Fort was built outside the city walls and is partially included into the defence complex of the Ploče Gate. The lower part of the fort was built in 1463, in the shape the City model held by St. Blaise on the triptych painted by Nikola Božidarević around 1500. The fort protected both the eastern part of the City from mainland and the entrance to the City Harbour.", "Sight-seeing",  R.drawable.revelin_icon, revelinGeo);
            TuristicObject ob4 = new TuristicObject("Sv  Ivan", name, "Fort in the old port of Dubrovnik", "Sight-seeing",   + R.drawable.svivan_icon, svIvanGeo);
            TuristicObject ob5 = new TuristicObject("Bokar", name, "Fort close to Pile gate", "Sight-seeing",  R.drawable.bokar_icon, bokarGeo);
            //TuristicObject ob6 = new TuristicObject("Buza", "Old Town", "A bar with beatifful view", "drawable://" + R.drawable.buza_icon);
            TuristicObject ob7 = new TuristicObject("Stradun", name, "Main street of Dubrovnik. Stradun iz around 300 mete long. The site of the present-day street used to be a marshy channel which separated Ragusa from the forest settlement of Dubrava before it was reclaimed in the 13th century.  Stradun stretches through the walled town in the east-west direction, connecting the western entrance called the \"Pile Gate\" (Vrata od Pila) to the \"Ploče Gate\" (Vrata od Ploča) on the eastern end. Both ends are also marked with 15th-century fountains (the so-called Large Onofrio's Fountain in the western section and the Small Onofrio's Fountain on the east end) and bell towers (the Dubrovnik Bell Tower to the east end and the bell tower attached to the Franciscan monastery to the west).", "Sight-seeing",   + R.drawable.stradun_ico, stradunGeo);
            TuristicObject ob8 = new TuristicObject("Sv Vlaho", name, "The Church of St. Blaise  is a Baroque church in Dubrovnik and one of the city's major sights. Saint Blaise (St. Vlaho), identified by medieval Slavs with the pagan god Veles, is the patron saint of the city of Dubrovnik and formerly the protector of the independent Republic of Ragusa.", "Sight-seeing",  R.drawable.sv_vlaho_icon, svVlahogeo);
            //TuristicObject ob9 = new TuristicObject("Katedrala", "Old Town", "Main chirch of Dubrovnik", "drawable://" + R.drawable.sv_vlaho_icon);
            //TuristicObject ob10 = new TuristicObject("Knezev dvor", "Old Town", "House od Dubrovnik landlords", "drawable://" + R.drawable.knezevdvor_icon);
            //TuristicObject ob11 = new TuristicObject("Palaca Sponza", "Old Town", "Something", "drawable://" + R.drawable.sponza_icon);
            //TuristicObject ob12 = new TuristicObject("Porporela", "Old Town", "Old port of Dubrovnik", "drawable://" + R.drawable.svivan_icon);
            //TuristicObject ob13 = new TuristicObject("Lokrum", "Old Town", "Island near by Dubrovnik", "drawable://" + R.drawable.lokrum_icon);
            //TuristicObject ob14 = new TuristicObject("Pile", "Pile", "West Entrance to old Town", "drawable://" + R.drawable.bokar_icon);





            lsObjects.add(ob2);
            lsObjects.add(ob3);
            lsObjects.add(ob4);
            lsObjects.add(ob5);
            lsObjects.add(ob7);
            lsObjects.add(ob8);

        }


lsMonumentsAdapter = new RecyclerViewListAdapterTur(this, lsObjects);
lsMonuments.setAdapter(lsMonumentsAdapter);








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



