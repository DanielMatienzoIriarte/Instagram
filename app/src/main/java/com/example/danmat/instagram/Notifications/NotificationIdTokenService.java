package com.example.danmat.instagram.Notifications;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class NotificationIdTokenService  extends FirebaseInstanceIdService {
    private static final String TAG = "FIREBASE_TOKEN";

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        //sendRegisterToken(token);
    }

    private void sendRegisterToken(String token) {
        Log.d(TAG, token);
    }
}
