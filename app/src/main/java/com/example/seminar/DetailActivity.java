package com.example.seminar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.seminar.databinding.ActivityDetailBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.UUID;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
   // private HallModule hallModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        HallModule hallModule=(HallModule) intent.getSerializableExtra("model");

        binding.title.setText(hallModule.getTitle());
        binding.capacity.setText(hallModule.getCapacity());
        binding.location.setText(hallModule.getLocation());
        binding.description.setText(hallModule.getDescription());
        Glide.with(binding.getRoot())
                .load(hallModule.getImage())
                .into(binding.image);

        binding.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //showBottomSheet();
                //bookDetail();
                startActivity(new Intent(DetailActivity.this,BookingActivity.class));
                finish();

            }
        });
    }

    //private void showBottomSheet() {
      //  BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
        //View view= LayoutInflater.from(DetailActivity.this).inflate(R.layout.bottom_layout,(LinearLayout)findViewById(R.id.mainlayout),
          //      false);
        //bottomSheetDialog.setContentView(view);
        //EditText description=view.findViewById(R.id.description);
        //DatePicker date_picker=view.findViewById(R.id.date_picker);
        //TimePicker time_picker=view.findViewById(R.id.time_picker);
        //Button btn=view.findViewById(R.id.con);
        //bottomSheetDialog.show();
        //btn.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View v) {
           //     String desc= description.getText().toString();
                //String d=date_p..toString();
               // String t=time_p.getText().toString();



             //   bookDetail();
               // bottomSheetDialog.cancel();

          //  }
        //});



    //}

    //private void bookDetail() {
      //  ProgressDialog progressDialog=new ProgressDialog(this);
        //progressDialog.setTitle("Add");
        //progressDialog.setMessage("booking Details");
        //progressDialog.show();

        //progressDialog.cancel();
        //String id= UUID.randomUUID().toString();
        //BookModel bookModel=new BookModel(id,hallModule.getTitle(),hallModule.getImage(),hallModule.getCapacity(), FirebaseAuth.getInstance().getUid());

        //FirebaseFirestore.getInstance()
          //      .collection("Booking_Details")
            //    .document(id)
              //  .set(bookModel);
        //Toast.makeText(this, "Booking Details added", Toast.LENGTH_SHORT).show();



    //}
}