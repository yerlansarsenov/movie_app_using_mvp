package com.example.thousandgroup_mvp.common;


import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import moxy.viewstate.strategy.alias.AddToEnd;
import moxy.viewstate.strategy.alias.AddToEndSingle;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface BaseView extends MvpView {


    void showLoading();


    void hideLoading();


    void showError();


    void showNoInternetConnection();
}
