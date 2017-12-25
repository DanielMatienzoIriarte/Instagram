package com.example.danmat.instagram.pojo;

public class Pet {
    private int petId;
    private String name;
    private int avatar;
    private int rate;

    public Pet() {

    }

    public Pet(int petId, String name, int avatar) {
        this.petId = petId;
        this.name = name;
        this.avatar = avatar;
        this.rate = 0;
    }

    public Pet(int petId, String name, int avatar, int rate) {
        this.petId = petId;
        this.name = name;
        this.avatar = avatar;
        this.rate = rate;
    }

    public int getPetId() { return petId; }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}