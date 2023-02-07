package com.example.seminar;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.seminar.databinding.ActivityAddHallsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class AddHallsActivity extends AppCompatActivity {
    ActivityAddHallsBinding binding;

    private String id,title,description,capacity,location;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddHallsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addSeminarHall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title=binding.title.getText().toString();
                capacity=binding.capacity.getText().toString();
                location=binding.location.getText().toString();
                description=binding.description.getText().toString();
                addSeminarHall();
            }
        });




        binding.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                //startActivityForResult(intent.createChooser(intent,"Select the image"),100);
            }
        });
        binding.uploadPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });
    }
    private void uploadImage() {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference("Seminar_Halls/*"+id+".png");

        storageReference.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        storageReference.getDownloadUrl()
                                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        FirebaseFirestore.getInstance()
                                                .collection("Seminar_Halls")
                                                .document(id)
                                                .update("image",uri.toString());
                                        Toast.makeText(AddHallsActivity.this,"Done",Toast.LENGTH_SHORT).show();


                                    }
                                });


                    }
                });
    }
    private void addSeminarHall() {
        id= UUID.randomUUID().toString();
        HallModule hallModule=new HallModule(id,title,capacity,location,description,null,true);
        FirebaseFirestore.getInstance()
                .collection("Seminar_Halls")
                .document(id)
                .set(hallModule);
        Toast.makeText(this,"Seminar Hall Added",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            uri=data.getData();
            binding.image.setImageURI(uri);

        }
    }


}