package com.example.danmat.instagram;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.danmat.instagram.fragments.ProfileFragment;
import com.example.danmat.instagram.fragments.RecyclerViewAccountFragment;
import com.example.danmat.instagram.javaMail.GMailSender;
import com.example.danmat.instagram.presenter.ProfileRecyclerViewFragmentPresenter;

public class AccountActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private String accountActivityUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        final Button saveAccountButton = (Button) findViewById(R.id.account_button_sendForm);
        saveAccountButton.setOnClickListener(new View.OnClickListener(){
            TextInputLayout accountUserName = (TextInputLayout) findViewById(R.id.account_textInputLayout_userName);

            @Override
            public void onClick(View v) {
                try {
                    accountActivityUserName = accountUserName.getEditText().getText().toString();
                    Toast.makeText(AccountActivity.this, "Account saved succesfully " + accountUserName.getEditText().getText().toString(), Toast.LENGTH_LONG).show();

                    Fragment recyclerViewAccountFragment = new RecyclerViewAccountFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("instagramUserName", accountActivityUserName);
                    recyclerViewAccountFragment.setArguments(bundle);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.contact_layout_name, recyclerViewAccountFragment);
                    transaction.commit();

                } catch (Exception e) {
                    Log.e("saveAccount", e.getMessage(), e);
                }
            }
        });

        toolbar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionsmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.optionsMenu_item_registerUser:
                Intent notificationIntent = new Intent(this, NotificationActivity.class);
                startActivity(notificationIntent);
                break;
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
        }

        return super.onOptionsItemSelected(item);
    }
}
