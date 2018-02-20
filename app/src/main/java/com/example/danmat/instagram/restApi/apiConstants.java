package com.example.danmat.instagram.restApi;

public final class apiConstants {
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ROOT_URL_NO_API = "https://www.instagram.com/";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String ACCESS_TOKEN = "<INSERT ACCESS TOKEN>";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String KEY_GET_RECENT_MEDIA_ACCOUNT_USER = "users/{user-id}/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_ACCOUNT_USER = KEY_GET_RECENT_MEDIA_ACCOUNT_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_GET_RECENT_MEDIA_ACCOUNT_USER_NO_API = "{user-name}/?__a=1&";
    public static final String HEROKU_ROOT_URL = "https://limitless-gorge-48003.herokuapp.com/";
    public static final String KEY_POST_ID_TOKEN = "token-device/";
    public static final String KEY_POST_INSTAGRAM_STORAGE = "instagram-user/";
    //Constants related to instagram users
    public static final String INSTAGRAM_USER_ID = "<INSERT INSTAGRAM USER ID>";
    public static final String INSTAGRAM_USER_NAME = "<INSERT INSTAGRAM USER NAME>";
}