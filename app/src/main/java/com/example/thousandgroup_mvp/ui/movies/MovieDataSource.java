package com.example.thousandgroup_mvp.ui.movies;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.thousandgroup_mvp.data.model.Film;

/**
 * Created by Sarsenov Yerlan on 11.09.2020.
 */
public class MovieDataSource extends PageKeyedDataSource<Integer, Film> {

    public static final int PAGE_SIZE = 200;
    public static final int FIRST_PAGE = 1;
    private static final String SITE_NAME = "moviedb";

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Film> callback) {

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Film> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Film> callback) {

    }
}
