package com.example.seminar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class HallAdapter extends RecyclerView.Adapter<HallAdapter.MyViewHolder> {
    private Context context;
    private List<HallModule> hallModuleList;

    public HallAdapter(Context context) {
        this.context = context;
        hallModuleList=new ArrayList<>();
    }

    public void addHall(HallModule hallModule){
        hallModuleList.add(hallModule);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_seminar_hall_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HallModule hallModule=hallModuleList.get(position);
        holder.name.setText(hallModule.getTitle());
        holder.capacity.setText(hallModule.getCapacity());
        holder.location.setText(hallModule.getLocation());
        holder.description.setText(hallModule.getDescription());

        Glide.with(context).load(hallModule.getImage())
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("model",hallModule);
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return hallModuleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name,capacity,location,description;
        private ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            capacity=itemView.findViewById(R.id.capacity);
            location=itemView.findViewById(R.id.loc);
            description=itemView.findViewById(R.id.description);
            img=itemView.findViewById(R.id.image);
        }
    }
}
