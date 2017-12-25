package com.example.danmat.instagram.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.danmat.instagram.R;
import com.example.danmat.instagram.adapters.PetAdapter;
import com.example.danmat.instagram.pojo.Pet;

import java.util.ArrayList;

public class RecyclerViewFragmentStatic extends Fragment {
    ArrayList<Pet> petsList;
    private RecyclerView petsListRecyclerView;

    public RecyclerViewFragmentStatic() {
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

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        petsListRecyclerView.setLayoutManager(llm);
        initializePetsList();
        initializeAdapter();

        return v;
    }

    private void initializePetsList(){
        petsList = new ArrayList<Pet>();
        petsList.add(new Pet(1, "Mortis", R.drawable.dog_bark_icon));
        petsList.add(new Pet(2, "Vato Loco", R.drawable.dog_chihuahua_bone_icon));
        petsList.add(new Pet(3, "Gordo", R.drawable.dog_dalmatian_king_icon));
        petsList.add(new Pet(4, "Rita", R.drawable.dog_einstein_icon));
        petsList.add(new Pet(5, "Laika", R.drawable.dog_haski_icon));
        petsList.add(new Pet(6, "Dogo", R.drawable.dog_einstein_icon));
        petsList.add(new Pet(7, "Linda", R.drawable.dog_haski_icon));
    }

    private void initializeAdapter(){
        PetAdapter petAdapter = new PetAdapter(petsList, getActivity());
        petsListRecyclerView.setAdapter(petAdapter);
    }
}
