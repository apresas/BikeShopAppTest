package com.example.bikeshopapp.Database;

import android.app.Application;

import com.example.bikeshopapp.DAO.PartDAO;
import com.example.bikeshopapp.DAO.ProductDAO;
import com.example.bikeshopapp.Entity.Part;
import com.example.bikeshopapp.Entity.Product;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private PartDAO partDAO;
    private ProductDAO productDAO;
    private List<Product> allProducts;
    private List<Part> allParts;

    private static  int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application) {
        DatabaseBuilder db = DatabaseBuilder.getDataBase(application);
        partDAO = db.partDAO();
        productDAO = db.productDAO();
    }

    // Product
    public List<Product>getAllProducts(){
        databaseExecutor.execute(()->{
            allProducts = productDAO.getAllProducts();
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return allProducts;
    }

    public void insert(Product product) {
        databaseExecutor.execute(()->{
            productDAO.insert(product);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void update(Product product) {
        databaseExecutor.execute(()->{
            productDAO.update(product);
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void delete(Product product) {
        databaseExecutor.execute(()->{
            productDAO.delete(product);
        });
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Part
    public List<Part>getAllParts(){
        databaseExecutor.execute(()->{
            allParts = partDAO.getAllParts();
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return allParts;
    }

    public void insert(Part part) {
        databaseExecutor.execute(()->{
            partDAO.insert(part);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void update(Part part) {
        databaseExecutor.execute(()->{
            partDAO.update(part);
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void delete(Part part) {
        databaseExecutor.execute(()->{
            partDAO.delete(part);
        });
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
