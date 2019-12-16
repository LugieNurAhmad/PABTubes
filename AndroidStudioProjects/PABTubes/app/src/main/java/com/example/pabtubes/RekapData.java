package com.example.pabtubes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RekapData extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String userID;

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

        final TextView titleP = (TextView)findViewById(R.id.title_rekap);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        userID = mAuth.getCurrentUser().getUid();

//        Calendar calendar = Calendar.getInstance();
//        int cHour = calendar.get(Calendar.HOUR);
//        int cMinute = calendar.get(Calendar.MINUTE);
//        int cSecond = calendar.get(Calendar.SECOND);
//        String jam = Integer.toString(cHour);
//        String menit = Integer.toString(cMinute);
//        String detik = Integer.toString(cSecond);
//        String Waktu =" "+ jam +":" + menit + ":" + detik;
//
//        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
//        currentDate += Waktu;

        db = FirebaseFirestore.getInstance();
        db.collection("data_penyakit").document(userID).collection("waktu").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()){
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d :list){
                        DataRekap p = d.toObject(DataRekap.class);
                        p.setId(d.getId());
                        dataRekapList.add(p);
                        Toast.makeText(getApplicationContext(), "nama : " + p, Toast.LENGTH_SHORT).show();
                    }
                    adapterRekap.notifyDataSetChanged();
                }
            }

        });
//        db.collection("data_penyakit").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        if (!queryDocumentSnapshots.isEmpty()){
//                            List<DocumentSnapshot> list =queryDocumentSnapshots.getDocuments();
//                            for (DocumentSnapshot d :list){
//
//                                DataRekap p = d.toObject(DataRekap.class);
//                                p.setId(d.getId());
//                                dataRekapList.add(p);
//                            }
//                            adapterRekap.notifyDataSetChanged();
//                        }
//                    }
//                });
    }
}

//    @Override
//    public void onSuccess(DocumentSnapshot documentSnapshot) {
//        String Rpenyakit = documentSnapshot.getString("Penyakit");
////                String password  = documentSnapshot.getString("password");
//
//
//        titleP.setText(Rpenyakit);
////                passwordtxt.setText(password);
//    }