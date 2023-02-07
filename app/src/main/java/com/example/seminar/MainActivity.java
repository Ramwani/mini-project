package com.example.seminar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.seminar.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.goToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(MainActivity.this,SignupActivity.class));
              finish();
            }
        });

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.email.getText().toString();
                String password=binding.password.getText().toString();
                login(email,password);
            }

            private void login(String email, String password) {
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Login");
                progressDialog.setMessage("In progress");
                progressDialog.show();

                FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
                firebaseAuth.signInWithEmailAndPassword(email.trim(), password.trim())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                progressDialog.cancel();
                                FirebaseFirestore.getInstance().collection("user").document(authResult.getUser().getUid())
                                        .get()
                                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                if (task.isSuccessful()) {
                                                    DocumentSnapshot document = task.getResult();
                                                    if (document != null && document.exists()){
                                                        System.out.println(document.getString("role"));
                                                        if(document.getString("role").equals("admin")){
                                                            startActivity(new Intent(MainActivity.this,AdminDashActivity.class));
                                                            Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                                                        } else if (document.getString("role").equals("staff")) {
                                                            startActivity(new Intent(MainActivity.this,DashboardActivity.class));
                                                            Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                                                        }else if (document.getString("role").equals("hod")){
                                                            startActivity(new Intent(MainActivity.this,HodDashActivity.class));
                                                            Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                                                        } else {
                                                            Toast.makeText(MainActivity.this,"Invalid Role",Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                }
                                            }
                                        });

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.cancel();
                                Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
            }
            @NonNull
            private void onStart(){
                MainActivity.super.onStart();
                if(FirebaseAuth.getInstance().getCurrentUser()!=null){
                    startActivity(new Intent(MainActivity.this,DashboardActivity.class));
                }
            }

        });
    }

}