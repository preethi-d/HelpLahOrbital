package com.example.preethidevarajan.helplahorbital;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        //holder.answersview.setText(question.getAnswer());

    }

    @Override
    public int getItemCount() {
        return QuestionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView questionview;
        TextView usernameview;
        TextView answersview;

        public ViewHolder(View itemView) {
            super(itemView);

            questionview = itemView.findViewById(R.id.questionview);
            usernameview = itemView.findViewById(R.id.usernameview);
            answersview = itemView.findViewById(R.id.answersview);

        }


    }


    /*private String question;
    private LayoutInflater mInflater;

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String question = mData.get(position);
        holder.mTextView.setText(question);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }
    */
}
