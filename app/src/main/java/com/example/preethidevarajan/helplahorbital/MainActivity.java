package com.example.preethidevarajan.helplahorbital;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button sign_up;
    Button log_in;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //firebase auth instance
        auth = FirebaseAuth.getInstance();
        log_in = findViewById(R.id.loginbutton);
        sign_up = findViewById(R.id.signupbutton);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        log_in.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          //what happens when they click Log In
                                          //If use hasnt signed up,
                                          //Toast.makeText(MainActivity.this, "Account does not exist", Toast.LENGTH_LONG).show();
                                          String email = username.getText().toString().trim();
                                          String pass_word = password.getText().toString().trim();

                                          // Check if email is empty
                                          if (TextUtils.isEmpty(email)) {
                                              Toast.makeText(MainActivity.this, "Enter Email Address", Toast.LENGTH_SHORT).show();
                                              return;
                                          }


                                          // check if password is empty
                                          if (TextUtils.isEmpty(pass_word)) {
                                              Toast.makeText(MainActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                                              return;
                                          }

                                          //authenticate user
                                          auth.signInWithEmailAndPassword(email, pass_word)
                                                  .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                                      @Override
                                                      public void onComplete(@NonNull Task<AuthResult> task) {
                                                          if (!task.isSuccessful()) {
                                                              // error occurred
                                                              Toast.makeText(MainActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                                          } else {
                                                              //log in success, update UI with signed-in users information
                                                              //FirebaseUser user = auth.getCurrentUser();
                                                              //updateUI(user);
                                                              openHomeActivity();
                                                          }


                                                      }
                                                  });
                                      }
                                  });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //what happend when they click sign up
                openSignUpActivity();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //FirebaseUser currentUser = auth.getCurrentUser();
        //updateUI(currentUser);
    }



    public void openHomeActivity() {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }

    public void openSignUpActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }


}

