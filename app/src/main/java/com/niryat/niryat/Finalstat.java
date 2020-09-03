package com.niryat.niryat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Finalstat extends AppCompatActivity {
    EditText total,value,tax,cert,tmt;
    TextView t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalstat);
        total= (EditText) findViewById(R.id.editText5);
        value= (EditText) findViewById(R.id.editText9);
        tax=(EditText) findViewById(R.id.editText18);
        cert=(EditText) findViewById(R.id.editText19);
        tmt= (EditText) findViewById(R.id.editText10);
        t1= (TextView) findViewById(R.id.textView7);
        t2= (TextView) findViewById(R.id.textView8);
        t3= (TextView) findViewById(R.id.textView9);
        t4= (TextView) findViewById(R.id.textView10);
        Bundle b1= getIntent().getExtras();

        Double s1= b1.getDouble("compvalue");
        Double s2=b1.getDouble("value");
        Double s3=b1.getDouble("comtax");
        Double s4=b1.getDouble("cert");
        Double s5=b1.getDouble("tmt");
        String r2= Double.toString(s1);
        String r1= Double.toString(s2);
        String r3= Double.toString(s3);
        String r4=Double.toString(s4);
        String r5=Double.toString(s5);
        total.setText(r2);
        value.setText(r1);
        tax.setText(r3);
        cert.setText(r4);
        tmt.setText(r5);
        value.setVisibility(View.INVISIBLE);
        t1.setVisibility(View.INVISIBLE);
        tax.setVisibility(View.INVISIBLE);
        cert.setVisibility(View.INVISIBLE);
        tmt.setVisibility(View.INVISIBLE);
        t2.setVisibility(View.INVISIBLE);
        t3.setVisibility(View.INVISIBLE);
        t4.setVisibility(View.INVISIBLE);
    }
    public void onVis(View view){
        value.setVisibility(View.VISIBLE);
        tax.setVisibility(View.VISIBLE);
        cert.setVisibility(View.VISIBLE);
        t1.setVisibility(View.VISIBLE);
        t2.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
        t4.setVisibility(View.VISIBLE);
        tmt.setVisibility(View.VISIBLE);
    }
    public void onMove(View view){
        Intent i1= new Intent(Finalstat.this,Home.class);
        startActivity(i1);
    }

}
