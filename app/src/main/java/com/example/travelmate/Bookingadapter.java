package com.example.travelmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Bookingadapter extends RecyclerView.Adapter<Bookingadapter.ViewHolder>{

    private Context context;
    private List<Bookingmodel> bookingmodelList;

    public Bookingadapter(Context context, List<Bookingmodel> bookingmodelList) {
        this.context = context;
        this.bookingmodelList = bookingmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Bookingadapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.booking,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(bookingmodelList.get(position).getDate());
        holder.time.setText(bookingmodelList.get(position).getTime());
        holder.place.setText(bookingmodelList.get(position).getPlace());
        holder.gname.setText(bookingmodelList.get(position).getGuidename());
    }

    @Override
    public int getItemCount() {
        return bookingmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView date,time,place,gname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.bdate);
            time=itemView.findViewById(R.id.btime);
            place=itemView.findViewById(R.id.bplace);
            gname=itemView.findViewById(R.id.bguidename);

        }
    }
}
