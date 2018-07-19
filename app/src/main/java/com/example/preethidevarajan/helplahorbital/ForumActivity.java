package com.example.preethidevarajan.helplahorbital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;



import java.util.ArrayList;
import java.util.List;

public class ForumActivity extends AppCompatActivity {

    TextView UserInput;

    RecyclerView recyclerView;
    List<Question> questionList;
    MyRecyclerViewAdapter adapter;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Question");
        mDatabase.keepSynced(true);

        questionList = new ArrayList<>();

        recyclerView  = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        Intent Extra = getIntent();
        String textView = Extra.getStringExtra("question");




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForumActivity.this, AskActivity.class);
                startActivity(intent);
            }
        });

    }

    /*protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Question, QuestionViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Question, QuestionViewHolder>() {
            @Override
            protected void populateViewHolder(QuestionViewHolder viewHolder, Question model, int position) {

            }
        };
    }


    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        View mview;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            mview = itemView;
        }
    }
    */

}
