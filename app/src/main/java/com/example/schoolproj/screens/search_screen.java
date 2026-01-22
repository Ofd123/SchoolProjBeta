package com.example.schoolproj.screens;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolproj.R;

public class search_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);
        //TODO: add fragments and work on GUI
    }
    void searchWithGemini()
    {

    }
    void multiSearchWithGemini()
    {

    }
    void manualSearch()
    {

    }

    public void search(View view)
    {
        //TODO: search the item on the webb and then move it to the result screen
        try
        {
            multiSearchWithGemini();
        }
        catch(Exception e)
        {
            manualSearch();
        }
    }
}