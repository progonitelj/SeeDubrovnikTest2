package hr.project.seedubrovnik;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MidActivity extends AppCompatActivity {

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
            TuristicObject ob2 = new TuristicObject("Minceta", name, "Biggest fort in Dubrovnik Old town", "Sight-seeing", R.drawable.miceta_icon, mincetraGeo);
            TuristicObject ob3 = new TuristicObject("Revelin", name, "Fort/Night club", "Sight-seeing",  R.drawable.revelin_icon, revelinGeo);
            TuristicObject ob4 = new TuristicObject("Sv  Ivan", name, "Fort in the old port of Dubrovnik", "Sight-seeing",   + R.drawable.svivan_icon, svIvanGeo);
            TuristicObject ob5 = new TuristicObject("Bokar", name, "Fort close to Pile gate", "Sight-seeing",  R.drawable.bokar_icon, bokarGeo);
            //TuristicObject ob6 = new TuristicObject("Buza", "Old Town", "A bar with beatifful view", "drawable://" + R.drawable.buza_icon);
            TuristicObject ob7 = new TuristicObject("Stradun", name, "Main street of Dubrovnik", "Sight-seeing",   + R.drawable.stradun_ico, stradunGeo);
            TuristicObject ob8 = new TuristicObject("Sv Vlaho", name, "Chirch of Dubrovnik protector", "Sight-seeing",  R.drawable.sv_vlaho_icon, svVlahogeo);
            //TuristicObject ob9 = new TuristicObject("Katedrala", "Old Town", "Main chirch of Dubrovnik", "drawable://" + R.drawable.sv_vlaho_icon);
            //TuristicObject ob10 = new TuristicObject("Knezev dvor", "Old Town", "House od Dubrovnik landlords", "drawable://" + R.drawable.knezevdvor_icon);
            //TuristicObject ob11 = new TuristicObject("Palaca Sponza", "Old Town", "Something", "drawable://" + R.drawable.sponza_icon);
            //TuristicObject ob12 = new TuristicObject("Porporela", "Old Town", "Old port of Dubrovnik", "drawable://" + R.drawable.svivan_icon);
            //TuristicObject ob13 = new TuristicObject("Lokrum", "Old Town", "Island near by Dubrovnik", "drawable://" + R.drawable.lokrum_icon);
            //TuristicObject ob14 = new TuristicObject("Pile", "Pile", "West Entrance to old Town", "drawable://" + R.drawable.bokar_icon);
            //TuristicObject ob15 = new TuristicObject("Kolocep", "Elafiti", "First of elafiti collection of islands", "drawable://" + R.drawable.kolocep);




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
}
