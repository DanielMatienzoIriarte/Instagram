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

public class PetDeserializer implements JsonDeserializer<PetResponse> {
    @Override
    public PetResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PetResponse petResponse = gson.fromJson(json, PetResponse.class);
        JsonArray petResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        petResponse.setPetsList(jsonPetDeserializer(petResponseData));
        return petResponse;
    }

    private ArrayList<Pet> jsonPetDeserializer(JsonArray petResponseData){
        ArrayList<Pet> petsList = new ArrayList<>();
        for (int i = 0; i < petResponseData.size() ; i++) {
            JsonObject petResponseDataObject = petResponseData.get(i).getAsJsonObject();

            JsonObject imageJson        = petResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject imagenStdJson    = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto              = imagenStdJson.get(JsonKeys.MEDIA_URL).getAsString();
            JsonObject likesJson    = petResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes               = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Pet currentPet = new Pet();
            currentPet.setAvatarUrl(urlFoto);
            currentPet.setRate(likes);
            petsList.add(currentPet);
        }

        return petsList;
    }
}
