package com.example.travelmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.UUID;

public class Details_Page extends AppCompatActivity {
ImageView imageView;
TextView avibly,description,distric,guidename,language,place,price,service,state,topic;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth auth;
    DatabaseReference reference;
    Placemodel placemodel = null;
    Usermodel user;
    FirebaseAuth firebaseAuth;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();

        final Object object = getIntent().getSerializableExtra("detail");
        if (object instanceof Placemodel){
            placemodel = (Placemodel) object;
        }

        imageView=findViewById(R.id.dimage);
        avibly=findViewById(R.id.davability);
        description=findViewById(R.id.ddescription);
        distric=findViewById(R.id.ddirdtic);
        guidename=findViewById(R.id.dguide);
        language=findViewById(R.id.dlanguage);
        place=findViewById(R.id.dplace);
        price=findViewById(R.id.dprice);
        service=findViewById(R.id.dservice);
        state=findViewById(R.id.dstate);
        topic=findViewById(R.id.dtopic);
        button=findViewById(R.id.acceptbtn);

        if (placemodel != null){
            Glide.with(getApplicationContext()).load(placemodel.getUri()).into(imageView);
            avibly.setText(placemodel.getAvability());
            distric.setText(String.valueOf(placemodel.getDirstic()));
            description.setText(placemodel.getDescription());
            guidename.setText(placemodel.getGuidname());
            language.setText(placemodel.getLanguage());
            place.setText(placemodel.getPlace());
            price.setText(placemodel.getPrice());
            service.setText(placemodel.getService());
            state.setText(placemodel.getState());
            topic.setText(placemodel.getTopic());

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (auth.getCurrentUser() != null) {


                    String saveCurrentDate, saveCurrenttime;
                    Calendar calForDate = Calendar.getInstance();


                    SimpleDateFormat currentDate = new SimpleDateFormat("MM, dd, yyyy");
                    saveCurrentDate = currentDate.format(calForDate.getTime());

                    SimpleDateFormat currenttime = new SimpleDateFormat("HH:mm:ss a");

                    saveCurrenttime = currenttime.format(calForDate.getTime());

                    String placename = place.getText().toString();
                    String guidname = guidename.getText().toString();
                    String pr = price.getText().toString();

                    reference.child("Usersregister").child(auth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if (task.isSuccessful()){
                                user = task.getResult().getValue(Usermodel.class);
                                String uuid = UUID.randomUUID().toString();
                                final HashMap<String, Object> cartMap = new HashMap<>();
                                cartMap.put("Date", saveCurrentDate);
                                cartMap.put("Time", saveCurrenttime);
                                cartMap.put("username",user.getName());
                                cartMap.put("mobilenumber",user.getPhone());
                                cartMap.put("email",user.getEmail());
                                cartMap.put("delete","0");
                                cartMap.put("accptedBy",firebaseAuth.getCurrentUser().getEmail());
                                cartMap.put("place",placename);
                                cartMap.put("guidename",guidname);
                                cartMap.put("price",pr);
                                cartMap.put("docId",uuid);

                                firebaseFirestore.collection("Booking").document(uuid)
                                        .set(cartMap)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Toast.makeText(Details_Page.this, "Accpted Chech My Accepted", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(Details_Page.this, Fill_Detail.class);
                                                intent.putExtra("place",placemodel.getPlace());
intent.putExtra("username",user.getName());
                                                intent.putExtra("price",pr);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(intent);
                                            }
                                        });

                            }
                        }
                    });



                }else {
                    Intent intent = new Intent(getApplicationContext(), Login_Page.class);
                    startActivity(intent);
                    finish();
                }


            }
        });

    }
}