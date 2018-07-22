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
        final List<Question> questions = new ArrayList<>();

        Ask = findViewById(R.id.askButton);
        question = findViewById(R.id.questionedittext);
        username = findViewById(R.id.username);

        //DATABASE CODE HERE
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        myRef.child("Question").addValueEventListener(new ValueEventListener() {
            /*this method invoked anytime the data on the database changes.
            additionally, it will be invoked as soon as we connect the listener and we can get
            an initial snapshot of the data
            */

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //get all children at this level
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {

                    Question question = dataSnapshot.getValue(Question.class);
                    questions.add(question);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        Ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question newQuestion = new Question(question.getText().toString(), username.getText().toString());
                myRef.child("Question").child("question").setValue(newQuestion.getQuestion());
                myRef.child("Question").child("username").setValue(newQuestion.getUsername());

                Intent intent = new Intent(AskActivity.this, ForumActivity.class);
                intent.putExtra("question", question.getText().toString());
                startActivity(intent);

            }
        });


    };
    }



