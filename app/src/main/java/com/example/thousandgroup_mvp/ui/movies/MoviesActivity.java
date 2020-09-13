package com.example.thousandgroup_mvp.ui.movies;

import androidx.fragment.app.Fragment;

import com.example.thousandgroup_mvp.common.SingleFragmentActivity;

/**
 * Created by Sarsenov Yerlan on 06.09.2020.
 */
public class MoviesActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return MoviesFragment.newInstance();
    }
}
