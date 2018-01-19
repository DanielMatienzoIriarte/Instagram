package com.example.danmat.instagram.restApi;

public final class apiConstants {
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String ACCESS_TOKEN = "6790680545.438820b.372d700e7c504fbda1619cdf4a20a952";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String KEY_GET_RECENT_MEDIA_ACCOUNT_USER = "users/{user-id}/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_ACCOUNT_USER = KEY_GET_RECENT_MEDIA_ACCOUNT_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
}