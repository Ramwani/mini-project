package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.seminar.databinding.ActivityMainBinding;
import com.example.seminar.databinding.ActivityUserDashBinding;

public class UserDashActivity extends AppCompatActivity {
    ActivityUserDashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityUserDashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBookHall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashActivity.this,DashboardActivity.class));
                finish();
            }
        });

        binding.btnCancelBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashActivity.this,CancelBookingActivity.class));
                finish();
            }
        });

        binding.btnViewBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDashActivity.this,ViewBookingActivity.class));
                finish();
            }
        });


    }
}