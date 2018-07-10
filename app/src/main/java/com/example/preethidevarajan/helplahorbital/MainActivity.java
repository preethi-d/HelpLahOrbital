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

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing xml ids for all buttons and widgets
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        log_in = (Button) findViewById(R.id.button);
        sign_up = (Button) findViewById(R.id.button2);

        //DATABASE CODE HERE
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello World!");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //this method is called once with the initial value and agaain wheneve
                // the data at this location is updated
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());

            }

        });

        //DATABASE CODE STOPS HERE


        //firebase auth instance
        auth = FirebaseAuth.getInstance();

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

