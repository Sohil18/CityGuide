package com.example.travelmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Paymentdetailadapter extends RecyclerView.Adapter<Paymentdetailadapter.ViewHolder>{
    private Context context;
    private List<Paymentmodel> paymentmodelList;

    public Paymentdetailadapter(Context context, List<Paymentmodel> paymentmodelList) {
        this.context = context;
        this.paymentmodelList = paymentmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Paymentdetailadapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.paymentdetail,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(paymentmodelList.get(position).getUsername());
        holder.cardnumber.setText(paymentmodelList.get(position).getCardnumber());
        holder.expire.setText(paymentmodelList.get(position).getDate());
        holder.cvv.setText(paymentmodelList.get(position).getCvv());
        holder.price.setText(paymentmodelList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return paymentmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,cardnumber,expire,cvv,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.holdername);
            cardnumber=itemView.findViewById(R.id.cardnumber);
            expire=itemView.findViewById(R.id.expiredate);
            cvv=itemView.findViewById(R.id.cvv);
            price=itemView.findViewById(R.id.price);
        }
    }
}
