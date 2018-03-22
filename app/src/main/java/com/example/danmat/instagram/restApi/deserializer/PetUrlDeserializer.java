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
        JsonObject userResponseGraphql = json.getAsJsonObject().getAsJsonObject(JsonKeys.USER_GRAPHQL_RESPONSE_ARRAY);
        JsonObject userResponseData = userResponseGraphql.getAsJsonObject(JsonKeys.USER);
        JsonObject userResponseMedia = userResponseData.getAsJsonObject(JsonKeys.USER_MEDIA_NEW_RESPONSE_ARRAY);
        JsonArray userResponseMediaEdges = userResponseMedia.getAsJsonArray(JsonKeys.USER_EDGES_NEW_RESPONSE_ARRAY);
//        JsonObject userResponseMediaNodes = userResponseMediaEdges.getAsJsonObject(JsonKeys.USER_MEDIA_NODES_RESPONSE_ARRAY);

        petResponse.setPetsList(jsonPetDeserializer(userResponseMediaEdges));
        return petResponse;
    }

    private ArrayList<Pet> jsonPetDeserializer(JsonArray userResponseMediaEdges){
        ArrayList<Pet> petsList = new ArrayList<>();
        for (int i = 0; i < userResponseMediaEdges.size() ; i++) {
            JsonObject userResponseDataObject = userResponseMediaEdges.get(i).getAsJsonObject();
            JsonObject userResponseNode = userResponseDataObject.getAsJsonObject(JsonKeys.USER_MEDIA_NODE_RESPONSE_ARRAY);
            String imageSource = userResponseNode.get(JsonKeys.USER_MEDIA_URL).getAsString();
            JsonObject likesJson = userResponseNode.getAsJsonObject(JsonKeys.USER_MEDIA_LIKE);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Pet currentPet = new Pet();
            currentPet.setAvatarUrl(imageSource);
            currentPet.setRate(likes);
            petsList.add(currentPet);
        }

        return petsList;
    }
}
