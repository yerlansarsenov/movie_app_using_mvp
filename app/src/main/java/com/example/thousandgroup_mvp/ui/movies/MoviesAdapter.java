package com.example.thousandgroup_mvp.ui.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thousandgroup_mvp.R;
import com.example.thousandgroup_mvp.data.model.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarsenov Yerlan on 06.09.2020.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesHolder> {

    List<Film> films = new ArrayList<>();
    OnFilmClickListener listener;

    public MoviesAdapter(OnFilmClickListener listener) {
        this.listener = listener;
    }

    public void setData(List<Film> films, boolean needToClear) {
        if (films == null) {
            return;
        }
        if (needToClear) {
            this.films.clear();
        }
        this.films.addAll(films);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.li_films, parent,false);
        return new MoviesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesHolder holder, int position) {
        Film film = films.get(position);
        holder.bind(film, listener);
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    interface OnFilmClickListener {
        void onFilmClick(Integer filmId);
    }
}
