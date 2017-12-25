package com.example.danmat.instagram.fragments;

import com.example.danmat.instagram.adapters.PetAdapter;
import com.example.danmat.instagram.pojo.Pet;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {
    public void generateVerticalLinearLayout();

    public PetAdapter createAdapter(ArrayList<Pet> petsList);

    public void initializeRVAdapter(PetAdapter petAdapter);
}
