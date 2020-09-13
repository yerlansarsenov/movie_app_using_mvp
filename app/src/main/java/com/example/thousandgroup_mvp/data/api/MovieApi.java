package com.example.thousandgroup_mvp.data.api;

import com.example.thousandgroup_mvp.data.model.FilmWithDetails;
import com.example.thousandgroup_mvp.data.model.ResponseResult;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Sarsenov Yerlan on 06.09.2020.
 */
public interface MovieApi {
    @GET("movie/upcoming")
    Single<ResponseResult> getUpcomingFilms(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("movie/{movie_id}")
    Single<FilmWithDetails> getFilmById(@Path("movie_id") int id, @Query("api_key") String apiKey);
}
