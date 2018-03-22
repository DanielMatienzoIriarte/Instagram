package com.example.danmat.instagram.fragments;

import com.example.danmat.instagram.adapters.AccountProfileAdapter;
import com.example.danmat.instagram.pojo.Pet;

import java.util.ArrayList;

public interface IRecyclerViewAccountProfileView {
    public void generateVerticalLinearLayout();

    public void generateGridLayout();

    public AccountProfileAdapter createAdapter(ArrayList<Pet> petsList);

    public void initializeRVAdapter(AccountProfileAdapter petAdapter);
}