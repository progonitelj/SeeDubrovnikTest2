package hr.project.seedubrovnik;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Directions {

    public static void GoHome(Context act) {
        Intent intent = new Intent(act, WelcomeStartActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        act.startActivity(intent);

    }

    public static void GoDestinations(Context act) {
        Intent intent = new Intent(act, PickDestination.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        act.startActivity(intent);

    }

    public static void GoRestaurant(Context act) {
        Intent intent = new Intent(act, MidActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("table", "restaurants");

        act.startActivity(intent);

    }
}


