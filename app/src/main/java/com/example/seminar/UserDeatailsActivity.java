package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.seminar.databinding.ActivityUserDeatailsBinding;

public class UserDeatailsActivity extends AppCompatActivity {

    ActivityUserDeatailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityUserDeatailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent= getIntent();
        Role role=(Role) intent.getSerializableExtra("user_model");

        binding.username.setText(role.getUsername());
        binding.useremail.setText(role.getEmail());
        binding.department.setText(role.getDepartment());
        binding.userrole.setText(role.getRole());

        binding.deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}