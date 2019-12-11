package com.example.pabtubes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

//cek
public class home extends AppCompatActivity implements View.OnClickListener {
    private CardView tesCard, infoCard, skizoCard, penangananCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tesCard = (CardView) findViewById(R.id.tes_card);
//        infoCard = (CardView) findViewById(R.id.info_card);
        skizoCard = (CardView) findViewById(R.id.skizo_card);
        penangananCard = (CardView) findViewById(R.id.penanganan_card);

        tesCard.setOnClickListener(this);
//        infoCard.setOnClickListener(this);
        skizoCard.setOnClickListener(this);
        penangananCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.tes_card : i =new Intent(this, TesActivity.class);startActivity(i);break;
//            case R.id.info_card : i = new Intent(this,InfoActivity.class);startActivity(i);break;
            case R.id.skizo_card : i = new Intent(this, SkizoActivity.class);startActivity(i);break;
            case R.id.penanganan_card : i = new Intent(this, PenangananActivity.class);startActivity(i);break;
            default:break;
        }
    }
}
