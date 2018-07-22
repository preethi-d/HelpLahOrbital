package com.example.preethidevarajan.helplahorbital;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.List;



public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    public Context ctxt;
    public List<Question> QuestionList;

    //recyclerview maintains a pool of cardviews
    public MyRecyclerViewAdapter(Context ctxt, List<Question> questionList) {
        this.ctxt = ctxt;
        QuestionList = questionList;
    }

    //oncreateviewholder creates each viewHolder based on the row.xml
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(ctxt)
                .inflate(R.layout.row , parent, false);
        return new ViewHolder(cardView);
    }

    //bind data UI element, populates the cards and puts the data in the cardview
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardView cardView = holder.mCardView;
        TextView questionview = cardView.findViewById(R.id.questionview);
        TextView usernameview = cardView.findViewById(R.id.usernameview);
        Button Answers = cardView.findViewById(R.id.answers);


        Question question = QuestionList.get(position);
        questionview.setText(question.getQuestion());
        usernameview.setText(question.getUsername());
        Answers.setOnClickListener(new View.OnClickListener() {
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

    //the recyclerview holds n number of viewholders depending on the size of the view
    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView mCardView;

        public ViewHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView;
        }


    }


}
