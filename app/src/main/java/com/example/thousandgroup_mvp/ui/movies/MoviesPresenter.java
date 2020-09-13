package com.example.thousandgroup_mvp.ui.movies;

import android.util.Log;

import com.example.thousandgroup_mvp.BuildConfig;
import com.example.thousandgroup_mvp.common.BasePresenter;
import com.example.thousandgroup_mvp.data.Storage;
import com.example.thousandgroup_mvp.data.model.Film;
import com.example.thousandgroup_mvp.data.model.ResponseResult;
import com.example.thousandgroup_mvp.utils.ApiUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;

/**
 * Created by Sarsenov Yerlan on 06.09.2020.
 */
@InjectViewState
public class MoviesPresenter extends BasePresenter<MoviesView> {

    public static final String TAG = MoviesPresenter.class.getSimpleName();
    private Storage storage;

    public MoviesPresenter(Storage storage) {
        this.storage = storage;
    }

    public void getFilms() {
        compositeDisposable.add(ApiUtils.getApiService()
                .getUpcomingFilms(BuildConfig.API_KEY, 1)
                .doOnSuccess(responseResult -> {
                    List<Film> films = responseResult.getResults();
//                    int cnt = Math.min(films.size(), 10);
//                    storage.clearFilms();
//                    for (int i = 0; i < cnt; i++) {
//                        storage.insertFilm(films.get(i));
//                    }
                    storage.insertFilms(films);
                })
                .onErrorReturn(throwable -> {
                    ResponseResult result = new ResponseResult();
                    if (storage.getFilms() != null && ApiUtils.NETWORK_EXCEPTIONS.contains(throwable.getClass())) {
                        result.setResults(storage.getFilms());
                    } else {
                        return null;
                    }
                    getViewState().showNoInternetConnection();
                    return result;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getViewState().showLoading())
                .doFinally(() -> getViewState().hideLoading())
                .subscribe(responseResult -> getViewState().setMovies(responseResult.getResults()),
                        throwable -> {
                            getViewState().showError();
                            Log.e(TAG, "getFilms: ".concat(throwable.getMessage()));
                        }));
    }

    public void openDetailFragment(Integer filmId) {
        getViewState().openMovieDetails(filmId);
    }

}
