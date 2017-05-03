package com.example.android.movies;

import android.content.Context;

/**
 * Created by brianngugi on 30-Apr-17.
 */

public class Movie {
    private String movie_title;
    private String poster_path;
    private String plot;
    private String rating;
    private String release_date;

    public Movie(String title, String poster, String mPlot, String mRating, String date)
    {
        this.movie_title = title;
        this.poster_path = poster;
        this.plot = mPlot;
        this.rating = mRating;
        this.release_date = date;
    }

    //Class Setters
    public void setTitle(String title)
    {
        this.movie_title = title;
    }
    public void setPoster_path(String poster)
    {
        this.poster_path = poster;
    }
    public void setPlot(String mPlot)
    {
        this.plot = mPlot;
    }
    public void setRating(String mRating)
    {
        this.rating = mRating;
    }
    public void setRelease_date(String date)
    {
        this.release_date = date;
    }

    //Class Getters
    public String getMovie_title()
    {
        return movie_title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getPlot() {
        return plot;
    }

    public String getRating() {
        return rating;
    }

    public String getRelease_date() {
        return release_date;
    }
}
