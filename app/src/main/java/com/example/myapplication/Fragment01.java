package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.viewmodel.Fragment01ViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Fragment01 extends Fragment {
    private Fragment01ViewModel viewModel;

    //返回的view对象会作为fragement1的内容显示在界面上
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_01, null);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView3 = view.findViewById(R.id.textView1);
        Button myButton = view.findViewById(R.id.myButton);
        //ViewModelインスタンス生成
        viewModel = new ViewModelProvider(requireActivity()).get(Fragment01ViewModel.class);

        //LiveDataを監視
        viewModel.getSumText().observe(getViewLifecycleOwner(),new Observer<String>() {
            @Override
            public void onChanged(String addresses) {
                textView3.setText(addresses);
            }
        });




        myButton.setOnClickListener(v ->
                viewModel.addValue(1)
        );


    }
}