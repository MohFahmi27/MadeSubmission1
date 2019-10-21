package com.example.cataloguemovie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class DetailMovie extends AppCompatActivity {
    ImageView detailposter;
    TextView detail_judul,detail_duration,detail_genre,detail_rating,detail_synopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        detail_judul = findViewById(R.id.tv_detailtittle);
        detail_duration = findViewById(R.id.tv_detailduration);
        detail_genre = findViewById(R.id.tvdetail_genre);
        detail_rating = findViewById(R.id.tvdetail_rating);
        detail_synopsis = findViewById(R.id.synopsis);
        detailposter =findViewById(R.id.img_detailmv);

        getParcel();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private void getParcel(){
        movie Movie = getIntent().getParcelableExtra("movies");

        detail_judul.setText(Movie.getJudul());
        detail_duration.setText(Movie.getDuration());
        detail_rating.setText(Movie.getRating());
        detail_genre.setText(Movie.getGenre());
        detail_synopsis.setText(Movie.getSynopsis());
        detailposter.setImageResource(Movie.getImg_Photo());
    }

}
