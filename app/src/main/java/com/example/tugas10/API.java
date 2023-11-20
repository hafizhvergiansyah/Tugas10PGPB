package com.example.tugas10;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    @GET("/3/movie/{category}")
    Call<Movie> getMovie(
            @Path("category") String category,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") int page
    );
}
