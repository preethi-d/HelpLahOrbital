package com.example.preethidevarajan.helplahorbital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModulesActivity extends AppCompatActivity {

    Button CS1101S;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);

        CS1101S = findViewById(R.id.CS1101S);

        CS1101S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForumActivity();
            }
        });


    }

    public void openForumActivity() {
        Intent intent = new Intent(this, ForumActivity.class);
        startActivity(intent);
    }
}
