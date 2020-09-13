package com.example.thousandgroup_mvp.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sarsenov Yerlan on 06.09.2020.
 */
@Entity(tableName = "Film")
public class Film {
    @SerializedName("popularity")
    @ColumnInfo(name = "popularity")
    protected Double popularity;
    @SerializedName("vote_count")
    @ColumnInfo(name = "vote_count")
    protected Integer voteCount;
    @SerializedName("video")
    @ColumnInfo(name = "video")
    protected Boolean video;
    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    protected String posterPath;
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    protected Integer id;
    @SerializedName("adult")
    @ColumnInfo(name = "adult")
    protected Boolean adult;
    @SerializedName("backdrop_path")
    @ColumnInfo(name = "backdrop_path")
    protected String backdropPath;
    @SerializedName("original_language")
    @ColumnInfo(name = "original_language")
    protected String originalLanguage;
    @SerializedName("original_title")
    @ColumnInfo(name = "original_title")
    protected String originalTitle;
    @SerializedName("genre_ids")
    @Ignore
    protected List<Integer> genreIds = null;
    @SerializedName("title")
    @ColumnInfo(name = "title")
    protected String title;
    @SerializedName("vote_average")
    @ColumnInfo(name = "vote_average")
    protected Double voteAverage;
    @SerializedName("overview")
    @ColumnInfo(name = "overview")
    protected String overview;
    @SerializedName("release_date")
    @ColumnInfo(name = "release_date")
    protected String releaseDate;

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
