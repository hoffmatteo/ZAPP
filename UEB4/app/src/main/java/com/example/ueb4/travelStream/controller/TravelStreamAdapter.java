package com.example.ueb4.travelStream.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ueb4.R;
import com.example.ueb4.travelStream.model.DsTravelStream;

import java.util.List;

public class TravelStreamAdapter extends RecyclerView.Adapter<TravelStreamAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private Context mCtx;
    private List<com.example.ueb4.travelStream.model.DsTravelStream> mItems;

    public TravelStreamAdapter(Context context, List<com.example.ueb4.travelStream.model.DsTravelStream> items) {
        mInflater = LayoutInflater.from(context);
        this.mCtx = context;
        this.mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.row_travel_stream, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        com.example.ueb4.travelStream.model.DsTravelStream travelStream = mItems.get(position);
        holder.mImageView.setImageResource(travelStream.getResId());
        holder.mTextViewTitle.setText(travelStream.getTitle());
        holder.mTextViewSubtitle.setText(travelStream.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTextViewTitle;
        private TextView mTextViewSubtitle;

        public ViewHolder(View view) {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.row_travel_stream_image);
            mTextViewTitle = (TextView) view.findViewById(R.id.row_travel_stream_title);
            mTextViewSubtitle = (TextView) view.findViewById(R.id.row_travel_stream_subtitle);
        }
    }
}
