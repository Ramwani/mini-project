package com.example.seminar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private Context context;

    private List<BookModel> bookModelList;

    public BookAdapter(Context context){
        this.context=context;
        bookModelList=new ArrayList<>();
    }

    public void bookHall(BookModel bookModel){
        bookModelList.add(bookModel);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_book_row,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.BookViewHolder holder, int position) {
        BookModel bookModel=bookModelList.get(position);
        holder.hallName.setText(bookModel.getHallName());
        holder.event.setText(bookModel.getEvent());
        holder.bookedBy.setText(bookModel.getUsername());
        holder.department.setText(bookModel.getDepartment());
        holder.date.setText(bookModel.getDate());
        holder.time.setText(bookModel.getTime());
        holder.duration.setText(bookModel.getDuration());



    }

    @Override
    public int getItemCount() {
        return bookModelList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        private TextView hallName,event,bookedBy,department,date,time,duration;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            hallName=itemView.findViewById(R.id.hallName);
            event=itemView.findViewById(R.id.event);
            bookedBy=itemView.findViewById(R.id.bookedBy);
            department=itemView.findViewById(R.id.department);
            date=itemView.findViewById(R.id.date);
            time=itemView.findViewById(R.id.time);
            duration=itemView.findViewById(R.id.duration);

        }
    }
}
