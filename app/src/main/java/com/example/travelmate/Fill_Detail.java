package com.example.travelmate;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Fill_Detail extends AppCompatActivity {


Button submit;
TextView place,name,price;
EditText sdate,edate,ppoint,dpoint,days;
Placemodel placemodel = null;
Usermodel usermodel;

    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_detail);
        sdate=findViewById(R.id.startdate);
        edate=findViewById(R.id.enddate);
        ppoint=findViewById(R.id.pickuppoint);
        dpoint=findViewById(R.id.drouppoint);
        days=findViewById(R.id.noofdays);



        submit=findViewById(R.id.makepayment);
        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();

        Intent i = getIntent();

        String title = i.getStringExtra("place");
        place = findViewById(R.id.rrlogin);
        place.setText(title);

        String na = i.getStringExtra("username");
        name = findViewById(R.id.rname);
        name.setText(na);

        String pr = i.getStringExtra("price");
        price = findViewById(R.id.dprice);
        price.setText(pr);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
String ti = place.getText().toString();
String na = name.getText().toString();
String pri = price.getText().toString();
String startingdate = sdate.getText().toString();
String enddate = edate.getText().toString();
String pickuppoint = ppoint.getText().toString();
String droppoint = dpoint.getText().toString();
String noofdays = days.getText().toString();

                String uuid = UUID.randomUUID().toString();
                final HashMap<String, Object> objectMap = new HashMap<>();

objectMap.put("place",ti);
                objectMap.put("username",na);
                objectMap.put("price",pri);
                objectMap.put("sartdate",startingdate);
                objectMap.put("enddate",enddate);
                objectMap.put("pickuppoint",pickuppoint);
                objectMap.put("drouppoint",droppoint);
                objectMap.put("days",noofdays);

                objectMap.put("acceptedby",firebaseAuth.getCurrentUser().getEmail());
                objectMap.put("docId",uuid);
                firebaseFirestore.collection("MyBooking").document(uuid)
                        .set(objectMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Intent intent = new Intent(Fill_Detail.this, Make_Payment.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra("place",ti);
                                intent.putExtra("price",pri);
                                intent.putExtra("username",na);
                                intent.putExtra("sartdate",startingdate);
                                intent.putExtra("enddate",enddate);
                                intent.putExtra("pickuppoint",pickuppoint);
                                intent.putExtra("drouppoint",droppoint);
                                intent.putExtra("days",noofdays);

                                startActivity(intent);
                                finish();
                            }
                        });



            }
        });



    }
}