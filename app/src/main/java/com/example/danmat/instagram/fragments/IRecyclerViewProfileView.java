package com.example.danmat.instagram.fragments;

import com.example.danmat.instagram.adapters.PetAdapter;
import com.example.danmat.instagram.adapters.ProfileAdapter;
import com.example.danmat.instagram.pojo.Pet;

import java.util.ArrayList;

public interface IRecyclerViewProfileView {
    public void generateVerticalLinearLayout();

    public void generateGridLayout();

    public ProfileAdapter createAdapter(ArrayList<Pet> petsList);

    public void initializeRVAdapter(ProfileAdapter petAdapter);
}