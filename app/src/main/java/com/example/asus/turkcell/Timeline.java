package com.example.asus.turkcell;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by ASUS on 13.09.2017.
 */

public class Timeline extends Fragment {

     private ImageView add;

    private  static  final String TAG="Timeline";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timeline,container,false);

        add = (ImageView) view.findViewById(R.id.img_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Storage.class);
                startActivity(intent);

            }
        });

        return  view;
    }
}
