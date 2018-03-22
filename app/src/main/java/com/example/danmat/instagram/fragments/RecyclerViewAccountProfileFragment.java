package com.example.danmat.instagram.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.danmat.instagram.R;
import com.example.danmat.instagram.adapters.AccountProfileAdapter;
import com.example.danmat.instagram.pojo.Pet;
import com.example.danmat.instagram.presenter.IRecyclerViewAccountProfileFragmentPresenter;
import com.example.danmat.instagram.presenter.AccountProfileRecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewAccountProfileFragment extends Fragment implements IRecyclerViewAccountProfileView {
    ArrayList<Pet> petsList;
    private RecyclerView petsListRecyclerView;
    private IRecyclerViewAccountProfileFragmentPresenter iRecyclerViewAccountProfileFragmentPresenter;

    public RecyclerViewAccountProfileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.account_profile_fragment, container, false);

        petsListRecyclerView = (RecyclerView) v.findViewById(R.id.accountProfile_recyclerView_pets);

        iRecyclerViewAccountProfileFragmentPresenter = new AccountProfileRecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generateVerticalLinearLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        petsListRecyclerView.setLayoutManager(llm);
    }

    @Override
    public void generateGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        petsListRecyclerView.setLayoutManager(glm);
    }

    @Override
    public AccountProfileAdapter createAdapter(ArrayList<Pet> petsList) {
        return new AccountProfileAdapter(petsList, getActivity());
    }

    @Override
    public void initializeRVAdapter(AccountProfileAdapter petAdapter) {
        petsListRecyclerView.setAdapter(petAdapter);
    }
}
