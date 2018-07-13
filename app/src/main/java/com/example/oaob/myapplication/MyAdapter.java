package com.example.oaob.myapplication;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private ArrayList<String> mData;

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView mTextView;
        Button myButton;
        ViewHolder(View v)
        {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.info_text);
            myButton = (Button) v.findViewById(R.id.button);
        }
    }

    MyAdapter(ArrayList<String> data)
    {
        mData = data;
    }

    public void add_new_task(String s)
    {
        mData.add(s);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position)
    {
        holder.mTextView.setText(mData.get(position));
        holder.myButton.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v)
            {
                mData.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }
}
