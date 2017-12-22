package com.example.danmat.instagram.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
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

public class Top5Adapter extends RecyclerView.Adapter<Top5Adapter.Top5ViewHolder>{
    ArrayList<Pet> petsList;
    private Activity top5Activity;

    public Top5Adapter(ArrayList<Pet> petsList, Activity top5Activity) {
        this.petsList = petsList;
        this.top5Activity = top5Activity;
    }

    @Override
    public Top5ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_top5, parent, false);
        return new Top5ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final Top5ViewHolder top5ViewHolder, int position) {
        final PetsConstructor petsConstructor = new PetsConstructor(top5Activity);
        final Pet pet = petsList.get(position);

        top5ViewHolder.cardview_avatar.setImageResource(pet.getAvatar());
        top5ViewHolder.cardview_name.setText(pet.getName());
        top5ViewHolder.cardview_rate_text.setText(String.valueOf(String.format(Integer.toString(petsConstructor.getPetRate(pet)))));
    }

    @Override
    public int getItemCount() {
        return petsList.size();
    }

    public static class Top5ViewHolder extends RecyclerView.ViewHolder{
        private ImageView cardview_avatar;
        private TextView cardview_name;
        private TextView cardview_rate_text;

        public Top5ViewHolder(View itemView) {
            super(itemView);

            cardview_avatar = (ImageView) itemView.findViewById(R.id.cardview_top5_imageview_avatar);
            cardview_name = (TextView) itemView.findViewById(R.id.cardview_top5_textview_name);
            cardview_rate_text = (TextView) itemView.findViewById(R.id.cardview_top5_textview_rate_text);
        }
    }
}
