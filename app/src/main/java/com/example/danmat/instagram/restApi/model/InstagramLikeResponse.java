package com.example.danmat.instagram.restApi.model;

public class InstagramLikeResponse {
    private String mediaId;
    private String meta;
    private String code;
    private String data;

    public InstagramLikeResponse(String meta, String code, String data) {
        this.meta = meta;
        this.code = code;
        this.data = data;
    }

    public InstagramLikeResponse(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() { return mediaId; }

    public void setMediaId(String mediaId) { this.mediaId = mediaId; }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
