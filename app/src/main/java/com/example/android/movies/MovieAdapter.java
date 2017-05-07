package com.example.android.movies;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.List;

import static android.R.attr.start;

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

    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private ImageView moviePoster;

        public MovieViewHolder(View itemView)
        {
            super(itemView);

            this.moviePoster = (ImageView) itemView.findViewById(R.id.iv_movieposter);
        }

        @Override
        public void onClick(View v)
        {
            Toast.makeText(v.getContext(), "Movie clicked", Toast.LENGTH_SHORT).show();
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
        final Movie movie = movieList.get(position);
        String baseURL = "http://image.tmdb.org/t/p/";
        String imageSize = "w342/";

        Picasso.with(context)
                .load(baseURL + imageSize + movie.getPoster_path())
                .into(holder.moviePoster);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);

                String mov_title = movie.getMovie_title();
                String mov_poster = movie.getPoster_path();
                String mov_plot = movie.getPlot();
                String mov_date = movie.getRelease_date();
                String mov_rating = movie.getRating();
                String mov_bdposter = movie.getBackdrop_path();

                intent.putExtra("mov_title", mov_title);
                intent.putExtra("mov_poster", mov_poster);
                intent.putExtra("mov_bd_path", mov_bdposter);
                intent.putExtra("mov_plot", mov_plot);
                intent.putExtra("mov_date", mov_date);
                intent.putExtra("mov_rating", mov_rating);

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


}
