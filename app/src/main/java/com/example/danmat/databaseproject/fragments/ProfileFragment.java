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
import com.example.danmat.instagram.adapters.ProfileAdapter;
import com.example.danmat.instagram.pojo.Pet;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    ArrayList<Pet> petsList;
    private RecyclerView petsListRecyclerView;

    public ProfileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        FloatingActionButton uploadButton = (FloatingActionButton) v.findViewById(R.id.profile_floatingButton);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Upload Photo", Toast.LENGTH_SHORT).show();
            }
        });

        petsListRecyclerView = (RecyclerView) v.findViewById(R.id.profile_recyclerView_pets);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(LinearLayoutManager.VERTICAL);

        petsListRecyclerView.setLayoutManager(glm);
        initializePetsList();
        initializeAdapter();

        return v;
    }
    private void initializePetsList(){
        petsList = new ArrayList<Pet>();
        petsList.add(new Pet(11, "profile1", R.drawable.profile1));
        petsList.add(new Pet(12, "profile2", R.drawable.profile2));
        petsList.add(new Pet(13, "profile3", R.drawable.profile3));
        petsList.add(new Pet(14, "profile4", R.drawable.profile4));
        petsList.add(new Pet(15, "profile5", R.drawable.profile5));
        petsList.add(new Pet(16, "profile6", R.drawable.profile6));
        petsList.add(new Pet(17, "profile7", R.drawable.profile7));
        petsList.add(new Pet(18, "profile8", R.drawable.profile8));
    }

    private void initializeAdapter(){
        ProfileAdapter petAdapter = new ProfileAdapter(petsList, getActivity());
        petsListRecyclerView.setAdapter(petAdapter);
    }
}
