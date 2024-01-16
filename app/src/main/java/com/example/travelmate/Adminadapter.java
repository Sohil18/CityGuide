package com.example.travelmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adminadapter extends RecyclerView.Adapter<Adminadapter.ViewHolder>{
    private Context context;
    private List<Paymentmodel> paymentmodelList;

    public Adminadapter(Context context, List<Paymentmodel> paymentmodelList) {
        this.context = context;
        this.paymentmodelList = paymentmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Adminadapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.admin,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(paymentmodelList.get(position).getUsername());
        holder.start.setText(paymentmodelList.get(position).getStartdate());
        holder.end.setText(paymentmodelList.get(position).getEnddate());
        holder.place.setText(paymentmodelList.get(position).getPlace());
    }

    @Override
    public int getItemCount() {
        return paymentmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,start,end,place;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.comname);
            start=itemView.findViewById(R.id.comstart);
            end=itemView.findViewById(R.id.comend);
            place=itemView.findViewById(R.id.comprice);
        }
    }
}
