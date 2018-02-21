package com.example.danmat.instagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

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
            case R.id.optionsMenu_item_top5:
                Intent top5Intent = new Intent(this, Top5Activity.class);
                startActivity(top5Intent);
                break;
        }

        return super.onOptionsItemSelected(item);

    }
}
