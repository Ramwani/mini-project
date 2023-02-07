package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.seminar.databinding.ActivityAdminDashBinding;

public class AdminDashActivity extends AppCompatActivity {
    ActivityAdminDashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAdminDashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addHalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashActivity.this,AddHallsActivity.class));
                finish();
            }
        });

        binding.viewBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashActivity.this,ViewBookingActivity.class));
                finish();
            }
        });

        binding.manageUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashActivity.this,ManageUsers.class));
                finish();
            }
        });
        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashActivity.this,DeleteHallActivity.class));
                finish();
            }
        });

    }

}