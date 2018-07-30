package com.example.preethidevarajan.helplahorbital;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class SignUpActivity extends AppCompatActivity {

    EditText username;
    EditText email;
    EditText password;
    Button create;
    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.usernameedit);
        email = (EditText) findViewById(R.id.emailedit);
        password = (EditText) findViewById(R.id.passwordedit);
        create = (Button) findViewById(R.id.button3);
        //Firebase Auth Instance
        mAuth = FirebaseAuth.getInstance();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emailadd = email.getText().toString().trim();
                final String pass_word = password.getText().toString().trim();
                final String user_name=username.getText().toString().trim();

                //Check if username is empty
                if (TextUtils.isEmpty(user_name)) {
                    Toast.makeText(SignUpActivity.this, "Enter Username ", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Check if email is empty
                if (TextUtils.isEmpty(emailadd)) {
                    Toast.makeText(SignUpActivity.this, "Enter Email Address", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Check if password is empty
                if (TextUtils.isEmpty(pass_word)) {
                    Toast.makeText(SignUpActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                //check if password is alphanumeric
                /*if(!pass_word.matches("^(?=.[A-Z])(?=.[0-9])(?=.*[a-z])[a-zA-Z0-9]+$")) {
                    Toast.makeText(SignUpActivity.this, "Password must contain one " +
                            "upper and lower case letter and one number", Toast.LENGTH_LONG).show();
                    return;
                }
                */


                mAuth.createUserWithEmailAndPassword(emailadd, pass_word).
                addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();

                        } else {

                            User user = new User(emailadd, user_name);

                            FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                }
                            });
                            //signup successful, go to home activity
                            openForumActivity();
                            finish();
                        }
                    }
                });



            }
        });





    }
    public void openForumActivity() {
        Intent intent = new Intent(this, ForumActivity.class);
        startActivity(intent);
    }


    public void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
