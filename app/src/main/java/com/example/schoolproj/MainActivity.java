package com.example.schoolproj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.schoolproj.classes.User;
import com.example.schoolproj.screens.login_screen;
import com.example.schoolproj.screens.main_screen;
import com.example.schoolproj.screens.signUp_screen;

public class MainActivity extends MasterActivity
{
    int state;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Boolean stayConnected = settings.getBoolean("stayConnected", false);

        Intent hubIntent = null;
        state = Codes.SIGN_IN.ordinal();
        while(true) {
            hubIntent = null;
            if (state == Codes.ERROR.ordinal())
            {
                Toast.makeText(this, "Something went wrong, sending you to singup screen.", Toast.LENGTH_LONG).show();
                state = Codes.SIGN_IN.ordinal();
            }
            if (state == Codes.SIGN_IN.ordinal() && stayConnected) {
                // if the user just opened the app and has connected before
                state = Codes.REMEMBER_ME.ordinal();
                connectedUser = new User(settings.getString("userID", ""), settings.getString("username", ""));
                connectedUser.setLastLogin(settings.getLong("lastLogin", 0));
                connectedUser.setCreationDate(settings.getLong("creationDate", 0));
                hubIntent = new Intent(this, main_screen.class);
            } else if (state == Codes.SIGN_IN.ordinal()) {
                // if the user has not connected before
                hubIntent = new Intent(this, signUp_screen.class);
            } else if (state == Codes.LOG_IN.ordinal()) {
                // if the user has an account but not connected yet
                hubIntent = new Intent(this, login_screen.class);
            }
            startActivityForResult(hubIntent, Codes.MAIN_SCREEN_REQUEST_CODE.ordinal());

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Codes.MAIN_SCREEN_REQUEST_CODE.ordinal())
        {
            if(resultCode == Activity.RESULT_OK)
            {
                    state = data.getIntExtra("state", Codes.ERROR.ordinal());
            }
        }
    }

}