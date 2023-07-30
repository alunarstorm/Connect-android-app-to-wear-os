package com.company.smartwatchTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPreference();
        setContentView(R.layout.activity_main);
        
    }
    public String setPrefernece(){
        return "english";
    }
}
