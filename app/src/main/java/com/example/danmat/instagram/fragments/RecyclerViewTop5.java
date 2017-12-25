package com.example.danmat.instagram.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.danmat.instagram.R;
import com.example.danmat.instagram.adapters.PetAdapter;
import com.example.danmat.instagram.adapters.Top5Adapter;
import com.example.danmat.instagram.pojo.Pet;
import com.example.danmat.instagram.presenter.IRecyclerViewFragmentPresenter;
import com.example.danmat.instagram.presenter.ITop5RecyclerViewPresenter;
import com.example.danmat.instagram.presenter.RecyclerViewFragmentPresenter;
import com.example.danmat.instagram.presenter.Top5RecyclerViewPresenter;

import java.util.ArrayList;

public class RecyclerViewTop5 extends Fragment implements IRecyclerViewTop5View{
    ArrayList<Pet> petsList;
    private RecyclerView petsListRecyclerView;
    private ITop5RecyclerViewPresenter iTop5RecyclerViewPresenter;

    public RecyclerViewTop5() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view_top5, container, false);

        petsListRecyclerView = (RecyclerView) v.findViewById(R.id.main_recyclerView_top5);

        iTop5RecyclerViewPresenter = new Top5RecyclerViewPresenter(this, getContext());

        return v;
    }

    @Override
    public void generateVerticalLinearLayout() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        petsListRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public Top5Adapter createAdapter(ArrayList<Pet> petsList) {
        Top5Adapter top5Adapter = new Top5Adapter(petsList, getActivity());
        return top5Adapter;
    }

    @Override
    public void initializeRVAdapter(Top5Adapter top5Adapter) {
        petsListRecyclerView.setAdapter(top5Adapter);
    }
}
