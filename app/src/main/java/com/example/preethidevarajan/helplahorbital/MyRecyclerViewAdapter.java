package com.example.preethidevarajan.helplahorbital;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.List;



public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    public Context ctxt;
    public List<Question> QuestionList;


    public MyRecyclerViewAdapter(Context ctxt, List<Question> questionList) {
        this.ctxt = ctxt;
        QuestionList = questionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctxt)
                .inflate(R.layout.row , null, false);
        return new ViewHolder(v);
    }

    //bind data UI element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Question question = QuestionList.get(position);
        holder.questionview.setText(question.getQuestion());
        holder.usernameview.setText(question.getUsername());
        holder.Answers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctxt, AnswerActivity.class );
                ctxt.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        if (QuestionList==null) {
            return 0;
        } else {
            return QuestionList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView questionview;
        TextView usernameview;
        Button Answers;

        public ViewHolder(View itemView) {
            super(itemView);

            questionview = itemView.findViewById(R.id.questionview);
            usernameview = itemView.findViewById(R.id.usernameview);
            Answers = itemView.findViewById(R.id.answers);
           //answersview = itemView.findViewById(R.id.answersview);

        }


    }


}
