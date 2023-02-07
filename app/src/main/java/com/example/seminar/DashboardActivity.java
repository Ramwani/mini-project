package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.seminar.databinding.ActivityDashboardBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    ActivityDashboardBinding binding;
    private HallAdapter hallAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.myToolbar);
        hallAdapter=new HallAdapter(this);
        binding.hallRecycler.setAdapter(hallAdapter);
        binding.hallRecycler.setLayoutManager(new LinearLayoutManager(this));

        binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,UserDashActivity.class));
                finish();
            }
        });

        getHalls();
    }

    private void getHalls() {
        FirebaseFirestore.getInstance()
                .collection("Seminar_Halls")
                .whereEqualTo("show",true)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> dsList=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot ds:dsList){
                            HallModule hallModule=ds.toObject(HallModule.class);
                            hallAdapter.addHall(hallModule);
                        }
                    }
                });
    }
}