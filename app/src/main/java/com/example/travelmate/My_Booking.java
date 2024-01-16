package com.example.travelmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class My_Booking extends AppCompatActivity {
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    RecyclerView productView;
    List<Bookingmodel> bookingmodelList;
    Bookingadapter bookingadapter;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking);
auth=FirebaseAuth.getInstance();
        database=FirebaseFirestore.getInstance();
        productView=findViewById(R.id.bookingrec);
        productView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        bookingmodelList = new ArrayList<>();
        bookingadapter = new Bookingadapter(getApplicationContext(),bookingmodelList);
        productView.setAdapter(bookingadapter);


        database.collection("Booking").whereEqualTo("accptedBy",auth.getCurrentUser().getEmail())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Bookingmodel bookingmodel = document.toObject(Bookingmodel.class);
                                bookingmodelList.add(bookingmodel);
                                bookingadapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}