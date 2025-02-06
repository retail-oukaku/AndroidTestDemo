package com.example.myapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class Fragment01ViewModel extends AndroidViewModel {
    private final MutableLiveData<String> sumText = new MutableLiveData<>("init");

    public LiveData<String> getSumText() { return sumText; }

    public Fragment01ViewModel(@NonNull Application application) {
        super(application);
    }

    public void addValue(int v){
        sumText.setValue(sumText.getValue() + v);
    }
}
