package com.example.bikeshopapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bikeshopapp.Database.Repository;
import com.example.bikeshopapp.Entity.Part;
import com.example.bikeshopapp.Entity.Product;
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

        Repository repo = new Repository(getApplication());
        Product product = new Product("Unicycle", 10.00);
        repo.insert(product);
        Part part = new Part(1,"Pedal", 3.00, 1);
        repo.insert(part);

    }
}