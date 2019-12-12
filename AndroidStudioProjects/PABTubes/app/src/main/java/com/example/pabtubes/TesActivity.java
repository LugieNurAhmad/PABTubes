package com.example.pabtubes;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

//ada 3 class yang digunakan pada TesActivity (TesActivity, AdapterGejala, Model)
//2 layout(activity_test dan baris)
public class TesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter<Model> adapter;
    List<Model> list = new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes);

        listView = (ListView) findViewById(R.id.gejala);
        adapter = new AdapterGejala(this,getModel());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

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
    }

    private List<Model> getModel() {
        list.add(new Model("1. Apakah pasien sering mengalami isi pikiran yang berulang? atau merasa isi pikirannya tersiar ke luar sehingga orang lain atau umum mengetahuinya? atau merasa isi pikiran yang asing dari luar masuk ke dalam pikirannya ?"));
        list.add(new Model("2. Apakah pasien merasa dirinya dikendalikan, dipengaruhi atau merasa tidak berdaya terhdapat suatu kekuatan tertentu dari luar?"));
        list.add(new Model("3. Apakah pasien sering berhalusinasi (mendengar suara-suara yang mendiskusikan tentang si pasien sendiri) ?"));
        list.add(new Model("4. Apakah perilaku pasien dianggap sesuatu yang tidak wajar atau mustahil menurut budaya setempat?"));
        list.add(new Model("5. Apakah pasien memiliki halusinasi yang menetap (berminggu atau berbulan-bulan)?"));
        list.add(new Model("6. Apakah pembicaran dengan pasien tidak relevan (Inkoheren)?"));
        list.add(new Model("7. Apakah pasien sering merasa gelisah ?"));
        list.add(new Model("8. Apakah pasien bersikap apatis ?"));
        return list;
    }
}
