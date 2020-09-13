package com.example.thousandgroup_mvp.ui.movies;

import com.example.thousandgroup_mvp.common.BaseView;
import com.example.thousandgroup_mvp.data.model.Film;

import java.util.List;

import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import moxy.viewstate.strategy.alias.AddToEnd;
import moxy.viewstate.strategy.alias.AddToEndSingle;

/**
 * Created by Sarsenov Yerlan on 06.09.2020.
 */
@StateStrategyType(OneExecutionStateStrategy.class)
public interface MoviesView extends BaseView {


    void setMovies(List<Film> films);


    void openMovieDetails(Integer filmId);
}
