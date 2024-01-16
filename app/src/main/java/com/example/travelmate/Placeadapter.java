package com.example.travelmate;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Placeadapter extends RecyclerView.Adapter<Placeadapter.ViewHolder>{
    private Context context;
    private List<Placemodel> placemodelList;

    public Placeadapter(Context context, List<Placemodel> placemodelList) {
        this.context = context;
        this.placemodelList = placemodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Placeadapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.place,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(placemodelList.get(position).getUri()).into(holder.imageView);
        holder.place.setText(placemodelList.get(position).getPlace());
        holder.price.setText(placemodelList.get(position).getPrice());
        holder.desription.setText(placemodelList.get(position).getDescription());
        holder.state.setText(placemodelList.get(position).getState());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details_Page.class);
                intent.putExtra("detail",placemodelList.get(position));
                intent.putExtra("state",placemodelList.get(position).getState());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return placemodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView place,price,desription,state;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.pimage);
            place=itemView.findViewById(R.id.pplace);
            price=itemView.findViewById(R.id.pprice);
            desription=itemView.findViewById(R.id.pdescription);
            state=itemView.findViewById(R.id.pstate);

        }
    }
}
