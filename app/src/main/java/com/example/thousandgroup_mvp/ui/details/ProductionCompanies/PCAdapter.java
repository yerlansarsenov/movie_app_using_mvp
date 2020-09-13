package com.example.thousandgroup_mvp.ui.details.ProductionCompanies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thousandgroup_mvp.R;
import com.example.thousandgroup_mvp.data.model.DetailsModels.ProductionCompany;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarsenov Yerlan on 13.09.2020.
 */
public class PCAdapter extends RecyclerView.Adapter<PCHolder> {

    List<ProductionCompany> companies = new ArrayList<>();

    public void setList(List<ProductionCompany> companies) {
        this.companies = companies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PCHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.li_production_company, parent, false);
        return new PCHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PCHolder holder, int position) {
        holder.bind(companies.get(position));
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }
}
