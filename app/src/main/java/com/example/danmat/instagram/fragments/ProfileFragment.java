package com.example.danmat.instagram.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.danmat.instagram.R;
import com.example.danmat.instagram.adapters.PetAdapter;
import com.example.danmat.instagram.adapters.ProfileAdapter;
import com.example.danmat.instagram.pojo.Pet;
import com.example.danmat.instagram.presenter.IRecyclerViewProfileFragmentPresenter;
import com.example.danmat.instagram.presenter.ProfileRecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class ProfileFragment extends Fragment implements IRecyclerViewProfileView {
    ArrayList<Pet> petsList;
    private RecyclerView petsListRecyclerView;
    private IRecyclerViewProfileFragmentPresenter iRecyclerViewProfileFragmentPresenter;

    public ProfileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        petsListRecyclerView = (RecyclerView) v.findViewById(R.id.profile_recyclerView_pets);

        iRecyclerViewProfileFragmentPresenter = new ProfileRecyclerViewFragmentPresenter(this, getContext());

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
    public ProfileAdapter createAdapter(ArrayList<Pet> petsList) {
        return new ProfileAdapter(petsList, getActivity());
    }

    @Override
    public void initializeRVAdapter(ProfileAdapter petAdapter) {
        petsListRecyclerView.setAdapter(petAdapter);
    }
}
