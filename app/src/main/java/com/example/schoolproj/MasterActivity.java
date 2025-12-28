package com.example.schoolproj;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolproj.classes.User;

public class MasterActivity extends AppCompatActivity
{
    protected SharedPreferences settings;
    protected User connectedUser;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences("settings", MODE_PRIVATE);




    }
}
