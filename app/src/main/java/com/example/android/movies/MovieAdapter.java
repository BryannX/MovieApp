package com.example.android.movies;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by brianngugi on 30-Apr-17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private static final String TAG = MovieAdapter.class.getSimpleName();

    private int[] mDataSet;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);

        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_grid_item, parent, false);
        }

        ImageView imageMovie = (ImageView) convertView.findViewById(R.id.iv_movieposter);
        imageMovie.setImageResource(movie.image);


        return super.getView(position, convertView, parent);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView listItemImageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new )
            {

            };
            listItemImageView = (ImageView) itemView.findViewById(R.id.iv_movieposter);
        }

    }
}
