package com.example.android.movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by brianngugi on 05-May-17.
 */

public class DetailActivity extends AppCompatActivity {

    private Context context;
    private ImageView mPoster;
    private TextView mTitle;
    private TextView mRating;
    private TextView mDate;
    private TextView mDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        context = this;

        mPoster = (ImageView) findViewById(R.id.iv_detail_poster);
        mTitle = (TextView) findViewById(R.id.tv_title);
        mRating = (TextView) findViewById(R.id.tv_rating);
        mDate = (TextView) findViewById(R.id.tv_rdate);
        mDesc = (TextView) findViewById(R.id.tv_plot);

        String baseURL = "http://image.tmdb.org/t/p/";
        String imageSize = "w342/";
        String mPoster_path;
        String mBD_path;

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null)
        {
            mTitle.setText((String) bundle.get("mov_title"));
            mBD_path = (String) bundle.get("mov_poster");
            mRating.setText((String) bundle.get("mov_rating"));
            mDate.setText((String) bundle.get("mov_date"));
            mDesc.setText((String) bundle.get("mov_plot"));

            Picasso.with(context)
                    .load(baseURL + imageSize + mBD_path)
                    .into(mPoster);
        }
    }
}
