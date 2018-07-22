package com.example.preethidevarajan.helplahorbital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AddAnswerActivity extends AppCompatActivity {

    Button answer;
    ImageButton camera;
    ImageButton attach;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_answer);

        answer = findViewById(R.id.answerButton);
        camera = findViewById(R.id.camera);
        attach = findViewById(R.id.attachment);

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddAnswerActivity.this, AnswerActivity.class);
                startActivity(intent);
            }
        });
    }
}
