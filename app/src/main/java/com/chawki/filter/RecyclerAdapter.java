package com.chawki.filter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<Model> list;

    public RecyclerAdapter(Context mContext, List<Model> list) {
        this.mContext = mContext;
        this.list = list;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Model model = list.get(position);
        holder.TitleImageView.setImageResource(model.image);
        holder.Title.setText(model.Title);
        holder.location.setText(model.location);
        holder.rating.setText(model.rating);
        holder.likes.setText(model.likes);
        holder.distance.setText(model.distance);

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView TitleImageView;
        TextView Title;
        TextView location;
        TextView rating;
        TextView likes;
        TextView distance;

        public MyViewHolder(View itemView) {
            super(itemView);
            TitleImageView = (ImageView) itemView.findViewById(R.id.TitleImageView);
            Title = (TextView) itemView.findViewById(R.id.TextViewTitle);
            location = (TextView) itemView.findViewById(R.id.TextViewLocation);
            rating = (TextView) itemView.findViewById(R.id.TextViewRating);
            likes = (TextView) itemView.findViewById(R.id.TextViewLikes);
            distance = (TextView) itemView.findViewById(R.id.TextViewDistance);
        }
    }

}
