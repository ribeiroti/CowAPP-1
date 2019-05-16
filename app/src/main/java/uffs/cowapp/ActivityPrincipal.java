package uffs.cowapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import uffs.cowapp.place.PlaceCadActivity;

public class ActivityPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btnNewPlace = (Button) findViewById(R.id.activity_principal_btnNewPlace);


    }

    public void NewPlace(View v){
        Intent it = new Intent(this,PlaceCadActivity.class);
        startActivity(it);
    }


}
