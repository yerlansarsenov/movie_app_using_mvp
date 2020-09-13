package com.example.thousandgroup_mvp.ui.movies;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.example.thousandgroup_mvp.R;
import com.example.thousandgroup_mvp.data.model.Film;

/**
 * Created by Sarsenov Yerlan on 10.09.2020.
 */
public class MoviesPagedAdapter extends PagedListAdapter<Film, MoviesHolder> {

    Context context;
    protected MoviesPagedAdapter(Context context) {
        super(CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public MoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.li_films, parent, false);
        return new MoviesHolder(view);
    }

    private static DiffUtil.ItemCallback<Film> CALLBACK = new DiffUtil.ItemCallback<Film>() {
        @Override
        public boolean areItemsTheSame(@NonNull Film oldItem, @NonNull Film newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Film oldItem, @NonNull Film newItem) {
            return oldItem.equals(newItem);
        }
    };

    @Override
    public void onBindViewHolder(@NonNull MoviesHolder holder, int position) {
        Film film = getItem(position);
        if (film != null) {
            holder.bind(film, new MoviesAdapter.OnFilmClickListener() {
                @Override
                public void onFilmClick(Integer filmId) {

                }
            });
        }
    }
}
