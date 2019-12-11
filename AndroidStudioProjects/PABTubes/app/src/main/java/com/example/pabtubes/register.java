package com.example.pabtubes;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    public EditText _txtEmail, _txtPass;
    Button _register;
    TextView _login;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private EditText _txtUser, _txtConfPass, _txtPhone;
    private RadioButton _genderUser;
    private RadioGroup _gender;
    private DatabaseReference databse;
    private FirebaseUser firebaseUser;
    private DatabaseReference database;

    String user, passUser, confPass, phone, gender, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Auth
        firebaseAuth = FirebaseAuth.getInstance();
        databse = FirebaseDatabase.getInstance().getReference();
        _txtEmail = (EditText)findViewById(R.id.ed_reg_email);
        _txtPass = (EditText)findViewById(R.id.ed_reg_pwd1);
        _txtConfPass = (EditText)findViewById(R.id.ed_reg_pwd2);
        //akun databsse
        _txtUser = (EditText)findViewById(R.id.ed_reg_name);
        _txtPhone = (EditText)findViewById(R.id.ed_reg_mobile);

        _register = (Button)findViewById(R.id.registerbtn);
        _login = (TextView)findViewById(R.id.textview_register);

        _gender = (RadioGroup)findViewById(R.id.radio_gender);
        _gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                _genderUser = _gender.findViewById(checkId);

                switch (checkId){
                    case R.id.rb_reg_male:
                    case R.id.rb_reg_female:
                        gender = _genderUser.getText().toString();
                        break;
                        default:
                }
            }
        });

        _register = findViewById(R.id.registerbtn);
        _register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = _txtUser.getText().toString();
                email = _txtEmail.getText().toString();
                passUser= _txtConfPass.getText().toString();
                confPass= _txtPass.getText().toString();
                phone= _txtPhone.getText().toString();
                gender= _genderUser.getText().toString();

//                if (user.isEmpty()) {
//                    user.setError("Provide your Email first!");
//                    user.requestFocus();}

                if(TextUtils.isEmpty(user)){
                    Toast.makeText(getApplicationContext(), "Mohon masukkan nama Anda", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Mohon masukkan E-mail Anda", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(passUser)){
                    Toast.makeText(getApplicationContext(), "Mohon masukkan kata sandi Anda", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(confPass)){
                    Toast.makeText(getApplicationContext(), "Mohon masukkan konfirmasi kata sandi Anda", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(getApplicationContext(), "Mohon masukkan nomor Handphone Anda", Toast.LENGTH_SHORT).show();
                    return;
                }
//                if(TextUtils.isEmpty(gender)){
//                    Toast.makeText(getApplicationContext(), "Mohon masukkan jenis kelamin Anda", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                // Register Akun
                firebaseAuth.createUserWithEmailAndPassword(email, passUser).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        submitData(new DataRegis(user, email, passUser, phone, gender));
                        Toast.makeText(register.this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show();
                        if(!task.isSuccessful()){
                            Toast.makeText(register.this, "Pendaftaran gagal : " + task.getException(), Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(register.this, LoginActivity.class));
                            finish();
                        }
                    }
                });
            }
        });
    }

    private void submitData(DataRegis data){
        databse.child("Data Akun").push().setValue(data).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                    _txtUser.setText("");
                    _txtEmail.setText("");
                    _txtPass.setText("");
                    _txtPhone.setText("");
                    //gender???
                }
        });
    }

    public void processDatePickerResult(int year, int month, int dayOfMonth) {
    }

    public void launchLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
