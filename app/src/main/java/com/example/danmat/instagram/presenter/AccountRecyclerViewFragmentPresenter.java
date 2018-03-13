package com.example.danmat.instagram.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.danmat.instagram.db.PetsConstructor;
import com.example.danmat.instagram.fragments.IRecyclerViewAccountView;
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

public class AccountRecyclerViewFragmentPresenter implements IRecyclerViewAccountFragmentPresenter {
    private IRecyclerViewAccountView recyclerViewAccountFragment;
    private Context context;
    private PetsConstructor petsConstructor;
    private ArrayList<Pet> petsList;

    public AccountRecyclerViewFragmentPresenter(
            IRecyclerViewAccountView iRecyclerViewAccountView,
            Context context,
            String instagramAccountUserId
    )
    {
        this.recyclerViewAccountFragment = iRecyclerViewAccountView;
        this.context = context;
        getAccountStoredPets(instagramAccountUserId);
    }
    @Override
    public void getAccountStoredPets(String instagramAccountUserId) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonRecentMedia = restApiAdapter.buildUserDeserializer();
        EndpointsApi urlEndpointsApi = restApiAdapter.setRestConnectionInstagramURL(gsonRecentMedia);
        Call<PetResponse> petResponseCall = urlEndpointsApi.getAccountFullInfoFromUrl(instagramAccountUserId);

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
                Log.e("Account Info error", "Failed retrieving account info" + t.toString());
            }
        });
    }

    @Override
    public void displayRecyclerViewPets() {
        recyclerViewAccountFragment.initializeRVAdapter(recyclerViewAccountFragment.createAdapter(petsList));
        recyclerViewAccountFragment.generateGridLayout();
    }
}
