package com.example.danmat.instagram.presenter;

import android.content.Context;

import com.example.danmat.instagram.R;
import com.example.danmat.instagram.db.PetsConstructor;
import com.example.danmat.instagram.fragments.IRecyclerViewFragmentView;
import com.example.danmat.instagram.pojo.Pet;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private PetsConstructor petsConstructor;
    private ArrayList<Pet> petsList;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        insertPets();
        getDatabasePets();
    }

    public void insertPets() {
        Pet pet1 = new Pet(1, "Mortis", R.drawable.dog_bark_icon);
        Pet pet2 = new Pet(2, "Vato Loco", R.drawable.dog_chihuahua_bone_icon);
        Pet pet3 = new Pet(3, "Gordo", R.drawable.dog_dalmatian_king_icon);
        Pet pet4 = new Pet(4, "Rita", R.drawable.dog_einstein_icon);
        Pet pet5 = new Pet(5, "Laika", R.drawable.dog_haski_icon);
        Pet pet6 = new Pet(6, "Dogo", R.drawable.dog_einstein_icon);
        Pet pet7 = new Pet(7, "Linda", R.drawable.dog_haski_icon);

        petsConstructor = new PetsConstructor(context);
        petsConstructor.insertPet(pet1);
        petsConstructor.insertPet(pet3);
        petsConstructor.insertPet(pet2);
        petsConstructor.insertPet(pet4);
        petsConstructor.insertPet(pet5);
        petsConstructor.insertPet(pet6);
        petsConstructor.insertPet(pet7);
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
    }
}
