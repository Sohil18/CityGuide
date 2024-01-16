package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.UUID;

public class Make_Payment extends AppCompatActivity {
EditText cname,number,cvv,date;
TextView textView,pname,startdate,enddate,pickuppoint,drouppoint,noofdays,place;
Button save;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);
        cname=findViewById(R.id.cardname);
        number=findViewById(R.id.cardnumber);
        cvv=findViewById(R.id.cardcvv);
        save=findViewById(R.id.cardsave);
        date=findViewById(R.id.expiredate);


        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();


        Intent i = getIntent();
        String title = i.getStringExtra("price");
        textView = findViewById(R.id.paymentcost);
        textView.setText(title);


        String name = i.getStringExtra("username");
        pname = findViewById(R.id.paymentname);
        pname.setText(name);

        String start = i.getStringExtra("sartdate");
        startdate = findViewById(R.id.mstartdate);
        startdate.setText(start);

        String end = i.getStringExtra("enddate");
        enddate = findViewById(R.id.menddate);
        enddate.setText(end);

        String pickup = i.getStringExtra("pickuppoint");
        pickuppoint = findViewById(R.id.mpickupdate);
        pickuppoint.setText(pickup);


        String droup = i.getStringExtra("drouppoint");
        drouppoint = findViewById(R.id.mpickupdate);
        drouppoint.setText(droup);

        String days = i.getStringExtra("days");
        noofdays = findViewById(R.id.mnoofdays);
        noofdays.setText(days);

        String pa = i.getStringExtra("place");
        place = findViewById(R.id.mplace);
        place.setText(pa);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
String s = startdate.getText().toString();
String e = enddate.getText().toString();
String p = pickuppoint.getText().toString();
String d = drouppoint.getText().toString();
String da = noofdays.getText().toString();
                String pp = place.getText().toString();
                String pri = textView.getText().toString();
                String uname = pname.getText().toString();
                String cardname = cname.getText().toString();
                String cardnumber = number.getText().toString();
                String cardcvv = cvv.getText().toString();
                String ecpire = date.getText().toString();


                String uuid = UUID.randomUUID().toString();
                final HashMap<String, Object> objectMap = new HashMap<>();
                objectMap.put("startdate",s);
                objectMap.put("place",pp);
                objectMap.put("enddate",e);
                objectMap.put("pickuppoint",p);
                objectMap.put("drouppoint",d);
                objectMap.put("days",da);
                objectMap.put("price",pri);
                objectMap.put("username",uname);
                objectMap.put("cardname",cardname);
                objectMap.put("cardnumber",cardnumber);
                objectMap.put("cvv",cardcvv);
                objectMap.put("date",ecpire);;
                objectMap.put("docId",uuid);
                objectMap.put("acceptedby",firebaseAuth.getCurrentUser().getEmail());
                firebaseFirestore.collection("Payment").document(uuid)
                        .set(objectMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Intent intent = new Intent(Make_Payment.this, Complete_Payment.class);
                                intent.putExtra("startdate",s);
                                intent.putExtra("enddate",e);
                                intent.putExtra("username",uname);
                                intent.putExtra("price",pri);
                                intent.putExtra("place",pp);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                                startActivity(intent);
                                finish();
                            }
                        });





            }
        });

    }
}