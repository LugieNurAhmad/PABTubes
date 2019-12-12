package com.example.pabtubes.tesquestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.pabtubes.R;

public class TypeQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_question);

        final RadioButton g09y = (RadioButton)findViewById(R.id.G09Y);
        final RadioButton g010y = (RadioButton)findViewById(R.id.G010Y);
        final RadioButton g011y = (RadioButton)findViewById(R.id.G011Y);
        final RadioButton g012y = (RadioButton)findViewById(R.id.G012Y);
        final RadioButton g013y = (RadioButton)findViewById(R.id.G013Y);
        final RadioButton g014y = (RadioButton)findViewById(R.id.G014Y);
        final RadioButton g015y = (RadioButton)findViewById(R.id.G015Y);
        final RadioButton g016y = (RadioButton)findViewById(R.id.G016Y);
        final RadioButton g017y = (RadioButton)findViewById(R.id.G017Y);
        final RadioButton g018y = (RadioButton)findViewById(R.id.G018Y);
        final RadioButton g019y = (RadioButton)findViewById(R.id.G019Y);
        final RadioButton g020y = (RadioButton)findViewById(R.id.G020Y);
        final RadioButton g021y = (RadioButton)findViewById(R.id.G021Y);
        final RadioButton g022y = (RadioButton)findViewById(R.id.G022Y);
        final RadioButton g023y = (RadioButton)findViewById(R.id.G023Y);
        final RadioButton g024y = (RadioButton)findViewById(R.id.G024Y);
        final RadioButton g025y = (RadioButton)findViewById(R.id.G025Y);
        final RadioButton g026y = (RadioButton)findViewById(R.id.G026Y);
        final RadioButton g027y = (RadioButton)findViewById(R.id.G027Y);
        final RadioButton g028y = (RadioButton)findViewById(R.id.G028Y);
        final RadioButton g029y = (RadioButton)findViewById(R.id.G029Y);
        final RadioButton g030y = (RadioButton)findViewById(R.id.G030Y);
        final RadioButton g031y = (RadioButton)findViewById(R.id.G031Y);
        final RadioButton g032y = (RadioButton)findViewById(R.id.G032Y);


        final RadioButton g09t = (RadioButton)findViewById(R.id.G09T);
        final RadioButton g010t = (RadioButton)findViewById(R.id.G010T);
        final RadioButton g011t = (RadioButton)findViewById(R.id.G011T);
        final RadioButton g012t = (RadioButton)findViewById(R.id.G012T);
        final RadioButton g013t = (RadioButton)findViewById(R.id.G013T);
        final RadioButton g014t = (RadioButton)findViewById(R.id.G014T);
        final RadioButton g015t = (RadioButton)findViewById(R.id.G015T);
        final RadioButton g016t = (RadioButton)findViewById(R.id.G016T);
        final RadioButton g017t = (RadioButton)findViewById(R.id.G017T);
        final RadioButton g018t = (RadioButton)findViewById(R.id.G018T);
        final RadioButton g019t = (RadioButton)findViewById(R.id.G019T);
        final RadioButton g020t = (RadioButton)findViewById(R.id.G020T);
        final RadioButton g021t = (RadioButton)findViewById(R.id.G021T);
        final RadioButton g022t = (RadioButton)findViewById(R.id.G022T);
        final RadioButton g023t = (RadioButton)findViewById(R.id.G023T);
        final RadioButton g024t = (RadioButton)findViewById(R.id.G024T);
        final RadioButton g025t = (RadioButton)findViewById(R.id.G025T);
        final RadioButton g026t = (RadioButton)findViewById(R.id.G026T);
        final RadioButton g027t = (RadioButton)findViewById(R.id.G027T);
        final RadioButton g028t = (RadioButton)findViewById(R.id.G028T);
        final RadioButton g029t = (RadioButton)findViewById(R.id.G029T);
        final RadioButton g030t = (RadioButton)findViewById(R.id.G030T);
        final RadioButton g031t = (RadioButton)findViewById(R.id.G031T);
        final RadioButton g032t = (RadioButton)findViewById(R.id.G032T);

        final TextView penyakitM = (TextView)findViewById(R.id.penyakitId);
        penyakitM.setText("");


        Button diag = (Button)findViewById(R.id.cekBtnType);
        diag.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String penyakit = "Diagnosis : \n";
                String aman = "Belum ada indikasi terkena Skizofrenia";
                String tipeParanoid = "Anda terkena Skizofrenia Paranoid";
                String tipeHeberefenik = "Anda terkena Skizofrenia Hebrefenik";
                String tipeKatatonik = "Anda terkena Skizofrenia Katatonik";
                String tipeTer = "Anda terkena Skizofrenia Tak terinnci";
                String tipeResidual = "Anda terkena Skizofrenia Residual";
                String tipeSimpleks = "Anda terkena Skizofrenia Simpleks";
                String tipePasca = "Anda terkena Depresi Pasca Skizofrenial";
                //rule 26
                if (g09y.isChecked()&&g010y.isChecked()&&g011y.isChecked()&&g012y.isChecked()){
                    penyakit += " "+tipeParanoid;
                }
                //rule 27
                if (g013y.isChecked()&&g014y.isChecked()){
                    penyakit += " "+tipeHeberefenik;
                }
                //rule 28
                if (g015y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 29
                if (g016y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 30
                if (g017y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 31
                if (g018y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 32
                if (g019y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 33
                if (g020y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 34
                if (g021y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 29 - 34
                if (g015y.isChecked()||g016y.isChecked()||g017y.isChecked()||g018y.isChecked()
                        ||g019y.isChecked()||g020y.isChecked()||g021y.isChecked()){

                    penyakit += " "+tipeKatatonik;
                }
                //rule 35
                if (g015y.isChecked()&&g016y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 36
                if (g015y.isChecked()&&g017y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 37
                if (g015y.isChecked()&&g018y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 38
                if (g015y.isChecked()&&g019y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 39
                if (g015y.isChecked()&&g020y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 40
                if (g015y.isChecked()&&g021y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //rule 41
                if (g016y.isChecked()&&g017y.isChecked()){
                    penyakit += " "+tipeKatatonik;
                }
                //no
//                if (g01t.isChecked()&&g02t.isChecked()&&g03t.isChecked()&&g04t.isChecked()){
//                    penyakit += " "+aman;
//                }
                penyakitM.setText(""+penyakit);

            }
        });
    }
}
