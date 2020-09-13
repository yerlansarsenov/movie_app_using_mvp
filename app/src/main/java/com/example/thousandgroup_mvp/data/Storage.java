package com.example.thousandgroup_mvp.data;

import com.example.thousandgroup_mvp.data.db.MovieDao;
import com.example.thousandgroup_mvp.data.model.Film;
import com.example.thousandgroup_mvp.data.model.ResponseResult;

import java.util.List;

/**
 * Created by Sarsenov Yerlan on 06.09.2020.
 */
public class Storage {

    private MovieDao movieDao;

    public Storage(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public void insertFilm(Film film) {
        movieDao.insertFilm(film);
    }

    public void insertFilms(List<Film> films) {
        movieDao.insertFilms(films);
    }

    public List<Film> getFilms() {
        return movieDao.getAllFilms();
    }

    public Film getFilmById(int id) {
        return movieDao.getFilmId(id);
    }

    public void clearFilms() {
        movieDao.clearFilms();
    }

    public interface StorageOwner {
        Storage obtainStorage();
    }
}
