package com.namankhurpia.easyed.easyed;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener{

    private EditText username, password;
    ImageButton loginbtn;
    ImageButton signuptrbtn;

    private Firebase usernameref;
    private Firebase passwordref;
    String userfromback;
    String passfromback;

    private FirebaseAuth mauth;

    private FirebaseAuth.AuthStateListener mauthlistener;

    private TextView usernamefrombackfirebase;
    private TextView passwordfrombackfireabse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

       username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        loginbtn=(ImageButton)findViewById(R.id.login);
        signuptrbtn=(ImageButton)findViewById(R.id.signupbtn);


        loginbtn.setOnClickListener(this);

        mauth=FirebaseAuth.getInstance();

        mauthlistener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser()!=null)
                {
                    Intent i=new Intent(login.this,homescreen.class);
                    startActivity(i);
                }
            }
        };

        signuptrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(login.this,signup.class);
                startActivity(i);


            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mauth.addAuthStateListener(mauthlistener);
    }



    private void startsignin()
    {
        String email=username.getText().toString();
        String passw=password.getText().toString();

        if(email.isEmpty() || passw.isEmpty())
        {
            Toast.makeText(login.this, "FIELDS ARE EMPTY", Toast.LENGTH_LONG).show();
        }
        else {

            mauth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()) {
                        Toast.makeText(login.this, "INVALID CREDENTIALS", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

    @Override
    public void onClick(View v) {
        startsignin();

    }




}


