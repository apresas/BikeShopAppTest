package com.example.bikeshopapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bikeshopapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // add a line of code
    }

    public void enterHere(View view) {
        Intent intent = new Intent(MainActivity.this, ProductList.class);
        startActivity(intent);

    }
}