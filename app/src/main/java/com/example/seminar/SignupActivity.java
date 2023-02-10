package com.example.seminar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.seminar.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.UUID;

public class SignupActivity extends AppCompatActivity {
    private String id;
    ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this,MainActivity.class));
                finish();
            }
        });

        binding.signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String username=binding.username.getText().toString();
                String email=binding.email.getText().toString();
                String role=binding.role.getText().toString();
                String department=binding.department.getText().toString();
                String password=binding.password.getText().toString();
                createAccount(username,email,department,role,password);

            }

            private void createAccount(String username, String email, String department,String role, String password) {
                FirebaseAuth fAuth= FirebaseAuth.getInstance();

                ProgressDialog progressDialog=new ProgressDialog(SignupActivity.this);
                progressDialog.setTitle("Creating");
                progressDialog.setMessage("Account");
                progressDialog.show();

                fAuth.createUserWithEmailAndPassword(email.trim(),password.trim())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                UserProfileChangeRequest profileChangeRequest=new UserProfileChangeRequest.Builder()
                                        .setDisplayName(username).build();
                                FirebaseAuth.getInstance().getCurrentUser().updateProfile(profileChangeRequest);
                                progressDialog.cancel();
                                Toast.makeText(SignupActivity.this,"Account Created",Toast.LENGTH_SHORT).show();

                                binding.username.setText("");
                                binding.email.setText("");
                                binding.department.setText("");
                                binding.role.setText("");
                                binding.password.setText("");

                                Role rolee = new Role(authResult.getUser().getUid().toString(),username.toString(),department.toString(),email.toString(),role.toString(),true);
                                System.out.println(authResult.getUser().getUid());
                                FirebaseFirestore.getInstance()
                                        .collection("user")
                                        .document(authResult.getUser().getUid())
                                        .set(rolee);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.cancel();
                                Toast.makeText(SignupActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });

    }
}