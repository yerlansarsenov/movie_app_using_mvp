package com.example.thousandgroup_mvp.ui.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.thousandgroup_mvp.common.SingleFragmentActivity;
import com.example.thousandgroup_mvp.common.SingleFragmentActivityNotRefreshable;

/**
 * Created by Sarsenov Yerlan on 12.09.2020.
 */
public class MovieDetailActivity extends SingleFragmentActivityNotRefreshable {

    public static final String FILM_ID_KEY = "FILM_ID_KEY";

    @Override
    protected Fragment getFragment() {
        if (getIntent() != null) {
            return MovieDetailFragment.newInstance(getIntent().getBundleExtra(FILM_ID_KEY));
        }
        throw new IllegalStateException("getIntent cannot be null!");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
