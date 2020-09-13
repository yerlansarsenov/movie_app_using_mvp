package com.example.thousandgroup_mvp.common;


import io.reactivex.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

public abstract class BasePresenter<V extends BaseView> extends MvpPresenter<V> {
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void disposeAll() {
        compositeDisposable.clear();
    }
}
