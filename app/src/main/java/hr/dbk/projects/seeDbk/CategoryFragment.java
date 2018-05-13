package hr.dbk.projects.seeDbk;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private RecyclerViewListAdapter2 adapter;
    private List<Category> categories;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "evo nas u blankui", Toast.LENGTH_LONG);
        view = inflater.inflate(R.layout.fragment_categories_layout, container, false);
        fillRecyclerView();

        return view;
    }


    public void fillRecyclerView() {
        recyclerView = view.findViewById(R.id.RecyclerView1);
        categories = new ArrayList<>();
        categories.add(new Category("Atractions", "Find all atractions around DBK!", R.drawable.img_atraction));
        categories.add(new Category("Beaches", "Refresh your self on a beatiful beach!", R.drawable.img_beach));
        categories.add(new Category("Drinks", "Find a place to relax and have a drink!", R.drawable.img_food));
        categories.add(new Category("Food", "All best places to eat in dubrovnik!", R.drawable.img_drink));
        categories.add(new Category("Emergencies", "Find all atractions around DBK!", R.drawable.img_transport));
        categories.add(new Category("Transport", "Find all atractions around DBK!", R.drawable.img_emergency));
        GridLayoutManager menager = new GridLayoutManager(getActivity(), 2);
        adapter = new RecyclerViewListAdapter2(getActivity(), categories);
        recyclerView.setLayoutManager(menager);
        recyclerView.setAdapter(adapter);

    }


    public void makeToastLong(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
    }

    public void makeToastShort(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

}
