package com.example.pabtubes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class profilEdit extends AppCompatActivity {


    private RadioButton genderS;
    private String gender, email, nama, phone;
    private String uid;

    private FirebaseAuth FbAuth;
    private FirebaseUser user;
    private DatabaseReference dbRnama, dbRemail, dbRmobile, dbRgender;
    private DatabaseReference dbAkun, dbu, dbRef;
    private FirebaseDatabase dbFb, dbUpdate;
    private Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_edit);

        FbAuth = FirebaseAuth.getInstance();
        user = FbAuth.getCurrentUser();

        dbFb = FirebaseDatabase.getInstance();
        dbAkun = dbFb.getReference("Data Akun");

        final EditText edtNama = (EditText)findViewById(R.id.ed_reg_nameEdit);
        final EditText edtEmail = (EditText)findViewById(R.id.ed_reg_emailEdit);
        final EditText edtMobile = (EditText)findViewById(R.id.ed_id_mobileEdit);
//        final RadioGroup gdrGroup = (RadioGroup)findViewById(R.id.radioEdit_gender);

        final Button btnSubmitEdt = (Button)findViewById(R.id.btnSubmitEdit);

//        gdrGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                genderS = genderS.findViewById(i);
//                switch (i){
//                    case R.id.rb_edt_male:
//                    case R.id.rb_edt_female:
//                        gender = genderS.getText().toString().trim();
//                        break;
//                        default:
//                }
//            }
//        });

        nama = edtNama.getText().toString().trim();
        email = edtEmail.getText().toString().trim();
        phone = edtMobile.getText().toString().trim();

        //Read
        Query query = dbAkun.orderByChild("email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataS : dataSnapshot.getChildren()){
                    String ReadNama = "" + dataS.child("nama").getValue();
                    String ReadEmail = "" + dataS.child("email").getValue();
                    String ReadMobile = "" + dataS.child("phone").getValue();

                    edtNama.setText(ReadNama);
                    edtEmail.setText(ReadEmail);
                    edtMobile.setText(ReadMobile);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnSubmitEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edtNama.getText().toString().trim();
                email = edtEmail.getText().toString().trim();
                phone = edtMobile.getText().toString().trim();

                updateData(new DataRegis(nama, email, phone));
            }
        });
    }

    private void updateData(DataRegis data){
        Query query = dbAkun.orderByChild("email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()){
                    String key = child.getKey();

                    uid = key;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        FbAuth = FirebaseAuth.getInstance();
        user = FbAuth.getCurrentUser();
        dbUpdate = FirebaseDatabase.getInstance();
        dbRef = dbUpdate.getReference("Data Akun");
        final String user_id = user.getUid();

        final FirebaseDatabase dtbase = FirebaseDatabase.getInstance();

        DatabaseReference ref = dtbase.getReference("Data Akun");
        DatabaseReference userRef = ref.child(user_id);

        Map<String, Object> hUpdates = new HashMap<>();
        hUpdates.put("nama", nama);
        hUpdates.put("email", email);
        hUpdates.put("phone", phone);
        hUpdates.put("gender", gender);

        dbRef.child(user.getUid()).setValue(hUpdates);
        Toast.makeText(getApplicationContext(),"Perubahan Telah Disimpan",Toast.LENGTH_SHORT).show();

    }
}
