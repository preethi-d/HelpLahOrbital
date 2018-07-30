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



public class AnswerRecyclerAdapter extends RecyclerView.Adapter<AnswerRecyclerAdapter.ViewHolder> {

    public Context ctxt;
    public List<Answer> answerList;

    //recyclerview maintains a pool of cardviews
    public AnswerRecyclerAdapter(Context ctxt, List<Answer> answerList) {
        this.ctxt = ctxt;
        this.answerList = answerList;
    }

    //oncreateviewholder creates each viewHolder based on the row_answer.xml
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(ctxt)
                .inflate(R.layout.row_answer , parent, false);
        return new ViewHolder(cardView);
    }

    //bind data UI element, populates the cards and puts the data in the cardview
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardView cardView = holder.mCardView;
        TextView answerview = cardView.findViewById(R.id.answerview);
        //TextView usernameview = cardView.findViewById(R.id.usernameview);
        //Button like = cardView.findViewById(R.id.likebutton);


        Answer answer = answerList.get(position);
        answerview.setText(answer.getAnswer());

    }

    @Override
    public int getItemCount() {

        if (answerList==null) {
            return 0;
        } else {
            return answerList.size();
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
