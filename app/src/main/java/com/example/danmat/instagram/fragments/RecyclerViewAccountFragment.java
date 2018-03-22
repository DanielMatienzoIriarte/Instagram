package com.example.danmat.instagram.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danmat.instagram.R;
import com.example.danmat.instagram.adapters.AccountAdapter;
import com.example.danmat.instagram.adapters.ProfileAdapter;
import com.example.danmat.instagram.adapters.petagramAdapterInterface;
import com.example.danmat.instagram.pojo.Pet;
import com.example.danmat.instagram.presenter.AccountRecyclerViewFragmentPresenter;
import com.example.danmat.instagram.presenter.IRecyclerViewAccountFragmentPresenter;
import com.example.danmat.instagram.restApi.apiConstants;

import java.util.ArrayList;

public class RecyclerViewAccountFragment extends Fragment implements IRecyclerViewAccountView {
    ArrayList<Pet> petsList;
    private RecyclerView instagramPetsListRecyclerView;
    private IRecyclerViewAccountFragmentPresenter accountRecyclerViewFragmentPresenter;
    private String accountUserName;

    public RecyclerViewAccountFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.account_profile_fragment, container, false);

        String defaultInstagramAccountUserName = apiConstants.INSTAGRAM_USER_NAME;
        String defaultInstagramAccountUserId = apiConstants.INSTAGRAM_USER_ID;
        String instagramAccountUserName = getArguments().getString("instagramUserName");

        TextView instagramUserNameTextView = (TextView) v.findViewById(R.id.fragmentAccountProfile_textView_name);
        instagramUserNameTextView.setText(instagramAccountUserName);

        instagramPetsListRecyclerView = (RecyclerView) v.findViewById(R.id.accountProfile_recyclerView_pets);

        accountRecyclerViewFragmentPresenter = new AccountRecyclerViewFragmentPresenter(
                this,
                getContext(),
                instagramAccountUserName
        );

        return v;
    }

    @Override
    public void generateVerticalLinearLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        instagramPetsListRecyclerView.setLayoutManager(llm);
    }

    @Override
    public void generateGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        instagramPetsListRecyclerView.setLayoutManager(glm);
    }

    @Override
    public AccountAdapter createAdapter(ArrayList<Pet> petsList) {
        return new AccountAdapter(petsList, getActivity());
    }

    @Override
    public void initializeRVAdapter(AccountAdapter userAdapter) {
        instagramPetsListRecyclerView.setAdapter(userAdapter);
    }
}