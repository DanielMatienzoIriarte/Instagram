package com.example.danmat.instagram;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.danmat.instagram.adapters.PagerAdapter;
import com.example.danmat.instagram.fragments.ProfileFragment;
import com.example.danmat.instagram.fragments.RecyclerViewAccountFragment;
import com.example.danmat.instagram.fragments.RecyclerViewFragment;
import com.example.danmat.instagram.restApi.EndpointsApi;
import com.example.danmat.instagram.restApi.adapter.RestApiAdapter;
import com.example.danmat.instagram.restApi.model.UserResponse;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.actionbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();
        setSupportActionBar(toolbar);
    }

    public void launchNotification(View v) {
        String token = FirebaseInstanceId.getInstance().getToken();
        //sendRegisterToken(token);
    }

    private void sendRegisterToken(String token) {
        Toast.makeText(this, "Notification token: " + token, Toast.LENGTH_LONG).show();
        Log.d("TOKEN: ", token);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpointsApi = restApiAdapter.stablishRestAPIConnection();
        Call<UserResponse> userResponseCall = endpointsApi.registerTokenId(token);

        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                Log.d("ID FIREBASE", userResponse.getId());
                Log.d("TOKEN_FIREBASE", userResponse.getToken());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

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
        switch(item.getItemId()){
            /*case R.id.optionsMenu_item_registerUser:
                Intent notificationIntent = new Intent(this, NotificationActivity.class);
                startActivity(notificationIntent);
                break;*/
            case R.id.optionsMenu_item_account:
                Intent accountIntent = new Intent(this, AccountActivity.class);
                startActivity(accountIntent);
                break;
            case R.id.optionsMenu_item_contact:
                Intent contactIntent = new Intent(this, ContactActivity.class);
                startActivity(contactIntent);
                break;
            case R.id.optionsMenu_item_about:
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
            case R.id.optionsMenu_item_top5:
                Intent top5Intent = new Intent(this, Top5Activity.class);
                startActivity(top5Intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> addFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new ProfileFragment());
//        fragments.add(new RecyclerViewAccountFragment());

        return fragments;
    }

    public void setUpViewPager() {
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), addFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_avatar);
    }
}
