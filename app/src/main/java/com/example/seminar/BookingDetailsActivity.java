package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.seminar.databinding.ActivityBookingDetailsBinding;

public class BookingDetailsActivity extends AppCompatActivity {

    ActivityBookingDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBookingDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}