package com.example.tugas10;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("results")
    private List<Movie> results = null;

    public List<Movie> getResults() {
        return results;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;
}
