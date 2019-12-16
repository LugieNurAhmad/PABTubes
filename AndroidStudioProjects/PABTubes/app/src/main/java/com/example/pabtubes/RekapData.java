package com.example.pabtubes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class RekapData extends AppCompatActivity {

    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap_data);

//        db.collection("data_penyakit").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        if (!queryDocumentSnapshots.isEmpty()){
//                            List<DocumentSnapshot> list =queryDocumentSnapshots.getDocuments();
//                            for (DocumentSnapshot d :list){
//
//                            }
//                        }
//                    }
//                });
    }
}