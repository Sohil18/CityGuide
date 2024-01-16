package com.example.travelmate;

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

import java.util.List;

public class Stateadapter extends RecyclerView.Adapter<Stateadapter.ViewHolder>{

    private Context context;
    private List<Statemodel> statemodelList;

    public Stateadapter(Context context, List<Statemodel> statemodelList) {
        this.context = context;
        this.statemodelList = statemodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Stateadapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.state,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(statemodelList.get(position).getUri()).into(holder.imageView);
        holder.name.setText(statemodelList.get(position).getName());
        holder.state.setText(statemodelList.get(position).getState());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewAll_Activity.class);
             intent.putExtra("state",statemodelList.get(position).getState());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return statemodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,state;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.simg);
            name=itemView.findViewById(R.id.sname);
            state=itemView.findViewById(R.id.sstate);
        }
    }
}
