package com.example.android.movies;

import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter movieAdapter;
    private RecyclerView recyclerView;
    private List<Movie> movieList;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_display);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        recyclerView.setHasFixedSize(true);

        String url = "http://api.themoviedb.org/3/movie/popular?api_key=1a832e4bbbb2c8d8feac6b5f090e909e";
        new DownloadTask().execute(url);

    }



    private class DownloadTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            String stream;
            String urlString = params[0];

            HTTPDataHandler hh = new HTTPDataHandler();
            stream = hh.GetHTTPData(urlString);

            return stream;
        }

        @Override
        protected void onPostExecute(String stream) {
            super.onPostExecute(stream);

            progressBar.setVisibility(View.GONE);

            if(stream != null)
            {
                try
                {
                    //Get HTTP as JSONObject
                    JSONObject reader = new JSONObject(stream);

                    //Get the JSONObject Results
                    JSONArray results = reader.getJSONArray("results");

                    movieList = new ArrayList<>();

                    for(int i=0; i < results.length(); i++)
                    {
                        JSONObject result = results.getJSONObject(i);
                        Movie movie = new Movie();

                        //Get Movie Title
                        movie.setTitle(result.getString("original_title"));
                        //Get Poster Path
                        movie.setPoster_path(result.getString("poster_path"));
                        //Get Movie Plot
                        movie.setPlot(result.getString("overview"));
                        //Get Movie Rating
                        movie.setRating(result.getString("vote_average"));
                        //Get Movie Release Date
                        movie.setRelease_date(result.getString("release_date"));

                        movieList.add(movie);
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
            if(stream != null)
            {
                movieAdapter = new MovieAdapter(MainActivity.this, movieList);
                recyclerView.setAdapter(movieAdapter);
            }
        }
    }

}
