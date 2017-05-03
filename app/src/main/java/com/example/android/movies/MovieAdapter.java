package com.example.android.movies;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by brianngugi on 30-Apr-17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private static final String TAG = MovieAdapter.class.getSimpleName();

    private List<Movie> movieList;
    private Context context;


    public MovieAdapter(Context context, List<Movie> movieList)
    {
        this.context = context;
        this.movieList = movieList;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView moviePoster;

        public MovieViewHolder(View itemView) {
            super(itemView);

            this.moviePoster = (ImageView) itemView.findViewById(R.id.iv_movieposter);
        }
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.movie_grid_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        MovieViewHolder viewHolder = new MovieViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position)
    {
        Log.d(TAG, "Movie" + position + "set.");
        Movie movie = movieList.get(position);
        String baseURL = "http://image.tmdb.org/t/p/";
        String imageSize = "w185/";

        Picasso.with(context)
                .load(baseURL + imageSize + movie.getPoster_path())
                .into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


}
