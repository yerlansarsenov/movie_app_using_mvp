package com.example.thousandgroup_mvp.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.thousandgroup_mvp.data.model.Film;

import java.util.List;

/**
 * Created by Sarsenov Yerlan on 06.09.2020.
 */
@Dao
public interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFilm(Film film);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFilms(List<Film> films);

    @Query("SELECT * FROM Film")
    List<Film> getAllFilms();

    @Query("SELECT * FROM Film WHERE id = :mId")
    Film getFilmId(int mId);

    @Query("DELETE FROM film")
    void clearFilms();
}
