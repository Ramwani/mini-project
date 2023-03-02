package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.seminar.databinding.ActivityBookingBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.UUID;

public class BookingActivity extends AppCompatActivity {
    ActivityBookingBinding binding;
    private String id,event,dept,duration,date,time,hallName,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name = FirebaseAuth.getInstance().getCurrentUser().getDisplayName().toString();
       // String hallName= String.valueOf(FirebaseFirestore.getInstance().collection(getCurrentFocus().toString()));

        binding.proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                event = binding.event.getText().toString();
                dept=  binding.dept.getText().toString();
                duration=binding.duration.getText().toString();
                date = binding.date.getText().toString();
                time=binding.time.getText().toString();
                bookHall();
                System.out.println(date);
            }

            private void bookHall() {
                id=UUID.randomUUID().toString();
                ProgressDialog progressDialog=new ProgressDialog(BookingActivity.this);
                progressDialog.setTitle("Booking");
                progressDialog.setMessage("Seminar Hall");
                progressDialog.show();

                BookModel bookModel= new BookModel(id,event,dept,duration,date,time,name,hallName,true);
                FirebaseFirestore.getInstance()
                        .collection("Bookings")
                        .document(id)
                        .set(bookModel);
                Toast.makeText(BookingActivity.this, "Booking Done", Toast.LENGTH_SHORT).show();
                progressDialog.cancel();
            }
        });
    }
}