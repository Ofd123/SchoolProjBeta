package com.example.schoolproj.screens;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.schoolproj.MasterActivity;
import com.example.schoolproj.R;

public class main_screen extends MasterActivity
{

    private static final int CAMERA_REQUEST_CODE = 1;
    private static final int CAMERA_PERMISSION_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void regularSearch(View view)
    {

    }

    public void imageSearch(View view)
    {
        String[] options = {"Camera", "Gallery"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Image Source");
        builder.setItems(options, (dialog, which) -> {
            switch (which) {
                case 0:
                    openCamera();
                    break;
                case 1:
//                    openGallery();
                    break;
            }
        });

        builder.show();
    }
    public void openCamera()
    {
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
            return;
        }
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAMERA_REQUEST_CODE);
        } else {
            Toast.makeText(this, "No camera app found.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                Toast.makeText(this, "Camera permission denied.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void searchHistory(View view) {
    }

    public void favorites(View view) {
    }

    public void allHistory(View view) {
    }

    public void goToSettings(View view) {
    }
}