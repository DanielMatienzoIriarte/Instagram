package com.example.danmat.instagram.restApi.deserializer;

import com.example.danmat.instagram.pojo.Pet;
import com.example.danmat.instagram.restApi.JsonKeys;
import com.example.danmat.instagram.restApi.model.PetResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PetUrlDeserializer implements JsonDeserializer<PetResponse> {
    @Override
    public PetResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PetResponse petResponse = gson.fromJson(json, PetResponse.class);
        JsonObject userResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.USER);
        JsonObject userResponseMedia = userResponseData.getAsJsonObject(JsonKeys.USER_MEDIA_RESPONSE_ARRAY);
        JsonArray userResponseMediaNodes = userResponseMedia.getAsJsonArray(JsonKeys.USER_MEDIA_NODES_RESPONSE_ARRAY);

        petResponse.setPetsList(jsonPetDeserializer(userResponseMediaNodes));
        return petResponse;
    }

    private ArrayList<Pet> jsonPetDeserializer(JsonArray userResponseMediaNodes){
        ArrayList<Pet> petsList = new ArrayList<>();
        for (int i = 0; i < userResponseMediaNodes.size() ; i++) {
            JsonObject userResponseDataObject = userResponseMediaNodes.get(i).getAsJsonObject();
            String imageSource = userResponseDataObject.get(JsonKeys.USER_MEDIA_SOURCE).toString();
            JsonObject likesJson = userResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Pet currentPet = new Pet();
            currentPet.setAvatarUrl(imageSource);
            currentPet.setRate(likes);
            petsList.add(currentPet);
        }

        return petsList;
    }
}
