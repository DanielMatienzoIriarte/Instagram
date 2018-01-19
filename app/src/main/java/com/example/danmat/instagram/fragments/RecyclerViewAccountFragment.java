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
import com.example.danmat.instagram.adapters.ProfileAdapter;
import com.example.danmat.instagram.pojo.Pet;
import com.example.danmat.instagram.presenter.IRecyclerViewProfileFragmentPresenter;
import com.example.danmat.instagram.presenter.ProfileRecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewAccountFragment extends Fragment implements IRecyclerViewProfileView {
    ArrayList<Pet> petsList;
    private RecyclerView petsListRecyclerView;
    private IRecyclerViewProfileFragmentPresenter iRecyclerViewProfileFragmentPresenter;
    private String accountUserName;

    public RecyclerViewAccountFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        petsListRecyclerView = (RecyclerView) v.findViewById(R.id.profile_recyclerView_pets);
        String accountUserName = "";

        if(getArguments() != null) {
            accountUserName = getArguments().getString("accountUserName");
        }

        iRecyclerViewProfileFragmentPresenter = new ProfileRecyclerViewFragmentPresenter(
                this,
                getContext(),
                accountUserName
        );

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
