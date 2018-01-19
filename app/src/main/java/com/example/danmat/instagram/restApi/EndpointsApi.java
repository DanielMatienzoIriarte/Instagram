package com.example.danmat.instagram.restApi;

import com.example.danmat.instagram.restApi.model.PetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EndpointsApi {
    @GET(apiConstants.URL_GET_RECENT_MEDIA_USER)
    Call<PetResponse> getRecentMedia();

    @GET(apiConstants.URL_GET_RECENT_MEDIA_ACCOUNT_USER)
    Call<PetResponse> getAccountRecentMedia(@Path("user-id") String userId);
}
