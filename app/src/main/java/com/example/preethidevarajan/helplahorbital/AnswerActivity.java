package com.example.preethidevarajan.helplahorbital;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AnswerActivity extends AppCompatActivity {

    FloatingActionButton addAnswer;
    ImageButton backToForumPage;
    RecyclerView recyclerView;
    List<Answer> answerList;
    public RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mLayoutManager;
    public DatabaseReference mDatabase;
    public FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        addAnswer = findViewById(R.id.addAnswer);
        backToForumPage = findViewById(R.id.backButton);

        addAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnswerActivity.this, AddAnswerActivity.class);
                startActivity(intent);
            }
        });

        backToForumPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnswerActivity.this, ForumActivity.class);
                startActivity(intent);
            }
        });

        //CRUD Display

        answerList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.answersrecycler);
        recyclerView.setHasFixedSize(true);
        final AnswerRecyclerAdapter adapter = new AnswerRecyclerAdapter(this, answerList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        getFirebaseData(new AnswerCallBack() {
            @Override
            public void onCallBack(Answer answer) {
                answerList.add(answer);
                adapter.notifyDataSetChanged();
            }
        });

    }

    public interface AnswerCallBack {
        void onCallBack(Answer answer);
    }

    private void getFirebaseData(final AnswerCallBack answerCallBack) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ansref = reference.child("Answer");

        ansref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //result held here
                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                    Answer answer = new Answer();
                    String ans = String.valueOf(dataSnap.child("answer").getValue());
                    //String username = String.valueOf(dataSnap.child("username").getValue());
                    answer.setAnswer(ans);
                    answerCallBack.onCallBack(answer);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //handle db error
            }
        });

    }
}
