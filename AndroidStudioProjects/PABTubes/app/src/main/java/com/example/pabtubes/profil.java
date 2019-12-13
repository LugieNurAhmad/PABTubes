package com.example.pabtubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class profil extends AppCompatActivity {
    //Deklarasi Button
    private Button btn_logout;

    //Deklarasi variabel Firebase
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        //get firebase out instance
        auth = FirebaseAuth.getInstance();

        //Inisialisasi btn_logout
        btn_logout = (Button) findViewById(R.id.btn_logout);

        //Saat btn_logout diklik
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(profil.this, LoginActivity.class));
                finish();
            }
        });
    }
}
