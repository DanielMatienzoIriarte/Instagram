package com.example.danmat.instagram.restApi.model;

import com.example.danmat.instagram.pojo.Pet;

import java.util.ArrayList;

public class PetResponse {
    ArrayList<Pet> petsList;

    public ArrayList<Pet> getPetsList() {
        return petsList;
    }

    public void setPetsList(ArrayList<Pet> petsList) {
        this.petsList = petsList;
    }
}
