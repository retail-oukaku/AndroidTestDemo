package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.databinding.Fragment02Binding;
import com.example.myapplication.model.TestUser;
import com.example.myapplication.viewmodel.Fragment01ViewModel;
import com.example.myapplication.viewmodel.Fragment02ViewModel;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Fragment02 extends Fragment {

    private Fragment02Binding binding;

    private Fragment02ViewModel viewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(Fragment02ViewModel.class);

//        viewModel = new Fragment02ViewModel();
    }

    //返回的view对象会作为fragement02的内容显示在界面上
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_02,container,false);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        return binding.getRoot();
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        binding = Fragment02Binding.inflate(, container, false);
//
//        binding = DataBindingUtil.inflate(inflater,)
//
//        binding.setUserInfo(user);
//    }
}