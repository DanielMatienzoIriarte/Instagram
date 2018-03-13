package com.example.danmat.instagram.adapters;

import android.view.ViewGroup;

public interface petagramAdapterInterface {
    public AccountAdapter.ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    public void onBindViewHolder(final AccountAdapter.ProfileViewHolder profileViewHolder, int position);

    public int getItemCount();
}
