package com.example.danmat.instagram.presenter;

import android.content.Context;

import com.example.danmat.instagram.db.PetsConstructor;
import com.example.danmat.instagram.fragments.IRecyclerViewTop5View;
import com.example.danmat.instagram.pojo.Pet;

import java.util.ArrayList;

public class Top5RecyclerViewPresenter implements ITop5RecyclerViewPresenter{
    private IRecyclerViewTop5View iRecyclerViewTop5View;
    private Context context;
    private PetsConstructor petsConstructor;
    private ArrayList<Pet> petsList;

    public Top5RecyclerViewPresenter(
            IRecyclerViewTop5View iRecyclerViewTop5View,
            Context context
    ) {
        this.iRecyclerViewTop5View = iRecyclerViewTop5View;
        this.context = context;

        getDatabaseTop5();
    }

    @Override
    public void getDatabaseTop5() {
        petsConstructor = new PetsConstructor(context);
        petsList = petsConstructor.getTop5();
        displayRecyclerViewTop5();
    }

    @Override
    public void displayRecyclerViewTop5() {
        iRecyclerViewTop5View.initializeRVAdapter(iRecyclerViewTop5View.createAdapter(petsList));
        iRecyclerViewTop5View.generateVerticalLinearLayout();
    }
}
