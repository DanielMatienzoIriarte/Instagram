package com.example.danmat.instagram.restApi;

import com.example.danmat.instagram.restApi.model.PetResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsApi {

    @GET(apiConstants.URL_GET_RECENT_MEDIA_USER)
    Call<PetResponse> getRecentMedia();
}
