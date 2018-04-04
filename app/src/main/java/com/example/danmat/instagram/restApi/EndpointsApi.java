package com.example.danmat.instagram.restApi;

import com.example.danmat.instagram.restApi.model.InstagramLikeResponse;
import com.example.danmat.instagram.restApi.model.InstagramPetResponse;
import com.example.danmat.instagram.restApi.model.InstagramUserResponse;
import com.example.danmat.instagram.restApi.model.PetResponse;
import com.example.danmat.instagram.restApi.model.UserResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EndpointsApi {
    @GET(apiConstants.URL_GET_RECENT_MEDIA_USER)
    Call<PetResponse> getRecentMedia();

    @GET(apiConstants.URL_GET_RECENT_MEDIA_ACCOUNT_USER_NO_API)
    Call<PetResponse> getAccountFullInfoFromUrl(@Path(value = "user-id", encoded = true) String userName);

    @GET(apiConstants.URL_GET_RECENT_MEDIA_ACCOUNT_USER)
    Call<PetResponse> getInstagramAccountRecentMedia(@Path(value = "user-id", encoded = true) String userName);

    @FormUrlEncoded
    @POST(apiConstants.KEY_POST_ID_TOKEN)
    Call<UserResponse> registerTokenId(@Field("token") String token);

    @FormUrlEncoded
    @POST(apiConstants.KEY_POST_INSTAGRAM_STORAGE)
    Call<InstagramUserResponse> registerUser(@Field("deviceId") String deviceId, @Field("instagramUserId") String instagramUserId);

    @POST(apiConstants.INSTAGRAM_LIKE_MEDIA)
    Call<InstagramLikeResponse> likeMedia(@Path("media-id") String mediaId);
}
