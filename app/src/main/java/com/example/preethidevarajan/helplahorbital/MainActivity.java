package com.example.preethidevarajan.helplahorbital;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button sign_up;
    Button log_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing xml ids for all buttons and widgets
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        log_in = (Button) findViewById(R.id.button);
        sign_up = (Button) findViewById(R.id.button2);

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //what happens when they click Log In
                //If use hasnt signed up,
                //Toast.makeText(MainActivity.this, "Account does not exist", Toast.LENGTH_LONG).show();

                openHomeActivity();


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

    public void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openSignUpActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }


}

