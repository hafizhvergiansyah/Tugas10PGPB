package com.example.tugas10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private Context context;
    private List<Movie> resultList;

    public ListAdapter(Context context, List<Movie> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_movie, parent, false);

        ListAdapter.MyViewHolder viewHolder = new ListAdapter.MyViewHolder(view);
        return viewHolder;
    };


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTitle.setText(resultList.get(position).getTitle());
        holder.tvDescription.setText(resultList.get(position).getOverview());
        Glide.with(holder.imgPoster.getContext()).
                load("https://image.tmdb.org/t/p/w185" + resultList.get(position).getPosterPath()).
                into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvDescription;
        RelativeLayout relativeLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPoster = itemView.findViewById(R.id.imgMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDesc);
            relativeLayout = itemView.findViewById(R.id.rvMovie);
        }
    }
}