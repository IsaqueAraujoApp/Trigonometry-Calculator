package com.example.isaquearaujo.trigonometrycalculator;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrianguloRetangulo extends Fragment {
    ArrayList<String>  lista;
    Spinner valordesejado;
    DrawerListAdapter adapterdrawer;
    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    TextView titleView;
    String ValorA, ValorB, ValorC, ValorAngA, ValorAngB, ValorArea, ValorPerimetro;
    double VA, VB, VC, VAa, VBb, Varea, Vperimetro, Resultcalc;
    EditText A, B, C, AngA, AngB;
    TextView Resultado;
    Button Calcular;
    int positionclick;
    public TrianguloRetangulo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_triangulo_retangulo, container, false);
        valordesejado = (Spinner)view.findViewById(R.id.valordesejado);
        mNavItems.add(new NavItem("Lado A (Menor cateto)"));
        mNavItems.add(new NavItem("Lado B (Maior cateto)"));
        mNavItems.add(new NavItem("Lado C (Hipotenusa)"));
        mNavItems.add(new NavItem("Ângulo a"));
        mNavItems.add(new NavItem("Ângulo b"));
        mNavItems.add(new NavItem("Área do triângulo"));
        mNavItems.add(new NavItem("Perímetro do triângulo"));
        adapterdrawer = new DrawerListAdapter(getContext(), mNavItems);
        valordesejado.setAdapter(adapterdrawer);
        A = (EditText)view.findViewById(R.id.valora);
        B = (EditText)view.findViewById(R.id.valorb);
        C = (EditText)view.findViewById(R.id.valorc);
        AngA = (EditText)view.findViewById(R.id.valoranga);
        AngB = (EditText)view.findViewById(R.id.valorangb);
        Resultado = (TextView)view.findViewById(R.id.result);
        Calcular = (Button)view.findViewById(R.id.calcret);
        valordesejado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            positionclick = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (positionclick)
                {
                    case 0:
                        if(C.getText().toString() !="" & B.getText().toString() !="" )
                        {Log.d("dasdasdas", "foi");
                            ValorC = C.getText().toString();
                            ValorB = B.getText().toString();
                            VB = Double.parseDouble(ValorB);
                            VC = Double.parseDouble(ValorC);
                            Resultcalc = Math.sqrt(((VC*VC)-(VB*VB)));
                            Resultado.setText(String.valueOf(Resultcalc));
                        }
                        else if(AngA.getText().toString() !="" & B.getText().toString() !="" )
                        {
                            ValorAngA = AngA.getText().toString();
                            ValorB = B.getText().toString();
                            VB = Double.parseDouble(ValorB);
                            VAa = Double.parseDouble(ValorAngA);
                            double angx = 90 - VAa;
                            Resultcalc = (VB/(Math.sin(angx*(Math.PI/180))))*(Math.sin(VAa*Math.PI/180));
                            Resultado.setText(String.valueOf(Resultcalc));
                        }/*
                         else if(AngB.getText().toString() !="" && B.getText().toString() !="" && A.getText().toString() =="" && C.getText().toString() =="" && AngA.getText().toString() =="")
                        {
                            ValorAngB = AngB.getText().toString();
                            ValorB = B.getText().toString();
                            VB = Double.parseDouble(ValorB);
                            VBb = Double.parseDouble(ValorAngB);
                            double angx = 90 - VBb;
                            Resultcalc = (VB/(Math.sin(VBb*(Math.PI/180))))*(Math.sin(angx*Math.PI/180));
                            Resultado.setText(String.valueOf(Resultcalc));
                        }*/
                        break;
                }
            }
        });

        return view;
    }
    class NavItem {
        String mTitle;


        public NavItem(String title) {
            mTitle = title;

        }
    }

    class DrawerListAdapter extends BaseAdapter {
        Context mContext;
        ArrayList<NavItem> mNavItems;

        public DrawerListAdapter(Context context, ArrayList<NavItem> navItems) {
            mContext = context;
            mNavItems = navItems;
        }

        @Override
        public int getCount() {
            return mNavItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mNavItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {
            View view;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.item_spiner, null);
            } else {
                view = convertView;
            }
            titleView = (TextView) view.findViewById(R.id.titlespiner);

            //titleView.setTypeface(typeface);


            titleView.setText(mNavItems.get(position).mTitle);
            return view;
        }
    }

}
