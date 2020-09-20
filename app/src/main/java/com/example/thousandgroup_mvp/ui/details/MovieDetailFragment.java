package com.example.thousandgroup_mvp.ui.details;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thousandgroup_mvp.BuildConfig;
import com.example.thousandgroup_mvp.R;
import com.example.thousandgroup_mvp.common.PresenterFragment;
import com.example.thousandgroup_mvp.common.RefreshOwner;
import com.example.thousandgroup_mvp.common.Refreshable;
import com.example.thousandgroup_mvp.data.Storage;
import com.example.thousandgroup_mvp.data.model.DetailsModels.Genre;
import com.example.thousandgroup_mvp.data.model.Film;
import com.example.thousandgroup_mvp.data.model.FilmWithDetails;
import com.example.thousandgroup_mvp.ui.details.ProductionCompanies.PCAdapter;
import com.example.thousandgroup_mvp.utils.GenresKeyValue;
import com.squareup.picasso.Picasso;

import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

/**
 * Created by Sarsenov Yerlan on 12.09.2020.
 */
public class MovieDetailFragment extends PresenterFragment implements MovieDetailView {

    public static final String FILM_ID_KEY = "FILM_ID_KEY";
    public static final String TAG = MovieDetailFragment.class.getSimpleName();
    int filmId;
    @InjectPresenter
    MovieDetailPresenter presenter;

    private PCAdapter adapter;

    private View errorView;
    private View detailView;
    private RatingBar rateView;
    private TextView titleView;
    private TextView reliesView;
    private TextView overView;
    private TextView genresView;
    private ImageView imageView;
    private RecyclerView recyclerView;

    @ProvidePresenter
    MovieDetailPresenter providePresenter() {
        return new MovieDetailPresenter();
    }
    public static MovieDetailFragment newInstance(Bundle args) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        errorView = view.findViewById(R.id.error_view);
        detailView = view.findViewById(R.id.view_detail);
        rateView = view.findViewById(R.id.rate_view_detail);
        titleView = view.findViewById(R.id.title_view_detail);
        reliesView = view.findViewById(R.id.relies_view_detail);
        overView = view.findViewById(R.id.over_detail);
        imageView = view.findViewById(R.id.image_detail);
        genresView = view.findViewById(R.id.genres);
        recyclerView = view.findViewById(R.id.prod_comp_rv);
        adapter = new PCAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()) /*{
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        }*/);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            filmId = getArguments().getInt(FILM_ID_KEY);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        detailView.setVisibility(View.VISIBLE);
        presenter.showFilmById(filmId);
    }


    @Override
    protected MovieDetailPresenter getPresenter() {
        return presenter;
    }

/*--------Refreshable method--------------------------------------------*/


/*--------------------------------------------------------------------------*/

/*--------MovieDetailView method--------------------------------------------*/

    @Override
    public void showDetails(FilmWithDetails film) {
        errorView.setVisibility(View.GONE);
        detailView.setVisibility(View.VISIBLE);
        if (getActivity() != null) {
            getActivity().setTitle(film.getTitle());
        }
        bind(film);
    }

    private void bind(FilmWithDetails film) {
        titleView.setText(film.getTitle());
        reliesView.setText(film.getReleaseDate());
        rateView.setRating(((float)film.getVoteAverage().doubleValue())/2);
        overView.setText(film.getOverview());
        String genres = "Genres: ";
        int cnt = 1;
        for (Genre g : film.getGenres()) {
            genres = genres.concat(g.getName());
            if (!(cnt == film.getGenres().size())) {
                genres = genres.concat(",\n");
            }
            cnt++;
        }
        genresView.setText(genres);
        if (film.getPosterPath() != null) {
            Picasso.get().load(BuildConfig.IMAGE_BASE_URL.concat(film.getPosterPath()))
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.place)
                    .into(imageView);
        } else if (film.getBackdropPath() != null) {
            Picasso.get().load(BuildConfig.IMAGE_BASE_URL.concat(film.getBackdropPath()))
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.place)
                    .into(imageView);
        }
        adapter.setList(film.getProductionCompanies());
    }

    /*--------------------------------------------------------------------------*/

/*--------BaseView method--------------------------------------------*/

    @Override
    public void showLoading() {
        // no refresh
    }

    @Override
    public void hideLoading() {
        // no refresh
    }

    @Override
    public void showError() {
        errorView.setVisibility(View.VISIBLE);
        detailView.setVisibility(View.GONE);
    }

    @Override
    public void showNoInternetConnection() {
        Toast.makeText(getActivity(), "no internet connection", Toast.LENGTH_SHORT).show();
    }

/*--------------------------------------------------------------------------*/

}
