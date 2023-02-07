package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.seminar.databinding.ActivityCancelBookingBinding;

public class CancelBookingActivity extends AppCompatActivity {
    ActivityCancelBookingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCancelBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}