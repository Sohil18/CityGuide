package com.example.travelmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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

public class Payment_Detail extends AppCompatActivity {
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    RecyclerView productView;
    List<Paymentmodel> paymentmodelList;
    Paymentdetailadapter paymentdetailadapter;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail);

        auth=FirebaseAuth.getInstance();
        database=FirebaseFirestore.getInstance();
        productView=findViewById(R.id.paymentdetailrec);
        productView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        paymentmodelList = new ArrayList<>();
        paymentdetailadapter = new Paymentdetailadapter(getApplicationContext(),paymentmodelList);
        productView.setAdapter(paymentdetailadapter);


        database.collection("Payment")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Paymentmodel paymentmodel = document.toObject(Paymentmodel.class);
                                paymentmodelList.add(paymentmodel);
                                paymentdetailadapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}