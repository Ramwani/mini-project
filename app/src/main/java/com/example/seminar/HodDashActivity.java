package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.seminar.databinding.ActivityDetailBinding;

public class HodDashActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}