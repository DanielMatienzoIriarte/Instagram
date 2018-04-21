package com.example.danmat.instagram.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danmat.instagram.PetDetailActivity;
import com.example.danmat.instagram.R;
import com.example.danmat.instagram.db.PetsConstructor;
import com.example.danmat.instagram.pojo.Pet;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>{
    ArrayList<Pet> petsList;
    private Activity petMainActivity;

    public PetAdapter(ArrayList<Pet> petsList, Activity activity){
        this.petsList = petsList;
        this.petMainActivity = activity;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pets, parent, false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PetViewHolder petViewHolder, int position) {
        final PetsConstructor petsConstructor = new PetsConstructor(petMainActivity);
        final Pet pet = petsList.get(position);

        petViewHolder.cardview_avatar.setImageResource(pet.getAvatar());
        petViewHolder.cardview_name.setText(pet.getName());
        petViewHolder.cardview_rate_text.setText(String.valueOf(String.format(Integer.toString(petsConstructor.getPetRate(pet)))));
        petViewHolder.cardview_rate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(petMainActivity, pet.getName() + " liked", Toast.LENGTH_SHORT).show();
                petsConstructor.likePet(pet);
                petViewHolder.cardview_rate_text.setText(String.format(Integer.toString(petsConstructor.getPetRate(pet))));
            }
        });

        petViewHolder.cardview_avatar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent petDetailIntent = new Intent(petMainActivity, PetDetailActivity.class);
                petDetailIntent.putExtra("Avatar", pet.getAvatar());
                petDetailIntent.putExtra("Name", pet.getName());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Explode explodeTransition = new Explode();
                    explodeTransition.setDuration(1000);
                    petMainActivity.getWindow().setExitTransition(explodeTransition);
                    petMainActivity.startActivity(petDetailIntent,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(
                                petMainActivity, v, ""
                            ).toBundle()
                    );
                } else {
                    petMainActivity.startActivity(petDetailIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return petsList.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{
        private ImageView cardview_avatar;
        private TextView cardview_name;
        private TextView cardview_rate_text;
        private ImageButton cardview_rate_button;

        public PetViewHolder(View itemView) {
            super(itemView);

            cardview_avatar = (ImageView) itemView.findViewById(R.id.cardview_imageview_avatar);
            cardview_name = (TextView) itemView.findViewById(R.id.cardview_textview_name);
            cardview_rate_text = (TextView) itemView.findViewById(R.id.cardview_textview_rate_text);
            cardview_rate_button = (ImageButton) itemView.findViewById(R.id.cardview_imagebutton_rate_icon);
        }
    }
}
