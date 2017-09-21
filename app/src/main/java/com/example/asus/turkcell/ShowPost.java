package com.example.asus.turkcell;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.net.URL;

public class ShowPost extends AppCompatActivity {

    private DatabaseReference database;
    String image;
    Context ctx;
    ImageView imageView;
    StorageReference download;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_post);

        imageView = (ImageView) findViewById(R.id.img_post);
        loadImageFromUrl("https://firebasestorage.googleapis.com/v0/b/denemeprojesi-38343.appspot.com/o/Images%2F1070052032?alt=media&token=6ed63e3a-43cb-4cdc-844c-26ce20b14131");


    }

    private void loadImageFromUrl(String s) {
        Picasso.with(this).load(s).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
