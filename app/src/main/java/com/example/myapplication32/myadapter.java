package com.example.myapplication32;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class myadapter extends RecyclerView.Adapter<myadapter.ExampleViewHolder> {

    private ArrayList<addresses> mExampleList;
    private OnItemClickListener mListener;
    private int j;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public myadapter(ArrayList<addresses> exampleList, int n) {
        mExampleList = exampleList;
        j=n;
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);;
        switch (j){
            case 0:v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
            break;
            case 1:v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout2, parent, false);
            break;
        }


        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }


    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        addresses currentItem = mExampleList.get(position);

        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}