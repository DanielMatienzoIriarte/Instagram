package com.example.danmat.instagram.restApi.adapter;

import com.example.danmat.instagram.restApi.EndpointsApi;
import com.example.danmat.instagram.restApi.apiConstants;
import com.example.danmat.instagram.restApi.deserializer.PetDeserializer;
import com.example.danmat.instagram.restApi.deserializer.PetLikeDeserializer;
import com.example.danmat.instagram.restApi.deserializer.PetUrlDeserializer;
import com.example.danmat.instagram.restApi.model.PetResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    public EndpointsApi setRestConnectionInstagramApi(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiConstants.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public EndpointsApi setRestConnectionInstagramURL(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiConstants.ROOT_URL_NO_API)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson buildPetDeserializer(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetDeserializer());
        return gsonBuilder.create();
    }

    public Gson buildUserDeserializer(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetUrlDeserializer());
        return gsonBuilder.create();
    }

    public Gson buildPetLikeDeserializer(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetLikeDeserializer());
        return gsonBuilder.create();
    }

    public EndpointsApi setRestConnectionInstagramLike(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiConstants.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public EndpointsApi stablishRestAPIConnection() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiConstants.HEROKU_ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndpointsApi.class);
    }
}
