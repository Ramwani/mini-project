package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.seminar.databinding.ActivityBookingBinding;

public class BookingActivity extends AppCompatActivity {
    ActivityBookingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}