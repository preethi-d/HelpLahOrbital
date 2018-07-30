package com.example.preethidevarajan.helplahorbital;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AnswerActivity extends AppCompatActivity {

    FloatingActionButton addAnswer;
    ImageButton backToForumPage;

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

    }
}
