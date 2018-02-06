package com.example.test;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 2018/2/1.
 */

public class MyFragment2 extends Fragment {
    Button btn6,btn5,btn4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1,container,false);

        btn4 = view.findViewById(R.id.button1);
        btn4.setText("BTN4");

        btn5 = view.findViewById(R.id.button2);
        btn5.setText("BTN5");

        btn6 = view.findViewById(R.id.button3);
        btn6.setText("BTN6");

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn6.setText("123");
            }
        });

        return view;
    }
}


