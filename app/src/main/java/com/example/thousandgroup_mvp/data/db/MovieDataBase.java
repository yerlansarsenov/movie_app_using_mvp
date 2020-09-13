package com.example.thousandgroup_mvp.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.thousandgroup_mvp.data.model.Film;

/**
 * Created by Sarsenov Yerlan on 06.09.2020.
 */

@Database(entities = {Film.class}, version = 1)
public abstract class MovieDataBase extends RoomDatabase {
    public abstract MovieDao getMovieDao();
}
