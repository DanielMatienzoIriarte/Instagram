package com.example.danmat.instagram.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.danmat.instagram.db.PetsConstructor;
import com.example.danmat.instagram.fragments.IRecyclerViewFragmentView;
import com.example.danmat.instagram.pojo.Pet;
import com.example.danmat.instagram.restApi.EndpointsApi;
import com.example.danmat.instagram.restApi.adapter.RestApiAdapter;
import com.example.danmat.instagram.restApi.model.PetResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private PetsConstructor petsConstructor;
    private ArrayList<Pet> petsList;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        getStoredPets();
    }

    @Override
    public void getStoredPets() {
        petsConstructor = new PetsConstructor(context);
        petsList = petsConstructor.getData();
        displayRecyclerViewPets();
    }

    @Override
    public void displayRecyclerViewPets() {
        iRecyclerViewFragmentView.initializeRVAdapter(iRecyclerViewFragmentView.createAdapter(petsList));
        iRecyclerViewFragmentView.generateVerticalLinearLayout();
    }
}
