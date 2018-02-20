package com.example.danmat.instagram.restApi.model;

public class InstagramUserResponse {
    private String id;
    private String deviceId;
    private String instagramUserId;

    public InstagramUserResponse(String deviceId, String instagramUserId) {
        this.deviceId = deviceId;
        this.instagramUserId = instagramUserId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getInstagramUserId() {
        return instagramUserId;
    }

    public void setInstagramUserId(String instagramUserId) {
        this.instagramUserId = instagramUserId;
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }
}
