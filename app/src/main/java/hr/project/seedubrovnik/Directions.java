package hr.project.seedubrovnik;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Directions extends AppCompatActivity {

    public static void GoHome(Context act) {
        Intent intent = new Intent(act, WelcomeStartActivity.class);
        act.startActivity(intent);

    }

    public static void GoDestinations(Context act) {
        Intent intent = new Intent(act, PickDestination.class);
        act.startActivity(intent);

    }

    public static void GoRestaurant(Context act) {
        Intent intent = new Intent(act, MidActivity.class);
        intent.putExtra("stringName", "restaurant");
        intent.putExtra("SelectedItem", "restaurant");
        act.startActivity(intent);

    }
}


