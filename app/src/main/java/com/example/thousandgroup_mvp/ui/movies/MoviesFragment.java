package com.example.thousandgroup_mvp.ui.movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thousandgroup_mvp.R;
import com.example.thousandgroup_mvp.common.BasePresenter;
import com.example.thousandgroup_mvp.common.PresenterFragment;
import com.example.thousandgroup_mvp.common.RefreshOwner;
import com.example.thousandgroup_mvp.common.Refreshable;
import com.example.thousandgroup_mvp.data.Storage;
import com.example.thousandgroup_mvp.data.model.Film;
import com.example.thousandgroup_mvp.ui.details.MovieDetailActivity;
import com.example.thousandgroup_mvp.ui.details.MovieDetailFragment;

import java.util.List;

import moxy.InjectViewState;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

/**
 * Created by Sarsenov Yerlan on 06.09.2020.
 */
public class MoviesFragment extends PresenterFragment implements MoviesView, Refreshable, MoviesAdapter.OnFilmClickListener {

    public static final String TAG = MoviesFragment.class.getSimpleName();
    private Storage storage;
    private RefreshOwner refreshOwner;
    private MoviesAdapter adapter;

    private RecyclerView recyclerView;
    private View errorView;

    @InjectPresenter
    MoviesPresenter presenter;

    @ProvidePresenter
    protected MoviesPresenter providePresenter() {
        return new MoviesPresenter(storage);
    }

    public static MoviesFragment newInstance() {
        Bundle args = new Bundle();
        MoviesFragment fragment = new MoviesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        storage = context instanceof Storage.StorageOwner
                ? ((Storage.StorageOwner) context).obtainStorage() : null;
        refreshOwner = context instanceof RefreshOwner
                ? ((RefreshOwner) context) : null;
    }

    @Override
    protected MoviesPresenter getPresenter() {
        return presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler);
        errorView = view.findViewById(R.id.error_view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            getActivity().setTitle("Upcoming movies");
        }
        adapter = new MoviesAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        presenter.getFilms();
    }

    @Override
    public void onDetach() {
        storage = null;
        refreshOwner = null;
        super.onDetach();
    }
/*-----------start implementing BaseView interface--------------------------------------*/
    @Override
    public void showLoading() {
        refreshOwner.setRefreshState(true);
    }

    @Override
    public void hideLoading() {
        refreshOwner.setRefreshState(false);
    }

    @Override
    public void showError() {
        errorView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showNoInternetConnection() {
        Toast.makeText(getActivity(), "no internet connection", Toast.LENGTH_SHORT).show();
    }

/*-------------------------------------------------------------------------------------*/

/*-----------start implementing MovieView interface--------------------------------------*/

    @Override
    public void setMovies(List<Film> films) {
        errorView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        adapter.setData(films, false);
        Log.e(TAG, "setMovies: here we go ".concat(String.valueOf(films.size())));
        /* todo: in future to page list will use pagedAdapter
         * MoviesPagedAdapter pagedAdapter = new MoviesPagedAdapter(getActivity());*/
    }

    @Override
    public void openMovieDetails(Integer filmId) {
        // todo: start movieDetail activity
        Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
        Bundle args = new Bundle();
        args.putInt(MovieDetailFragment.FILM_ID_KEY,filmId);
        intent.putExtra(MovieDetailActivity.FILM_ID_KEY, args);
        startActivity(intent);
    }

/*-------------------------------------------------------------------------------------*/

/*-----------start implementing Refreshable interface--------------------------------------*/

    @Override
    public void onRefreshData() {
        presenter.getFilms();
    }

    @Override
    public void onFilmClick(Integer filmId) {
        presenter.openDetailFragment(filmId);
    }
    /*-------------------------------------------------------------------------------------*/

}
