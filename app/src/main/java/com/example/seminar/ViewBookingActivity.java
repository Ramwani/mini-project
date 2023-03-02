package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.seminar.databinding.ActivitySignupBinding;
import com.example.seminar.databinding.ActivityViewBookingBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class ViewBookingActivity extends AppCompatActivity {

    ActivityViewBookingBinding binding;

    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityViewBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.myToolbar);
        bookAdapter =new BookAdapter(this);
        binding.bookRecycler.setAdapter(bookAdapter);
        binding.bookRecycler.setLayoutManager(new LinearLayoutManager(this));

        getBooks();
    }

    private void getBooks() {
        FirebaseFirestore.getInstance()
                .collection("Bookings")
                .whereEqualTo("show",true)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> dsList=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot ds:dsList){
                            BookModel bookModel=ds.toObject(BookModel.class);
                            bookAdapter.bookHall(bookModel);
                        }
                    }
                });

    }


}