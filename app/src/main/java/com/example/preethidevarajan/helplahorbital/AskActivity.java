package com.example.preethidevarajan.helplahorbital;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AskActivity extends AppCompatActivity {

    private Button Ask;
    private EditText question;
    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        //this will hold out collection of qns
        //final List<Question> questions = new ArrayList<>();

        Ask = findViewById(R.id.askButton);
        question = findViewById(R.id.questionedittext);


        //DATABASE CODE HERE
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();



        Ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = getIntent().getParcelableExtra("user");
                Question newQuestion = new Question(question.getText().toString());
                myRef.child("Question").push().setValue(newQuestion);

                Intent intent = new Intent(AskActivity.this, ForumActivity.class);
                intent.putExtra("question", question.getText().toString());
                startActivity(intent);

            }
        });


    };
    }



