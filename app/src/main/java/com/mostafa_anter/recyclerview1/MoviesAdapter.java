package com.mostafa_anter.recyclerview1;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mostafa on 05/02/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder>{
    private List<Movies> moviesList;

    public MoviesAdapter(List<Movies> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movies movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.title) TextView title;
        @Bind(R.id.genre) TextView genre;
        @Bind(R.id.year)TextView year;

        public MyViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);

        }

    }
}