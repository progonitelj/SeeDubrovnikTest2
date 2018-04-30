package hr.project.seedubrovnik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Bottom_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_);
        Intent intent = getIntent();

        String descript = intent.getStringExtra("desc");
        TextView tvDescript = (TextView) findViewById(R.id.descript);
        tvDescript.setText(descript);

        String pot = intent.getStringExtra("pot");
        TextView tvPot = (TextView) findViewById(R.id.pot);
        tvPot.setText(pot);

        String name = intent.getStringExtra("stringName");
        TextView tvName = (TextView) findViewById(R.id.textime);
        tvName.setText(name);


        int image = getIntent().getExtras().getInt("img");
        ImageView ivImage = (ImageView) findViewById(R.id.endimage);
        ivImage.setImageResource(image);
    }




    public void makeToastLong(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void makeToastShort(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


}
