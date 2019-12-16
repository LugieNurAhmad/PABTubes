package com.example.pabtubes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RekapData extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterRekap adapterRekap;
    private List<DataRekap> dataRekapList;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap_data);

        recyclerView =findViewById(R.id.recView_Rekap);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataRekapList = new ArrayList<>();
        adapterRekap = new AdapterRekap(this, dataRekapList);

        recyclerView.setAdapter(adapterRekap);

        db = FirebaseFirestore.getInstance();

        db.collection("data_penyakit").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()){
                            List<DocumentSnapshot> list =queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d :list){

                                DataRekap p = d.toObject(DataRekap.class);
                                p.setId(d.getId());
                                dataRekapList.add(p);
                            }
                            adapterRekap.notifyDataSetChanged();
                        }
                    }
                });
    }
}