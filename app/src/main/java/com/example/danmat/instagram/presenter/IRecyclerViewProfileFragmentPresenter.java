package com.example.danmat.instagram.presenter;

public interface IRecyclerViewProfileFragmentPresenter {
    public void getStoredPets();

    public void displayRecyclerViewPets();

    public void getAccountStoredPets(String userId);
}