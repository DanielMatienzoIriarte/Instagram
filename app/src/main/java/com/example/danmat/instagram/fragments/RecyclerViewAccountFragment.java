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
import com.example.danmat.instagram.adapters.ProfileAdapter;
import com.example.danmat.instagram.pojo.Pet;
import com.example.danmat.instagram.presenter.AccountRecyclerViewFragmentPresenter;
import com.example.danmat.instagram.presenter.IRecyclerViewAccountFragmentPresenter;
import com.example.danmat.instagram.restApi.apiConstants;

import java.util.ArrayList;

public class RecyclerViewAccountFragment extends Fragment implements IRecyclerViewProfileView {
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
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        String defaultInstagramAccountUserName = apiConstants.INSTAGRAM_USER_NAME;
        String defaultInstagramAccountUserId = apiConstants.INSTAGRAM_USER_ID;
        String instagramAccountUserName = getArguments().getString("instagramUserName");

        TextView instagramUserNameTextView = (TextView) v.findViewById(R.id.fragmentProfile_textView_name);
        instagramUserNameTextView.setText(instagramAccountUserName);

        instagramPetsListRecyclerView = (RecyclerView) v.findViewById(R.id.profile_recyclerView_pets);

        accountRecyclerViewFragmentPresenter = new AccountRecyclerViewFragmentPresenter(
                this,
                getContext(),
                defaultInstagramAccountUserId
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
    public ProfileAdapter createAdapter(ArrayList<Pet> petsList) {
        return new ProfileAdapter(petsList, getActivity());
    }

    @Override
    public void initializeRVAdapter(ProfileAdapter petAdapter) {
        instagramPetsListRecyclerView.setAdapter(petAdapter);
    }

    /*private String getInstagramAccountUserId(String accountUserName) {
        return "666";
    }*/
}