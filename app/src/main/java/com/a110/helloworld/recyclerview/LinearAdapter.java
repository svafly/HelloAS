package com.a110.helloworld.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
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
public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener mListener;

    public LinearAdapter(Context context,OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        if (i == 0){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
        } else {
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int i) {
        if (getItemViewType(i) == 0){
            ((LinearViewHolder)holder).textView.setText("Hello World!");
        } else {
            ((LinearViewHolder2)holder).textView.setText("I'm the second item!");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(i);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0){
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public LinearViewHolder(View itemView){
            super(itemView);

            textView = itemView.findViewById(R.id.tv_linear_title);

        }
    }

    class LinearViewHolder2 extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;

        public LinearViewHolder2(View itemView){
            super(itemView);

            textView = itemView.findViewById(R.id.tv_linear_title);
            imageView = itemView.findViewById(R.id.iv_linear);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
