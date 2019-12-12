package com.example.pabtubes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
<<<<<<< HEAD
import android.widget.ListView;
import android.widget.RadioButton;
=======
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
>>>>>>> 5bdf156dcd82747bc488273929aeed6a42f7f915
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pabtubes.tesquestion.SecondQuestion;

//ada 3 class yang digunakan pada TesActivity (TesActivity, AdapterGejala, Model)
//2 layout(activity_test dan baris)
public class TesActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes);

        final RadioGroup g01_gr = (RadioGroup)findViewById(R.id.G01_Gr);
        final RadioGroup g02_gr = (RadioGroup)findViewById(R.id.G02_Gr);
        final RadioGroup g03_gr = (RadioGroup)findViewById(R.id.G03_Gr);
        final RadioGroup g04_gr = (RadioGroup)findViewById(R.id.G04_Gr);

<<<<<<< HEAD
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView label =(TextView) view.getTag(R.id.label);
        RadioButton radioButtony = (RadioButton) view.getTag(R.id.yesChoice);
        RadioButton radioButtont = (RadioButton) view.getTag(R.id.noChoice);
//        CheckBox checkBox = (CheckBox) view.getTag(R.id.checkB);
        Toast.makeText(view.getContext(), label.getText().toString()+""+isCheckedOrNot(radioButtony), Toast.LENGTH_LONG).show();
        Toast.makeText(view.getContext(), label.getText().toString()+""+isCheckedOrNot(radioButtont), Toast.LENGTH_LONG).show();

    }
    private String isCheckedOrNot(RadioButton radioButtony) {
        if(radioButtony.isChecked())
            return "is checked";
        else
            return "is not checked";
=======
        final RadioButton g01y = (RadioButton)findViewById(R.id.G01Y);
        final RadioButton g02y = (RadioButton)findViewById(R.id.G02Y);
        final RadioButton g03y = (RadioButton)findViewById(R.id.G03Y);
        final RadioButton g04y = (RadioButton)findViewById(R.id.G04Y);

        final RadioButton g01t = (RadioButton)findViewById(R.id.G01T);
        final RadioButton g02t = (RadioButton)findViewById(R.id.G02T);
        final RadioButton g03t = (RadioButton)findViewById(R.id.G03T);
        final RadioButton g04t = (RadioButton)findViewById(R.id.G04T);

        final TextView penyakitM = (TextView)findViewById(R.id.penyakitId);
        penyakitM.setText("");


        Button BtLanjut = (Button)findViewById(R.id.lanjutBtn);
        BtLanjut.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String penyakit = "Diagnosis : \n";
                String aman = "Belum ada indikasi terkena Skizofrenia";
                String skizo = "Anda terkena Skizofrenia";
                if (g01y.isChecked()&&g02y.isChecked()&&g03y.isChecked()&&g04y.isChecked()){
                    penyakit += " "+skizo;

                }
                if (g01y.isChecked()&&g02y.isChecked()&&g03y.isChecked()&&g04t.isChecked()){
                    penyakit += " "+skizo;

                }

                if (g01y.isChecked()&&g02y.isChecked()&&g03t.isChecked()&&g04y.isChecked()){
                    penyakit += " "+skizo;

                }

                if (g01y.isChecked()&&g02t.isChecked()&&g03y.isChecked()&&g04y.isChecked()){
                    penyakit += " "+skizo;

                }

                if (g01y.isChecked()&&g02y.isChecked()&&g03t.isChecked()&&g04t.isChecked()){
                    penyakit += " "+skizo;

                }
                //Rule6
                if (g01y.isChecked()&&g02t.isChecked()&&g03y.isChecked()&&g04t.isChecked()){
                    penyakit += " "+skizo;
                }
                //Rule7
                if (g01y.isChecked()&&g02t.isChecked()&&g03t.isChecked()&&g04y.isChecked()){
                    penyakit += " "+skizo;
                }
                //Rule8
                if (g01t.isChecked()&&g02y.isChecked()&&g03y.isChecked()&&g04t.isChecked()){
                    penyakit += " "+skizo;
                }
                //Rule9
                if (g01t.isChecked()&&g02y.isChecked()&&g03t.isChecked()&&g04y.isChecked()){
                    penyakit += " "+skizo;
                }

                //Rule10
                if (g01t.isChecked()&&g02t.isChecked()&&g03y.isChecked()&&g04y.isChecked()){
                    penyakit += " "+skizo;
                }
                //Rule11
                if (g01y.isChecked()&&g02t.isChecked()&&g03t.isChecked()&&g04t.isChecked()){
                    penyakit += " "+skizo;
                }
                //Rule12
                if (g01t.isChecked()&&g02y.isChecked()&&g03t.isChecked()&&g04t.isChecked()){
                    penyakit += " "+skizo;
                }
                //Rule13
                if (g01t.isChecked()&&g02t.isChecked()&&g03y.isChecked()&&g04t.isChecked()){
                    penyakit += " "+skizo;
                }
                //Rule14
                if (g01t.isChecked()&&g02t.isChecked()&&g03t.isChecked()&&g04y.isChecked()){
                    penyakit += " "+skizo;
                }
                //no
                if (g01t.isChecked()&&g02t.isChecked()&&g03t.isChecked()&&g04t.isChecked()){
                    penyakit += " "+aman;
                }
                penyakitM.setText(""+penyakit);

                if (penyakit == skizo && penyakit != aman) {
                }

            }
        });
>>>>>>> 5bdf156dcd82747bc488273929aeed6a42f7f915
    }

    public void lanjutSecond(View view) {
            startActivity(new Intent(this, SecondQuestion.class));
    }
}
