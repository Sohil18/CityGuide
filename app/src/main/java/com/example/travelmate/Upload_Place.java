package com.example.travelmate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Upload_Place extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    String[] page = {"Choose Option","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa",
            "Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra",
            "Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana",
            "Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
    TextView textView;


    ///
    ImageView uploadPicIV;
    EditText name,place,state,dirstic,description,topic,service,language,avability,price,guidname;
    private ProgressBar uploadProgressBar;
    final int IMAGE_REQUEST = 71;
    Uri imageLocationPath;
    String id;
    StorageReference objectStorageReference;
    FirebaseFirestore objectFirebaseFirestore;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_place);

        place=findViewById(R.id.plcename);
        state=findViewById(R.id.statename);
        dirstic=findViewById(R.id.distickname);
        description=findViewById(R.id.discription);
        topic=findViewById(R.id.localtopic);
        service=findViewById(R.id.service);
        language=findViewById(R.id.language);
        avability=findViewById(R.id.availabilty);
        price=findViewById(R.id.price);
        guidname=findViewById(R.id.guidee);



        spinner=findViewById(R.id.spineerr);
        textView=findViewById(R.id.textt);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,page);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        ///
        //  uploadPicET = findViewById(R.id.imageNameET);
        uploadPicIV = findViewById(R.id.imageIDg);
        name=findViewById(R.id.imageNamee);
        uploadProgressBar = findViewById(R.id.progress_bar);

        objectStorageReference = FirebaseStorage.getInstance().getReference("imageFolder"); // Create folder to Firebase Storage
        objectFirebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
    }

    public void selectImage(View view){
        try {
            Intent objectIntent = new Intent();
            objectIntent.setType("image/*");

            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent,IMAGE_REQUEST);

        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if (requestCode == IMAGE_REQUEST
                    && resultCode == RESULT_OK
                    && data != null
                    && data.getData() != null){
                imageLocationPath = data.getData();
                Bitmap objectBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageLocationPath);
                uploadPicIV.setImageBitmap(objectBitmap);
            }

        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void uploadImage(View view){
        try {
            if(/*!uploadPicET.getText().toString().isEmpty() && */imageLocationPath != null){
                //String nameOfimage = "." + getExtension(imageLocationPath);
                String nameOfimage = name.getText().toString() + "." + getExtension(imageLocationPath);
                uploadProgressBar.setVisibility(View.VISIBLE);
                uploadProgressBar.setIndeterminate(true);
                final StorageReference imageRef = objectStorageReference.child(nameOfimage);

                UploadTask objectUploadTask = imageRef.putFile(imageLocationPath);

                objectUploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if(!task.isSuccessful()){

                            throw task.getException();

                        }
                        return imageRef.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()){
                            String typename = textView.getText().toString();
                            String nae = name.getText().toString();
                            String placename = place.getText().toString();
                            String statename = state.getText().toString();
                            String disname = dirstic.getText().toString();
                            String descri = description.getText().toString();
                            String localtopic = topic.getText().toString();
                            String serv = service.getText().toString();
                            String lan = language.getText().toString();
                            String avib = avability.getText().toString();
                            String pri = price.getText().toString();
                            String gui = guidname.getText().toString();

                            String uuid = UUID.randomUUID().toString();
                            Map<String,Object> objectMap = new HashMap<>();
                            String docId = objectFirebaseFirestore.collection("data").document().getId();
                            objectMap.put("uri", task.getResult().toString());
                            objectMap.put("name", nae);
                            objectMap.put("place", placename);
                            objectMap.put("state", statename);
                            objectMap.put("dirstic", disname);
                            objectMap.put("description",descri);
                            objectMap.put("topic", localtopic);
                            objectMap.put("service", serv);
                            objectMap.put("language", lan);
                            objectMap.put("avability", avib);
                            objectMap.put("price", pri);
                            objectMap.put("guidname", gui);
                            objectMap.put("delete","0");
                            objectMap.put("sendedBy",firebaseAuth.getCurrentUser().getEmail());
                            objectMap.put("state",typename);
                            objectMap.put("docId",uuid);


                          /*  objectFirebaseFirestore.collection("Product").document(uuid)
                                    .set(uuid)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(Donate.this, "Ok", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(Donate.this, Donate.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    })

                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error adding document", e);
                                        }
                                    });*/
                          /*objectFirebaseFirestore.collection("Product")
                                    .add(objectMap)
                                    .addOnSuccessListener.(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            uploadProgressBar.setVisibility(View.VISIBLE);
                                            uploadProgressBar.setIndeterminate(false);
                                            uploadProgressBar.setProgress(0);
                                            Toast.makeText(Donate.this, "Upload Sucessfully", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error adding document", e);
                                        }
                                    });*/
                            objectFirebaseFirestore.collection("Place").document(uuid)
                                    .set(objectMap)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            uploadProgressBar.setVisibility(View.VISIBLE);
                                            uploadProgressBar.setIndeterminate(false);
                                            uploadProgressBar.setProgress(0);
                                            Toast.makeText(Upload_Place.this, "Upload Sucessfully", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        } else if (!task.isSuccessful()){
                            Toast.makeText(Upload_Place.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            } else {
                Toast.makeText(this, "Please provide name for image", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private String getExtension(Uri uri){
        try {
            ContentResolver objectContentResolver = getContentResolver();
            MimeTypeMap objectMimeTypeMap = MimeTypeMap.getSingleton();

            return objectMimeTypeMap.getExtensionFromMimeType(objectContentResolver.getType(uri));

        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return null;



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = spinner.getSelectedItem().toString();
        textView.setText(text);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {



    }
}