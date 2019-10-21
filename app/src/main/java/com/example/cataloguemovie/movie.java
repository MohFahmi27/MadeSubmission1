package com.example.cataloguemovie;

import android.os.Parcel;
import android.os.Parcelable;

public class movie implements Parcelable {
    private String Judul;
    private String Duration;
    private String Genre;
    private String Synopsis;
    private String Rating;
    private int Img_Photo;

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getSynopsis() {
        return Synopsis;
    }

    public void setSynopsis(String synopsis) {
        Synopsis = synopsis;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public int getImg_Photo() {
        return Img_Photo;
    }

    public void setImg_Photo(int img_Photo) {
        Img_Photo = img_Photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Judul);
        dest.writeString(this.Duration);
        dest.writeString(this.Genre);
        dest.writeString(this.Synopsis);
        dest.writeString(this.Rating);
        dest.writeInt(this.Img_Photo);
    }

    public movie() {
    }

    protected movie(Parcel in) {
        this.Judul = in.readString();
        this.Duration = in.readString();
        this.Genre = in.readString();
        this.Synopsis = in.readString();
        this.Rating = in.readString();
        this.Img_Photo = in.readInt();
    }

    public static final Parcelable.Creator<movie> CREATOR = new Parcelable.Creator<movie>() {
        @Override
        public movie createFromParcel(Parcel source) {
            return new movie(source);
        }

        @Override
        public movie[] newArray(int size) {
            return new movie[size];
        }
    };
}
