package com.example.pabtubes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.pabtubes.reminder.AlarmReminder;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class profil extends AppCompatActivity {
    //Deklarasi Button
    private Button btn_logout, logoutBt;

    //Deklarasi variabel Firebase
    private FirebaseAuth auth;

    String userKey;
    FirebaseDatabase dbP;
    DatabaseReference databaseProfil;
    ListView ListViewprofil;
    List<DataRegis> listProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        //get firebase out instance
        auth = FirebaseAuth.getInstance();

        //Inisialisasi btn_logout
        btn_logout = (Button) findViewById(R.id.btn_logout);

        //Saat btn_logout diklik
//        btn_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                auth.signOut();
//                startActivity(new Intent(profil.this, LoginActivity.class));
//                finish();
//            }
//        });


        ListViewprofil = (ListView)findViewById(R.id.listVProvil);
        listProfil = new ArrayList<>();

        //code untuk Bottom Navigation Bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.profil);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),SkizoActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.reminder:
                        startActivity(new Intent(getApplicationContext(), AlarmReminder.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profil:
                        return true;
                }
                return false;
            }
        });


    }

    //profil di toolbar
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_profil, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.btn_logout2:
                auth.signOut();
                Intent intent = new Intent(profil.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

//        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        databaseProfil = FirebaseDatabase.getInstance().getReference(uid);

        auth = FirebaseAuth.getInstance();
        dbP = FirebaseDatabase.getInstance();
        databaseProfil = dbP.getReference("Data Akun");
        FirebaseUser user = auth.getCurrentUser();
        userKey = user.getUid();

        databaseProfil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userID = auth.getInstance().getCurrentUser().getUid();

                listProfil.clear();
                for (DataSnapshot profilSnapshot : dataSnapshot.getChildren()){
                    DataRegis profiL = profilSnapshot.getValue(DataRegis.class);

                    listProfil.add(profiL);
                    Toast.makeText(getApplicationContext(), "nama : " + userID, Toast.LENGTH_SHORT).show();

                }
                AdapterProfil adapterProfil = new AdapterProfil(profil.this, listProfil);
                ListViewprofil.setAdapter(adapterProfil);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
