package com.example.pabtubes.tesquestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.pabtubes.R;

public class SecondQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        final RadioGroup g05_gr = (RadioGroup)findViewById(R.id.G05_Gr);
        final RadioGroup g06_gr = (RadioGroup)findViewById(R.id.G06_Gr);
        final RadioGroup g07_gr = (RadioGroup)findViewById(R.id.G07_Gr);
        final RadioGroup g08_gr = (RadioGroup)findViewById(R.id.G08_Gr);

        final RadioButton g05y = (RadioButton)findViewById(R.id.G05Y);
        final RadioButton g06y = (RadioButton)findViewById(R.id.G06Y);
        final RadioButton g07y = (RadioButton)findViewById(R.id.G07Y);
        final RadioButton g08y = (RadioButton)findViewById(R.id.G08Y);

        final RadioButton g05t = (RadioButton)findViewById(R.id.G05T);
        final RadioButton g06t = (RadioButton)findViewById(R.id.G06T);
        final RadioButton g07t = (RadioButton)findViewById(R.id.G07T);
        final RadioButton g08t = (RadioButton)findViewById(R.id.G08T);

        final TextView pktM = (TextView)findViewById(R.id.pktId);
        pktM.setText("");

        final Button cektipe = (Button)findViewById(R.id.cekTipe);
        cektipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cektipeIntent = new Intent(SecondQuestion.this, TypeQuestion.class);
                startActivity(cektipeIntent);
            }
        });

        Button BtCek = (Button)findViewById(R.id.cekBtn);
        BtCek.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String penyakit = "Diagnosis : \n";
                String aman = "Belum ada indikasi terkena Skizofrenia";
                String skizo = "Anda terkena Skizofrenia";
                //Rule15
                if (g05y.isChecked()&&g06y.isChecked()&&g07y.isChecked()&&g08y.isChecked()){
                    penyakit += " "+skizo;
                    cektipe.setVisibility(View.VISIBLE);

                }
                //Rule16
                if (g05y.isChecked()&&g06y.isChecked()&&g07y.isChecked()&&g08t.isChecked()){
                    penyakit += " "+skizo;
                    cektipe.setVisibility(View.VISIBLE);

                }
                //Rule17
                if (g05y.isChecked()&&g06y.isChecked()&&g07t.isChecked()&&g08y.isChecked()){
                    penyakit += " "+skizo;
                    cektipe.setVisibility(View.VISIBLE);

                }
                //Rule18
                if (g05y.isChecked()&&g06t.isChecked()&&g07y.isChecked()&&g08y.isChecked()){
                    penyakit += " "+skizo;
                    cektipe.setVisibility(View.VISIBLE);

                }
                //Rule19
                if (g05t.isChecked()&&g06y.isChecked()&&g07y.isChecked()&&g08y.isChecked()){
                    penyakit += " "+skizo;
                    cektipe.setVisibility(View.VISIBLE);

                }
                //Rule20
                if (g05y.isChecked()&&g06y.isChecked()&&g07t.isChecked()&&g08t.isChecked()){
                    penyakit += " "+skizo;
                    cektipe.setVisibility(View.VISIBLE);

                }
                //Rule21
                if (g05y.isChecked()&&g06t.isChecked()&&g07y.isChecked()&&g08t.isChecked()){
                    penyakit += " "+skizo;
                    cektipe.setVisibility(View.VISIBLE);

                }
                //Rule22
                if (g05y.isChecked()&&g06t.isChecked()&&g07t.isChecked()&&g08y.isChecked()){
                    penyakit += " "+skizo;
                    cektipe.setVisibility(View.VISIBLE);

                }
                //Rule23
                if (g05t.isChecked()&&g06y.isChecked()&&g07y.isChecked()&&g08t.isChecked()){
                    penyakit += " "+skizo;
                    cektipe.setVisibility(View.VISIBLE);

                }
                //Rule24
                if (g05t.isChecked()&&g06y.isChecked()&&g07t.isChecked()&&g08y.isChecked()){
                    penyakit += " "+skizo;
                    cektipe.setVisibility(View.VISIBLE);

                }
                //Rule25
                if (g05t.isChecked()&&g06t.isChecked()&&g07y.isChecked()&&g08y.isChecked()){
                    penyakit += " "+skizo;
                    cektipe.setVisibility(View.VISIBLE);

                }
                //no1
                if (g05t.isChecked()&&g06t.isChecked()&&g07t.isChecked()&&g08t.isChecked()){
                    penyakit += " "+aman;
                    cektipe.setVisibility(View.INVISIBLE);
                }
                //no2
                if (g05y.isChecked()&&g06t.isChecked()&&g07t.isChecked()&&g08t.isChecked()){
                    penyakit += " "+aman;
                    cektipe.setVisibility(View.INVISIBLE);
                }
                //no3
                if (g05t.isChecked()&&g06y.isChecked()&&g07t.isChecked()&&g08t.isChecked()){
                    penyakit += " "+aman;
                    cektipe.setVisibility(View.INVISIBLE);
                }
                //no4
                if (g05t.isChecked()&&g06t.isChecked()&&g07y.isChecked()&&g08t.isChecked()){
                    penyakit += " "+aman;
                    cektipe.setVisibility(View.INVISIBLE);
                }
                //no1
                if (g05t.isChecked()&&g06t.isChecked()&&g07t.isChecked()&&g08y.isChecked()){
                    penyakit += " "+aman;
                    cektipe.setVisibility(View.INVISIBLE);
                }
                pktM.setText(""+penyakit);

//                if (penyakit.equals(skizo)){
//                }

            }
        });
    }

}
