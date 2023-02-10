package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.seminar.databinding.ActivityManageUsersBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ManageUsers extends AppCompatActivity {
    ActivityManageUsersBinding binding;

    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityManageUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);


        setSupportActionBar(binding.Toolbar);
        userAdapter=new UserAdapter(this);
        binding.userRecycler.setAdapter(userAdapter);
        binding.userRecycler.setLayoutManager(new LinearLayoutManager(this));

        getUsers();

    }

    private void getUsers() {

            FirebaseFirestore.getInstance()
                    .collection("user")
                    .whereEqualTo("show", true)
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> dsList=queryDocumentSnapshots.getDocuments();
                            for(DocumentSnapshot ds:dsList){
                                Role role=ds.toObject(Role.class);
                                System.out.println(role.toString());
                                userAdapter.addUser(role);
                            }
                        }
                    });

/*
        FirebaseFirestore.getInstance().collection("user").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<String> list = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        list.add(document.getData().toString());
                    }
                    for(int i = 0 ; i<list.size();i++){

                        //Role role=ds.toObject(Role.class);
                        System.out.println(list.get(i));
                        //Role role = list.indexOf(i);
                        //userAdapter.addUser(role);
                    }

                } else {
                    System.out.println("Error getting documents: ");
                }
            }
        });
*/

    }
}