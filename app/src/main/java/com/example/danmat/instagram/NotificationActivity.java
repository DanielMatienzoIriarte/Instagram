package com.example.danmat.instagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.danmat.instagram.restApi.EndpointsApi;
import com.example.danmat.instagram.restApi.adapter.RestApiAdapter;
import com.example.danmat.instagram.restApi.model.InstagramUserResponse;
import com.example.danmat.instagram.restApi.model.UserResponse;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        toolbar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String token = FirebaseInstanceId.getInstance().getToken();
        String instagramUserId = "666";
        registerInstagramUser(token, instagramUserId);
    }

    public void launchNotification(View v) {
        String deviceId = FirebaseInstanceId.getInstance().getToken();
        String instagramUserId = "1313";
        registerInstagramUser(deviceId, instagramUserId);
    }

    private void registerInstagramUser(String deviceId, String instagramUserId) {
        Toast.makeText(this, "DeviceId: " + deviceId + "\nUserId: " + instagramUserId, Toast.LENGTH_LONG).show();
        Log.d("DEVICEID: ", deviceId);
        Log.d("USERID: ", instagramUserId);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpointsApi = restApiAdapter.stablishRestAPIConnection();
        Call<InstagramUserResponse> userResponseCall = endpointsApi.registerUser(deviceId, instagramUserId);

        userResponseCall.enqueue(new Callback<InstagramUserResponse>() {
            @Override
            public void onResponse(Call<InstagramUserResponse> call, Response<InstagramUserResponse> response) {
                InstagramUserResponse userResponse = response.body();
                Log.d("ID FIREBASE", userResponse.getId());
                Log.d("ID DEVICE", userResponse.getDeviceId());
                Log.d("TOKEN_FIREBASE", userResponse.getInstagramUserId());
            }

            @Override
            public void onFailure(Call<InstagramUserResponse> call, Throwable t) {
                call.cancel();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionsmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.optionsMenu_item_account:
                Intent accountIntent = new Intent(this, AccountActivity.class);
                startActivity(accountIntent);
                break;
            case R.id.optionsMenu_item_contact:
                Intent contactIntent = new Intent(this, ContactActivity.class);
                startActivity(contactIntent);
                break;
            case R.id.optionsMenu_item_about:
                Intent aboutIntent = new Intent (this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
            case R.id.optionsMenu_item_top5:
                Intent top5Intent = new Intent(this, Top5Activity.class);
                startActivity(top5Intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
