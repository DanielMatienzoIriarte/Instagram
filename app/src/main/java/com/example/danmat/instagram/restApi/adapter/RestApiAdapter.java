package com.example.danmat.instagram.restApi.adapter;


import com.example.danmat.instagram.restApi.EndpointsApi;
import com.example.danmat.instagram.restApi.apiConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    public EndpointsApi setRestConnectionInstagramApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiConstants.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndpointsApi.class);
    }
}
