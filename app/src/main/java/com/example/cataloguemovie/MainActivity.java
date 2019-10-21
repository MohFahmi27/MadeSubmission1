package com.example.cataloguemovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    private String[] dataJudul;
    private String[] dataDuration;
    private String[] dataRating;
    private String[] dataGenre;
    private String[] dataSynopsis;
    private TypedArray dataphoto;
    private AdapterMovie adapter;
    private ArrayList<movie> Movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new AdapterMovie(this);
        ListView listView = findViewById(R.id.lv_listView);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetailMovie.class);
                intent.putExtra("movies", Movies.get(i));
                startActivity(intent);
            }
        });

    }
    private void prepare() {
        dataJudul = getResources().getStringArray(R.array.judul);
        dataDuration = getResources().getStringArray(R.array.duration);
        dataRating = getResources().getStringArray(R.array.rating);
        dataGenre = getResources().getStringArray(R.array.genre);
        dataSynopsis = getResources().getStringArray(R.array.synopsis);
        dataphoto = getResources().obtainTypedArray(R.array.poster);
    }
    private void addItem() {
        Movies = new ArrayList<>();
        for (int n = 0; n < dataJudul.length;n++) {
            movie movies = new movie();
            movies.setImg_Photo(dataphoto.getResourceId(n , -1));
            movies.setJudul(dataJudul[n]);
            movies.setDuration(dataDuration[n]);
            movies.setRating(dataRating[n]);
            movies.setGenre(dataGenre[n]);
            movies.setSynopsis(dataSynopsis[n]);
            Movies.add(movies);
        }
        adapter.setListmovie(Movies);
    }
}
