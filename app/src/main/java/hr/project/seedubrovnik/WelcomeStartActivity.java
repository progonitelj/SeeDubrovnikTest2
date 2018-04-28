package hr.project.seedubrovnik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_start);
    }


    public void onClickStart(View view){
        Intent intent = new Intent(this, PickDestination.class);
        startActivity(intent);
    }
}
