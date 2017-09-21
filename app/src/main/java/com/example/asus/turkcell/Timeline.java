package com.example.asus.turkcell;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * Created by ASUS on 13.09.2017.
 */

public class Timeline extends Fragment {

    private RecyclerView postList;
    private ImageView add;
    private DatabaseReference database;

    private  static  final String TAG="Timeline";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timeline,container,false);
        add = (ImageView) view.findViewById(R.id.img_add);

        database = FirebaseDatabase.getInstance().getReference().child("Images");

        postList = (RecyclerView) view.findViewById(R.id.post_list);
        postList.setHasFixedSize(true);
        postList.setLayoutManager(new LinearLayoutManager(getActivity()));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Storage.class);
                startActivity(intent);

            }
        });

        return  view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Post, PostViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Post, PostViewHolder>(
                Post.class,
                R.layout.timeline_row,
                PostViewHolder.class,
                database
        ) {
            @Override
            protected void populateViewHolder(PostViewHolder viewHolder, Post model, int position) {
               viewHolder.setName(model.getName());
               viewHolder.setDesc(model.getDescription());
                viewHolder.setImage(getActivity().getApplicationContext(), model.getImage());

            }
        };

        postList.setAdapter(firebaseRecyclerAdapter);


    }


    public static class PostViewHolder extends RecyclerView.ViewHolder {
        View view;

        public PostViewHolder(View itemView) {
            super(itemView);

            view = itemView;
        }

        public void setName(String name){

            TextView post_name = (TextView) view.findViewById(R.id.post_name);
            post_name.setText(name);

        }

        public void setDesc(String desc){
            TextView post_desc = (TextView) view.findViewById(R.id.post_description);
            post_desc.setText(desc);
        }

        public void setImage(Context ctx, String image){
            ImageView post_image = (ImageView) view.findViewById(R.id.post_image);
            Picasso.with(ctx).load(image).into(post_image);

        }


    }
}
