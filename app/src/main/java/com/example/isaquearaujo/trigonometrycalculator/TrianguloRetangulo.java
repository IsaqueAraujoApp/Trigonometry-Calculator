package com.example.isaquearaujo.trigonometrycalculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrianguloRetangulo extends Fragment {
    RadioGroup valordesejado;
    ArrayList<String>  lista;
    public TrianguloRetangulo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_triangulo_retangulo, container, false);

        valordesejado = (RadioGroup)view.findViewById(R.id.valordesejado);
        valordesejado.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                switch (rb.getId())
                {
                    case R.id.radio_pirates:
                        Log.d("dasdasda","dasssssssss");
                        break;
                    case R.id.radio_ninjas:
                        Log.d("dasdasda","dasssssssss");
                        break;
                }
            }
        });
        return view;
    }

}
