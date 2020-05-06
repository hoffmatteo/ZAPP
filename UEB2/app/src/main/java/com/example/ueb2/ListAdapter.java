package com.example.ueb2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.view.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.*;
import androidx.recyclerview.widget.*;

import java.util.LinkedList;

public class ListAdapter extends
        RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private final LinkedList<String> mList;
    private LayoutInflater mInflater;
    ListAdapter(Context context, LinkedList<String> list) {
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View mItemView = mInflater.inflate(R.layout.listitem, parent, false);
        return new ViewHolder(mItemView);

    }
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        String mCurrent = mList.get(position);
        viewHolder.mCheckBox.setText(mCurrent);
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox mCheckBox;
        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            itemView.findViewById(mCheckBox.getId());
        }
    }
}
