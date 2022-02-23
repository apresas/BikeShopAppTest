package com.example.bikeshopapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bikeshopapp.Database.Repository;
import com.example.bikeshopapp.Entity.Product;
import com.example.bikeshopapp.R;

public class PartList extends AppCompatActivity {
    EditText editName;
    EditText editPrice;
    String name;
    Double price;
    int productID;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_list);
        editName = findViewById(R.id.editProductName);
        editPrice = findViewById(R.id.editProductPrice);
        productID = getIntent().getIntExtra("id", -1);
        name = getIntent().getStringExtra("name");
        price = getIntent().getDoubleExtra("price", -1.0);
        editName.setText(name);
        editPrice.setText(Double.toString(price));
        repository = new Repository(getApplication());

    }

    public void saveButton(View view) {
        Product product;
        if (productID == -1) {
            int newID = repository.getAllProducts().get(repository.getAllProducts().size() -1).getProductID() + 1;
            product = new Product(newID, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()));
            repository.insert(product);
            Toast.makeText(PartList.this, "Product Saved", Toast.LENGTH_SHORT).show();
        } else {
            product = new Product(productID, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()));
            repository.update(product);
        }
    }
}