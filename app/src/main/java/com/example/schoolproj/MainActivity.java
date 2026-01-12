package com.example.schoolproj;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.schoolproj.classes.User;
import com.example.schoolproj.screens.login_screen;
import com.example.schoolproj.screens.main_screen;
import com.example.schoolproj.screens.signUp_screen;

public class MainActivity extends MasterActivity
{
    int REQUEST_CODE = 100;
    int state;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Boolean stayConnected = settings.getBoolean("stayConnected", false);

        Intent hubIntent = null;
        state = hubCodes.SIGN_IN.ordinal();
        while(true) {
            hubIntent = null;
            if (state == hubCodes.ERROR.ordinal())
            {
                Toast.makeText(this, "Something went wrong, sending you to singup screen.", Toast.LENGTH_LONG).show();
                state = hubCodes.SIGN_IN.ordinal();
            }
            if (state == hubCodes.SIGN_IN.ordinal() && stayConnected) {
                // if the user just opened the app and has connected before
                state = hubCodes.REMEMBER_ME.ordinal();
                connectedUser = new User(settings.getString("userID", ""), settings.getString("username", ""));
                connectedUser.setLastLogin(settings.getLong("lastLogin", 0));
                connectedUser.setCreationDate(settings.getLong("creationDate", 0));
                hubIntent = new Intent(this, main_screen.class);
            } else if (state == hubCodes.SIGN_IN.ordinal()) {
                // if the user has not connected before
                hubIntent = new Intent(this, signUp_screen.class);
            } else if (state == hubCodes.LOG_IN.ordinal()) {
                // if the user has an account but not connected yet
                hubIntent = new Intent(this, login_screen.class);
            }
            startActivityForResult(hubIntent, REQUEST_CODE);

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                    state = data.getIntExtra("state", hubCodes.ERROR.ordinal());
            }
        }
    }

}