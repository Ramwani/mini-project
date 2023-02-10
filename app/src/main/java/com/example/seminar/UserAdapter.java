package com.example.seminar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;

    private List<Role> roleList;

    public UserAdapter(Context context) {
        this.context = context;
        roleList=new ArrayList<>();
    }

    public void addUser(Role role){
        roleList.add(role);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user_row,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Role role=roleList.get(position);
        holder.username.setText(role.getUsername());
        holder.email.setText(role.getEmail());
        holder.department.setText(role.getDepartment());
        holder.role.setText(role.getRole());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,UserDeatailsActivity.class);
                intent.putExtra("user_model",role);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return roleList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView username,email,department,role;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.username);
            email=itemView.findViewById(R.id.email);
            department=itemView.findViewById(R.id.department);
            role=itemView.findViewById(R.id.role);
        }
    }
}
