package com.example.bikeshopapp.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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

//        Repository repo = new Repository(getApplication());
//        Product product = new Product(1,"Unicycle", 100.00);
//        repo.insert(product);
//        Product product2 = new Product(2,"Bicycle", 1000.00);
//        repo.insert(product2);
//        Part part = new Part(1,"Pedal", 3.00, 1);
//        repo.insert(part);

    }
}