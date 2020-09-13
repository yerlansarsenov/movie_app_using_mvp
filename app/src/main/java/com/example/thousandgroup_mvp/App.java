package com.example.thousandgroup_mvp;

import android.app.Application;

import androidx.room.Room;

import com.example.thousandgroup_mvp.data.Storage;
import com.example.thousandgroup_mvp.data.db.MovieDataBase;

/**
 * Created by Sarsenov Yerlan on 06.09.2020.
 */
public class App extends Application {

    private Storage storage;

    @Override
    public void onCreate() {
        super.onCreate();
        MovieDataBase dataBase = Room.databaseBuilder(this, MovieDataBase.class, "com.example.thousandgroup_mvp.movie_database")
                .fallbackToDestructiveMigration()
                .build();
        storage = new Storage(dataBase.getMovieDao());
    }

    public Storage getStorage() {
        return storage;
    }
}
