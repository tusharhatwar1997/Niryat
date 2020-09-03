package com.niryat.niryat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class starttc extends AppCompatActivity {
    Spinner s1, s2,s3;
    Double v1,v2,x1,x2;
    EditText e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starttc);
        s1 = (Spinner) findViewById(R.id.spinner2);
        s2 = (Spinner) findViewById(R.id.spinner3);
        s3= (Spinner) findViewById(R.id.spinner6);
        e1= (EditText) findViewById(R.id.editText21);
        e2= (EditText) findViewById(R.id.editText22);
        e3= (EditText) findViewById(R.id.editText23);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                String product= String.valueOf(s2.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {

                String category = String.valueOf(s1.getSelectedItem());

                if(category.contentEquals("Agriculture products")) {
                    List<String> list = new ArrayList<String>();
                    list.add("Calcium Nitrate Field Grade (Nitrogen Fertiliser For Agriculture Use Only)");
                    list.add("AGRICULTURE PESTICIDES");
                    list.add("COTTON SEEDS");
                    list.add("Oranges,Fresh Oranges Or Dried ");
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item, list);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter.notifyDataSetChanged();
                    s2.setAdapter(dataAdapter);
                }
                if(category.contentEquals("Automobiles")) {
                    List<String> list = new ArrayList<String>();
                    list.add("Rubber Insulators For Automobiles, Of Unvulcanized Rubber");
                    list.add("Halogen Lamps For Automobiles");
                    list.add("Automobiles With Diesel Engine Displacing Not More Than 1500 Cc");
                    list.add("Automobiles With Diesel Engine Displacing More Than 1500 Cc To 2500 Cc");
                    ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item, list);
                    dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter2.notifyDataSetChanged();
                    s2.setAdapter(dataAdapter2);
                }
                if(category.contentEquals("Spices")) {
                    List<String> list = new ArrayList<String>();
                    list.add("Turrmeric");
                    list.add("Black pepper");
                    list.add("Cardemin");
                    list.add("Powders");
                    ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item, list);
                    dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter2.notifyDataSetChanged();
                    s2.setAdapter(dataAdapter2);
                }
                if(category.contentEquals("Hardware")) {
                    List<String> list = new ArrayList<String>();
                    list.add("CPU components");
                    list.add("Other integration parts");
                    list.add("Keyboard essentials");
                    list.add("Connecting links instrument");
                    ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item, list);
                    dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter2.notifyDataSetChanged();
                    s2.setAdapter(dataAdapter2);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {

                String unit= String.valueOf(s3.getSelectedItem());

                if(unit.contentEquals("lbs")) {


                }
                if(unit.contentEquals("Kg")) {

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });
    }
    public void onSubmit( View view){
       Double x1,x2,x3;
        v1= Double.parseDouble(e1.getText().toString());
        v2= Double.parseDouble(e2.getText().toString());
        String prod = String.valueOf(s2.getSelectedItem());
        if(prod=="RInsulatorsubber  For Automobiles, Of Unvulcanized Rubber" && v2>100){
            x1=200.00;
            x2=2300.00;
            x3=4520.00;
        }
        else if(prod=="Halogen Lamps For Automobiles" && v2>100){
         x1=300.00;
         x2=2400.00;
         x3=7400.00;

        }
        else if(prod=="Automobiles With Diesel Engine Displacing Not More Than 1500 Cc" && v2>100){
            x1=700.00;
            x2=6540.00;
            x3=4300.00;
        }
        else if(prod=="Automobiles With Diesel Engine Displacing More Than 1500 Cc" && v2>100){
            x1=900.00;
            x2=8000.00;
            x3=3455.00;
        }
        else{
           x1=500.00;
                   x2=5000.00;
                   x3=3500.00;
        }
        Double v3= v1*v2;
        Bundle bundle= new Bundle();
        bundle.putDouble("compvalue",v3);
        bundle.putDouble("handc",x1);
        bundle.putDouble("ins",x2);
        bundle.putDouble("transc",x3);
        Intent i1= new Intent(starttc.this,Calculate.class);
        i1.putExtras(bundle);
        startActivity(i1);
    }
}