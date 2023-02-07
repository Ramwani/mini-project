package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.seminar.databinding.ActivityManageUsersBinding;

public class ManageUsers extends AppCompatActivity {
    ActivityManageUsersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityManageUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}