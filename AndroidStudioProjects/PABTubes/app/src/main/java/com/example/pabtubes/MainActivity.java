package com.example.pabtubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/*Comments
1. Topik atau masalah yang ingin diselesaikan?
    Sistem Pakar Diagnosis skizofrenia pada pasien dan menentukan tipenya
2.  Mengapa aplikasi tersebut harus dibangun di Android?
    Karena akan ada fitur reminder untuk minum obat dan fitur pendukung lainnya
3.  Siapa usernya
    Psikiater, Pasien/Kerabat
4.  Siapa clientnya
    Pasien
5. Apa inputnya
    Gejala yang dialami pasieni
6. Apa outputnya
    Hasil apakah pasien menderita Skizofrenia atau tidak, serta menentukan tipenya
7. Fungsi-fungsi/fitur apa saja yang ada pada aplikasi tersebut?
    -Login (ini fitur bukan ya?)
    -Penjelasan Aplikasi
    -Diagnosis Skizofrenia
    -Reminder
    */
public class MainActivity extends AppCompatActivity {

    private int loading_time=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //home= untuk pindah tampilan utama
                Intent home=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(home);
                finish();
            }
        },loading_time);
    }
}
