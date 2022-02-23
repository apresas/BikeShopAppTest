package com.example.bikeshopapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;

import com.example.bikeshopapp.Database.Repository;
import com.example.bikeshopapp.Entity.Product;
import com.example.bikeshopapp.R;

import java.util.List;

public class ProductList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Repository repository = new Repository(getApplication());
        List<Product> products = repository.getAllProducts();
        final ProductAdapter adapter = new ProductAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setProducts(products);
    }
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_productlist, menu);
            return true;
        }
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:
                    this.finish();
                    return true;
            }
                    return super.onOptionsItemSelected(item);
    }

    public void goToPartsList(View view) {
        Intent intent = new Intent(ProductList.this, PartList.class);
        startActivity(intent);
    }
}

