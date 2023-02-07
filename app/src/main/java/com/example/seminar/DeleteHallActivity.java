package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.seminar.databinding.ActivityDeleteHallBinding;

public class DeleteHallActivity extends AppCompatActivity {

    ActivityDeleteHallBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDeleteHallBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}