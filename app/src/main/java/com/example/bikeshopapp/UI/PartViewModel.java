package com.example.bikeshopapp.UI;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bikeshopapp.Database.Repository;
import com.example.bikeshopapp.Entity.Part;

import java.util.List;

public class PartViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<Part>> allParts;

    public PartViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allParts = repository.getAllParts();
    }

    public void insert(Part part) { repository.insert(part);}
    public void update(Part part) {repository.update(part);}
    public void delete(Part part) {repository.delete(part);}

    public LiveData<List<Part>> getAllParts() {
        return allParts;
    }
}
