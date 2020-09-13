package com.example.thousandgroup_mvp.ui.details.ProductionCompanies;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thousandgroup_mvp.BuildConfig;
import com.example.thousandgroup_mvp.R;
import com.example.thousandgroup_mvp.data.model.DetailsModels.ProductionCompany;
import com.squareup.picasso.Picasso;

/**
 * Created by Sarsenov Yerlan on 13.09.2020.
 */
public class PCHolder extends RecyclerView.ViewHolder {
    TextView nameTV;
    ImageView logoIV;

    public PCHolder(@NonNull View itemView) {
        super(itemView);
        nameTV = itemView.findViewById(R.id.name_of_company);
        logoIV = itemView.findViewById(R.id.logo_of_company);
    }

    public void bind(ProductionCompany company) {
        nameTV.setText(company.getName());
        if (company.getLogoPath() != null) {
            Picasso.get().load(BuildConfig.IMAGE_BASE_URL.concat(company.getLogoPath()))
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.place)
                    .into(logoIV);
        }
    }
}
