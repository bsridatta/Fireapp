package com.example.sridatta.fireapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
// login page please review this in vac .. no login in old devices .. trouble during demonstration

public class Login extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;
    private Button mLogin;
//authentication through firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail=(EditText)findViewById(R.id.et_email);
        mPassword=(EditText)findViewById(R.id.et_password);
        mLogin=(Button) findViewById(R.id.btn_login);


        mAuth=FirebaseAuth.getInstance();
        mAuthListener=new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser()!=null){

                    startActivity(new Intent(Login.this,MainActivity.class));

                }

            }
        };




        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startSignIn();


            }
        });




    }


    protected void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

// logic block
    private void startSignIn(){

        String email=mEmail.getText().toString();
        String password=mPassword.getText().toString();

        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password)) {

            Toast.makeText(Login.this, "Fields are empty", Toast.LENGTH_LONG).show();


        }else{
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(Login.this, "SignIn Problem", Toast.LENGTH_LONG).show();
                    }
                }
            });



        }
    }
}
