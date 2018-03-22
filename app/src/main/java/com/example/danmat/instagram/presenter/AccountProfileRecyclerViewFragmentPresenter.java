package com.example.danmat.instagram.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.danmat.instagram.db.PetsConstructor;
import com.example.danmat.instagram.fragments.IRecyclerViewAccountProfileView;
import com.example.danmat.instagram.fragments.IRecyclerViewProfileView;
import com.example.danmat.instagram.pojo.Pet;
import com.example.danmat.instagram.restApi.EndpointsApi;
import com.example.danmat.instagram.restApi.adapter.RestApiAdapter;
import com.example.danmat.instagram.restApi.model.PetResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountProfileRecyclerViewFragmentPresenter implements IRecyclerViewAccountProfileFragmentPresenter {
    private IRecyclerViewAccountProfileView iRecyclerViewAccountProfileView;
    private Context context;
    private PetsConstructor petsConstructor;
    private ArrayList<Pet> petsList;

    public AccountProfileRecyclerViewFragmentPresenter(
            IRecyclerViewAccountProfileView iRecyclerViewAccountProfileView,
            Context context
    ) {
        this.iRecyclerViewAccountProfileView = iRecyclerViewAccountProfileView;
        this.context = context;
        getStoredPets();
    }
    @Override
    public void getStoredPets() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonRecentMedia = restApiAdapter.buildPetDeserializer();
        EndpointsApi endpointsApi = restApiAdapter.setRestConnectionInstagramApi(gsonRecentMedia);
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
                Toast.makeText(context, "Try Again, bad connection", Toast.LENGTH_SHORT).show();
                Log.e("Connection failed", t.toString());
            }
        });
    }

    @Override
    public void displayRecyclerViewPets() {
        iRecyclerViewAccountProfileView.initializeRVAdapter(iRecyclerViewAccountProfileView.createAdapter(petsList));
        iRecyclerViewAccountProfileView.generateGridLayout();
    }
}
