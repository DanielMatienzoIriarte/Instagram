package com.example.danmat.instagram.fragments;

import com.example.danmat.instagram.adapters.AccountAdapter;
import com.example.danmat.instagram.adapters.ProfileAdapter;
import com.example.danmat.instagram.adapters.petagramAdapterInterface;
import com.example.danmat.instagram.pojo.Pet;

import java.util.ArrayList;

public interface IRecyclerViewAccountView {
    public void generateVerticalLinearLayout();

    public void generateGridLayout();

    public AccountAdapter createAdapter(ArrayList<Pet> petsList);

    public void initializeRVAdapter(AccountAdapter petAdapter);
}
