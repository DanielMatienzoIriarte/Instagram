package com.example.danmat.instagram.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danmat.instagram.R;
import com.example.danmat.instagram.pojo.Pet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>{
    private ArrayList<Pet> petsList;
    private Activity petProfileActivity;

    public ProfileAdapter(ArrayList<Pet> petsList, Activity petProfileActivity) {
        this.petsList = petsList;
        this.petProfileActivity = petProfileActivity;
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_pet, parent, false);

        return new ProfileViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ProfileViewHolder profileViewHolder, int position) {
        final Pet pet = petsList.get(position);

        Picasso.with(petProfileActivity)
                .load(pet.getAvatarUrl())
                .placeholder(R.drawable.dog_avatar)
                .into(profileViewHolder.cardview_avatar);
        profileViewHolder.cardview_rate.setText(String.valueOf(pet.getRate()));
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
