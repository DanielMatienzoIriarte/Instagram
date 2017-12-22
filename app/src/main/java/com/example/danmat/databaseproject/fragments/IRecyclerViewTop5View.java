package com.example.danmat.instagram.fragments;

import com.example.danmat.instagram.adapters.Top5Adapter;
import com.example.danmat.instagram.pojo.Pet;

import java.util.ArrayList;

public interface IRecyclerViewTop5View {
    public void generateVerticalLinearLayout();

    public Top5Adapter createAdapter(ArrayList<Pet> petsList);

    public void initializeRVAdapter(Top5Adapter top5Adapter);
}
