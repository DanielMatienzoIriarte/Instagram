package com.example.danmat.instagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.danmat.instagram.R;
import com.example.danmat.instagram.pojo.Pet;

import java.util.ArrayList;

public class PetsConstructor {
    private Context context;

    public PetsConstructor(Context context) {
        this.context = context;
    }

    public ArrayList<Pet> getData() {
        DataBase db = new DataBase(context);
        return db.getAll();
    }

    public void insertPet(Pet pet) {
        DataBase db = new DataBase(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseConstants.TABLE_PETS_NAME, pet.getName());
        contentValues.put(DataBaseConstants.TABLE_PETS_AVATAR, pet.getAvatar());

        db.insertPet(contentValues);
    }

    public void likePet(Pet pet) {
        DataBase db = new DataBase(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseConstants.TABLE_RATE_PET_ID, pet.getPetId());
        contentValues.put(DataBaseConstants.TABLE_RATE_VALUE, 1);

        db.insertLikePet(contentValues);
    }

    public int getPetRate(Pet pet) {
        DataBase db = new DataBase(context);
        return db.getPetRate(pet);
    }

    public ArrayList<Pet> getTop5() {
        DataBase db = new DataBase(context);
        return db.getTop5();
    }
}
