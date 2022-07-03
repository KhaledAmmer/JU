package com.example.myapplication32;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class myadapter2 extends RecyclerView.Adapter<myadapter2.ExampleViewHolder> {

    private ArrayList<addresses> mExampleList;
    private myadapter2.OnItemClickListener mListener;
    private int j;



    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(myadapter2.OnItemClickListener listener) {
        mListener = listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(View itemView, final myadapter2.OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
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


    public myadapter2(ArrayList<addresses> exampleList) {
        mExampleList = exampleList;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout3, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        addresses currentItem = mExampleList.get(position);
        holder.mImageView.setImageResource(currentItem.getIdimage());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


}