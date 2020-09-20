package com.example.thousandgroup_mvp.ui.movies;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thousandgroup_mvp.BuildConfig;
import com.example.thousandgroup_mvp.R;
import com.example.thousandgroup_mvp.data.model.Film;
import com.squareup.picasso.Picasso;

/**
 * Created by Sarsenov Yerlan on 07.09.2020.
 */
public class MoviesHolder extends RecyclerView.ViewHolder {
    private ImageView mainIV;
    private TextView titleTV;
    private TextView releaseTV;
    private RatingBar ratingBar;
    public MoviesHolder(@NonNull View itemView) {
        super(itemView);
        mainIV = itemView.findViewById(R.id.item_image_view);
        titleTV = itemView.findViewById(R.id.title_view);
        releaseTV = itemView.findViewById(R.id.relies_view);
        ratingBar = itemView.findViewById(R.id.rate_view);
    }

    public void bind(Film film, MoviesAdapter.OnFilmClickListener listener) {
        titleTV.setText(film.getOriginalTitle());
        releaseTV.setText(film.getReleaseDate());
        ratingBar.setRating(((float)film.getVoteAverage().doubleValue())/2);
        if (film.getBackdropPath() != null) {
            Picasso.get().load(BuildConfig.IMAGE_BASE_URL.concat(film.getBackdropPath()))
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.place)
                    .into(mainIV);
        } else if (film.getPosterPath() != null) {
            Picasso.get().load(BuildConfig.IMAGE_BASE_URL.concat(film.getPosterPath()))
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.place)
                    .into(mainIV);
        }
        if (listener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onFilmClick(film.getId());
                }
            });
        }
    }
}
