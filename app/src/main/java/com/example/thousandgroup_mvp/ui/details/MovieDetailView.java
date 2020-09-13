package com.example.thousandgroup_mvp.ui.details;

import com.example.thousandgroup_mvp.common.BaseView;
import com.example.thousandgroup_mvp.data.model.Film;
import com.example.thousandgroup_mvp.data.model.FilmWithDetails;

import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

/**
 * Created by Sarsenov Yerlan on 12.09.2020.
 */
@StateStrategyType(OneExecutionStateStrategy.class)
public interface MovieDetailView extends BaseView {

    void showDetails(FilmWithDetails film);

}
