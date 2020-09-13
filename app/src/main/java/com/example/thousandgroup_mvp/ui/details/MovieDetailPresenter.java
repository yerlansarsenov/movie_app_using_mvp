package com.example.thousandgroup_mvp.ui.details;

import com.example.thousandgroup_mvp.BuildConfig;
import com.example.thousandgroup_mvp.common.BasePresenter;
import com.example.thousandgroup_mvp.data.Storage;
import com.example.thousandgroup_mvp.data.model.Film;
import com.example.thousandgroup_mvp.data.model.FilmWithDetails;
import com.example.thousandgroup_mvp.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;

/**
 * Created by Sarsenov Yerlan on 12.09.2020.
 */
@InjectViewState
public class MovieDetailPresenter extends BasePresenter<MovieDetailView> {

    public MovieDetailPresenter() {
    }

    public void showFilmById(int id) {
        // the following is going on on mainThread (bad practice)
//        Film film = storage.getFilmById(id);
//        getViewState().showDetails(film);
        compositeDisposable.add(ApiUtils.getApiService()
                .getFilmById(id, BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getViewState().showLoading())
                .doFinally(() -> getViewState().hideLoading())
                .subscribe(filmWithDetails -> {
                    getViewState().showDetails(filmWithDetails);
                }, throwable -> {
                    getViewState().showError();
                })
        );
    }

}
