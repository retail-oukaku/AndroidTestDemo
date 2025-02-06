package com.example.myapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


public class Fragment02ViewModel extends AndroidViewModel {
    private final MutableLiveData<String> sumText = new MutableLiveData<>("init");
    public MutableLiveData<String> getSumText() { return sumText; }

    public Fragment02ViewModel(@NonNull Application application) {
        super(application);
    }
    public void addValue(int v){
        sumText.setValue(sumText.getValue() + v);
    }



}