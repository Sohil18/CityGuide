package com.example.travelmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Complete_Payment extends AppCompatActivity {
   TextView start,end,name,price,place;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_payment);

        Intent i = getIntent();

        String title = i.getStringExtra("startdate");
        start = findViewById(R.id.comstart);
        start.setText(title);

        String na = i.getStringExtra("enddate");
        end = findViewById(R.id.comend);
        end.setText(na);

        String pr = i.getStringExtra("username");
        name = findViewById(R.id.comname);
        name.setText(pr);

        String pri = i.getStringExtra("price");
       price = findViewById(R.id.comprice);
        price.setText(pri);

        String pal = i.getStringExtra("place");
        place = findViewById(R.id.complace);
      place.setText(pal);


    }
}