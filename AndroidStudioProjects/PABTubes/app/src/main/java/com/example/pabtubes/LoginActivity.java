package com.example.pabtubes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText _txtEmail, _txtPass;
    Button _btnLogin;
    Spinner _spinner;
    TextView _textview_register;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();

        _txtPass=(EditText)findViewById(R.id.txtPass);
        _txtEmail=(EditText)findViewById(R.id.txtEmail);
        _btnLogin=(Button)findViewById(R.id.btnLogin);
        _spinner=(Spinner)findViewById(R.id.spinner);
        _textview_register=(TextView)findViewById(R.id.textview_register);


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null){
                    Toast.makeText(LoginActivity.this,"You are logged in" ,Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, home.class);
                    startActivity(i);
                }
            }
        };


        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=  _txtEmail.getText().toString();
                String pwd = _txtPass.getText().toString();
                //String item = _spinner.getSelectedItem().toString();
                if(email.isEmpty()){
                    _txtEmail.setError("Please Enter Email");
                    _txtEmail.requestFocus();
                }
                else if (pwd.isEmpty()){
                    _txtPass.setError("Please Enter Password");
                    _txtPass.requestFocus();
                }
                else if (email.isEmpty() &&  pwd.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pwd.isEmpty() /* && item.equals("user")*/)){
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(LoginActivity.this,"Login Error, Please Login Again", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent IntToUser = new Intent(LoginActivity.this, home.class);
                                startActivity(IntToUser);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(LoginActivity.this, "Error Occured!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        _textview_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intRegister = new Intent(LoginActivity.this, register.class);
                startActivity(intRegister);
            }
        });
//        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
//        _spinner.setAdapter(adapter);
//        _btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String item = _spinner.getSelectedItem().toString();
//                if(_txtEmail.getText().toString().equals("admin")&& _txtPass.getText().toString().equals("admin")&& item.equals("admin")){
//                    Intent intent = new Intent(LoginActivity.this, admin.class);
//                    startActivity(intent);
//
//                }else if(_txtEmail.getText().toString().equals("admin")&& _txtPass.getText().toString().equals("admin")&& item.equals("user")){
//                    Intent intent = new Intent(LoginActivity.this, user.class);
//                    startActivity(intent);
//                }else {
//                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                }
//
//            }
//        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

}
