package com.example.danmat.instagram.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danmat.instagram.R;
import com.example.danmat.instagram.pojo.Pet;
import com.example.danmat.instagram.restApi.EndpointsApi;
import com.example.danmat.instagram.restApi.adapter.RestApiAdapter;
import com.example.danmat.instagram.restApi.model.InstagramLikeResponse;
import com.example.danmat.instagram.restApi.model.PetResponse;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ProfileViewHolder>{
    private ArrayList<Pet> petsList;
    private Activity userAccountActivity;

    public AccountAdapter(ArrayList<Pet> petsList, Activity userProfileActivity) {
        this.petsList = petsList;
        this.userAccountActivity = userProfileActivity;
    }

    @Override
    public AccountAdapter.ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_pet, parent, false);

        return new AccountAdapter.ProfileViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AccountAdapter.ProfileViewHolder profileViewHolder, int position) {
        final Pet pet = petsList.get(position);

        Picasso.with(userAccountActivity)
                .load(pet.getAvatarUrl().replace("\"", ""))
                .placeholder(R.drawable.dog_avatar)
                .into(profileViewHolder.cardview_avatar);
        profileViewHolder.cardview_rate.setText(String.valueOf(pet.getRate()));

        profileViewHolder.cardview_avatar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RestApiAdapter restApiAdapter = new RestApiAdapter();
                Gson gsonRecentMedia = restApiAdapter.buildPetLikeDeserializer();
                EndpointsApi urlEndpointsApi = restApiAdapter.setRestConnectionInstagramLike(gsonRecentMedia);
                Call<InstagramLikeResponse> petLikeResponseCall = urlEndpointsApi.likeMedia(Long.toString(pet.getPetId()));

                petLikeResponseCall.enqueue(new Callback<InstagramLikeResponse>() {
                    @Override
                    public void onResponse(Call<InstagramLikeResponse> call, Response<InstagramLikeResponse> response) {
                        InstagramLikeResponse petResponse = response.body();
                        //TODO update likes rate
                        //String success = petResponse.getCode();
                    }

                    @Override
                    public void onFailure(Call<InstagramLikeResponse> call, Throwable t) {
                        Toast.makeText(userAccountActivity, "Try Again, bad connection, account error while hitting likes", Toast.LENGTH_SHORT).show();
                        Log.e("Account Info error", "Failed retrieving account info" + t.toString());
                    }
                });

                Toast.makeText(userAccountActivity, (String.valueOf(pet.getPetId())) + " likedddd", Toast.LENGTH_SHORT).show();
                Log.i("Instagram Account ID", "ID:" + String.valueOf(pet.getPetId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return petsList.size();
    }

    public static class ProfileViewHolder extends RecyclerView.ViewHolder{
        private ImageView cardview_avatar;
        private TextView cardview_rate;

        public ProfileViewHolder(View itemView) {
            super(itemView);

            cardview_avatar = (ImageView) itemView.findViewById(R.id.cardview_profile_imageview_avatar);
            cardview_rate = (TextView) itemView.findViewById(R.id.cardview_profile_textview_rate_text);
        }
    }
}
