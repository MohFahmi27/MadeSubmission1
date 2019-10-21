package com.example.cataloguemovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterMovie extends BaseAdapter {
    ImageView imgphoto;
    TextView tvJudul,tvDuration,tvRating,tvGenre;
    private final Context context;

    public void setListmovie(ArrayList<movie> movies) {
        this.movies = movies;
    }

    private ArrayList<movie> movies;

    public AdapterMovie(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.movie_list, viewGroup, false);

        imgphoto = view.findViewById(R.id.img_photo);
        tvJudul = view.findViewById(R.id.tv_movies_tittle);
        tvDuration = view.findViewById(R.id.tv_duration);
        tvRating = view.findViewById(R.id.rating);
        tvGenre = view.findViewById(R.id.tv_genre);

        movie Movie = (movie) getItem(i);
        imgphoto.setImageResource(Movie.getImg_Photo());
        tvJudul.setText(Movie.getJudul());
        tvRating.setText(Movie.getRating());
        tvDuration.setText(Movie.getDuration());
        tvGenre.setText(Movie.getGenre());

        return view;
    }
}
