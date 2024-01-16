package com.example.travelmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewAll_Activity extends AppCompatActivity {
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    RecyclerView productView;
    List<Placemodel> placemodelList;
    Placeadapter placeadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        String type = getIntent().getStringExtra("state");
        database=FirebaseFirestore.getInstance();
        productView=findViewById(R.id.viewrec);
        productView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        placemodelList = new ArrayList<>();
        placeadapter = new Placeadapter(getApplicationContext(),placemodelList);
        productView.setAdapter(placeadapter);

        if (type != null && type.equalsIgnoreCase("Bihar")) {
            database.collection("Place").whereEqualTo("state", "Bihar")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Andhra Pradesh")) {
            database.collection("Place").whereEqualTo("state", "Andhra Pradesh")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Goa")) {
            database.collection("Place").whereEqualTo("state", "Goa")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Arunachal Pradesh")) {
            database.collection("Place").whereEqualTo("state", "Arunachal Pradesh")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Chhattisgarh")) {
            database.collection("Place").whereEqualTo("state", "Chhattisgarh")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Goa")) {
            database.collection("Place").whereEqualTo("state", "Goa")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Gujarat")) {
            database.collection("Place").whereEqualTo("state", "Gujarat")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Haryana")) {
            database.collection("Place").whereEqualTo("state", "Haryana")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Himachal Pradesh")) {
            database.collection("Place").whereEqualTo("state", "Himachal Pradesh")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Jharkhand")) {
            database.collection("Place").whereEqualTo("state", "Jharkhand")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Karnataka")) {
            database.collection("Place").whereEqualTo("state", "Karnataka")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Kerala")) {
            database.collection("Place").whereEqualTo("state", "Kerala")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Madhya Pradesh")) {
            database.collection("Place").whereEqualTo("state", "Madhya Pradesh")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Maharashtra")) {
            database.collection("Place").whereEqualTo("state", "Maharashtra")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Manipur")) {
            database.collection("Place").whereEqualTo("state", "Manipur")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Meghalaya")) {
            database.collection("Place").whereEqualTo("state", "Meghalaya")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Mizoram")) {
            database.collection("Place").whereEqualTo("state", "Mizoram")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Nagaland")) {
            database.collection("Place").whereEqualTo("state", "Nagaland")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Odisha")) {
            database.collection("Place").whereEqualTo("state", "Odisha")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Punjab")) {
            database.collection("Place").whereEqualTo("state", "Punjab")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Rajasthan")) {
            database.collection("Place").whereEqualTo("state", "Rajasthan")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Sikkim")) {
            database.collection("Place").whereEqualTo("state", "Sikkim")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Tamil Nadu")) {
            database.collection("Place").whereEqualTo("state", "Tamil Nadu")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Uttar Pradesh")) {
            database.collection("Place").whereEqualTo("state", "Uttar Pradesh")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("Uttarakhand")) {
            database.collection("Place").whereEqualTo("state", "Uttarakhand")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("West Bengal")) {
            database.collection("Place").whereEqualTo("state", "West Bengal")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Placemodel category_model = document.toObject(Placemodel.class);
                                    placemodelList.add(category_model);
                                    placeadapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }




    }
}