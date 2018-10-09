package com.a110.helloworld.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a110.helloworld.R;

/**
 * Create by vicky on 2018/10/8
 */
public class PuAdapter extends RecyclerView.Adapter<PuAdapter.LinearViewHolder> {
    private Context mContext;
    private OnItemClickListener mListener;

    public PuAdapter(Context context, OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }
    @Override
    public PuAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_grid_recyler_item,parent,false));
    }

    @Override
    public void onBindViewHolder(PuAdapter.LinearViewHolder holder, final int i) {
        if (i % 2 == 0){
            holder.imageView.setImageResource(R.drawable.bg_two_bear);
        } else {
            holder.imageView.setImageResource(R.drawable.bg_japan_famous);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;

        public LinearViewHolder(View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.iv);

        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
