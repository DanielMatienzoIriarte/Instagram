package com.example.danmat.instagram.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.danmat.instagram.R;
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
        getDatabasePets();
    }

    @Override
    public void getDatabasePets() {
        petsConstructor = new PetsConstructor(context);
        petsList = petsConstructor.getData();
        displayRecyclerViewPets();
    }

    @Override
    public void displayRecyclerViewPets() {
        iRecyclerViewFragmentView.initializeRVAdapter(iRecyclerViewFragmentView.createAdapter(petsList));
        iRecyclerViewFragmentView.generateVerticalLinearLayout();
        //iRecyclerViewFragmentView.generateGridLayout();
    }

    @Override
    public void getRecentMedia() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpointsApi = restApiAdapter.setRestConnectionInstagramApi();
        Call<PetResponse> petResponseCall = endpointsApi.getRecentMedia();

        petResponseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
                PetResponse petResponse = response.body();
                petsList = petResponse.getPetsList();
                displayRecyclerViewPets();
            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Toast.makeText(context, "Data retrieval failed", Toast.LENGTH_LONG).show();
                Log.e("Bad conection", t.toString());
            }
        });
    }
}
