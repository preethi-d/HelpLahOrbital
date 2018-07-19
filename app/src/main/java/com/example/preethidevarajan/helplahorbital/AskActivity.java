package com.example.preethidevarajan.helplahorbital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AskActivity extends AppCompatActivity {

    //private static final String TAG = "AskActivity";
    private Button Ask;
    private EditText question;
    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        Ask = findViewById(R.id.askButton);
        question = findViewById(R.id.questionedittext);
        username = findViewById(R.id.username);

        //DATABASE CODE HERE
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();

        /*
        //myRef.setValue("Hello World!");

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
        */

        Ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question newQuestion = new Question(question.getText().toString(), username.getText().toString());
                myRef.child("question").setValue(newQuestion.getQuestion());
                myRef.child("username").setValue(newQuestion.getUsername());

                Intent intent = new Intent(AskActivity.this, ForumActivity.class);
                intent.putExtra("question", question.getText().toString());
                startActivity(intent);


            }
        });
    }

    /*public void openHomeActivity() {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
    */

}
