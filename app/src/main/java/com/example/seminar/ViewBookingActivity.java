package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.seminar.databinding.ActivitySignupBinding;
import com.example.seminar.databinding.ActivityViewBookingBinding;

public class ViewBookingActivity extends AppCompatActivity {

    ActivityViewBookingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityViewBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}