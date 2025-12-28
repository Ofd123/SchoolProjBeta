package com.example.schoolproj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.schoolproj.classes.User;
import com.example.schoolproj.screens.main_screen;
import com.example.schoolproj.screens.signUp_screen;

public class MainActivity extends MasterActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //TODO: goto login / signin if needed | else go to main screen
        Boolean stayConnected = settings.getBoolean("stayConnected", false);

        Intent intent;
        if(stayConnected)
        {
            connectedUser = new User(settings.getString("userID", ""), settings.getString("username", ""));
            connectedUser.setLastLogin(settings.getLong("lastLogin", 0));
            connectedUser.setCreationDate(settings.getLong("creationDate", 0));
            intent = new Intent(this, main_screen.class);
        }
        else
        {
            intent = new Intent(this, signUp_screen.class);
        }
        startActivity(intent);
    }

}