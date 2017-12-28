package com.example.danmat.instagram.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.danmat.instagram.R;
import com.example.danmat.instagram.adapters.PetAdapter;
import com.example.danmat.instagram.pojo.Pet;
import com.example.danmat.instagram.presenter.IRecyclerViewFragmentPresenter;
import com.example.danmat.instagram.presenter.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {
    ArrayList<Pet> petsList;
    private RecyclerView petsListRecyclerView;
    private IRecyclerViewFragmentPresenter iRecyclerViewFragmentPresenter;

    public RecyclerViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        FloatingActionButton uploadButton = (FloatingActionButton) v.findViewById(R.id.main_floatingButton);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Upload Photo", Toast.LENGTH_SHORT).show();
            }
        });

        petsListRecyclerView = (RecyclerView) v.findViewById(R.id.main_recyclerView_pets);

        iRecyclerViewFragmentPresenter = new RecyclerViewFragmentPresenter(this, getContext());

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
        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        petsListRecyclerView.setLayoutManager(glm);
    }

    @Override
    public PetAdapter createAdapter(ArrayList<Pet> petsList) {
        PetAdapter petAdapter = new PetAdapter(petsList, getActivity());
        return petAdapter;
    }

    @Override
    public void initializeRVAdapter(PetAdapter petAdapter) {
        petsListRecyclerView.setAdapter(petAdapter);
    }
}








