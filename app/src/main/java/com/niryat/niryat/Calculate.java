package com.niryat.niryat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Calculate extends AppCompatActivity {
    EditText val,hc,cf,fob,tmt,cd,it,oc,ins;
    double v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        Bundle b1= getIntent().getExtras();

        Double t1=b1.getDouble("handc");
        String c1=Double.toString(t1);
        Double t2=b1.getDouble("ins");
        String c2=Double.toString(t2);
        Double t3=b1.getDouble("transc");
        String c3=Double.toString(t3);
        Double s1= b1.getDouble("compvalue",v3);
        String r2= Double.toString(s1);
        val= (EditText) findViewById(R.id.editText11);
        hc= (EditText) findViewById(R.id.editText12);
        hc.setText(c1);
        cf= (EditText) findViewById(R.id.editText13);
        fob= (EditText) findViewById(R.id.editText14);
        fob.setText(c3);
        tmt= (EditText) findViewById(R.id.editText15);
        cd= (EditText) findViewById(R.id.editText16);
        it =(EditText) findViewById(R.id.editText3);
        ins=(EditText) findViewById(R.id.editText20);
        ins.setText(c2);
        oc= (EditText) findViewById(R.id.editText17);
        val.setText(r2);
    }
    public void onCalculate(View view){
        v1= Double.parseDouble(val.getText().toString());
        v2= Double.parseDouble(hc.getText().toString());
        v3= Double.parseDouble(cf.getText().toString());
        v4= Double.parseDouble(fob.getText().toString());
        v5= Double.parseDouble(tmt.getText().toString());
        v6= Double.parseDouble(cd.getText().toString());
        v7= Double.parseDouble(it.getText().toString());
        v8= Double.parseDouble(ins.getText().toString());
        v9= Double.parseDouble(oc.getText().toString());
        v11= (v7+v6);
        v10=v1+v2+v3+v4+v5+(v6*v1)+(v7*v1)+v8+v9;
        Intent i1= new Intent(Calculate.this,Finalstat.class);
        Bundle bundle= new Bundle();
        bundle.putDouble("compvalue",v10);
        bundle.putDouble("value",v1);
        bundle.putDouble("comtax",v11);
        bundle.putDouble("cert",v9);
        bundle.putDouble("tmt",v5);
        i1.putExtra("compvalue",v10);
        i1.putExtras(bundle);
        startActivity(i1);
    }
    public void onReset( View view){

        val.setText("");
        hc.setText("");
        cf.setText("");
        fob.setText("");
        tmt.setText("");
        cd.setText("");
        it.setText("");
        ins.setText("");
        oc.setText("");
    }
}

