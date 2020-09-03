package com.niryat.niryat;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analytics extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner s1,s2,s3;

    String analytics_url = "https://wwwtexacom.000webhostapp.com/Analytics.php";
    String Category,Product,Year;

    List<Export> exportData;
    RecyclerView recyclerView;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        exportData = new ArrayList<>();
        progressDialog = new ProgressDialog(this);


        s1 = findViewById(R.id.spinner1);
        s2 = findViewById(R.id.spinner2);
        s3 = findViewById(R.id.spinner3);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Product = String.valueOf(s2.getSelectedItem());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});


        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Year = String.valueOf(s3.getSelectedItem());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        s1.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {

        String category = String.valueOf(s1.getSelectedItem());
        Category = category;

        if(category.contentEquals("Agriculture")) {
            List<String> list = new ArrayList<>();
            list.add("Calcium Nitrate Field Grade (Nitrogen Fertilizer)");
            list.add("COTTON SEEDS");
            list.add("Oranges,Fresh Oranges Or Dried");
            list.add("AGRICULTURAL PESTICIDE");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
        if(category.contentEquals("Automobile")) {
            List<String> list = new ArrayList<>();
            list.add("Rubber Insulators For Automobiles,Of Unvulcanized Rubber");
            list.add("Halogen Lamps For Automobiles");
            list.add("Automobiles With Diesel Engine Displacing Not More Than 1500 Cc");
            list.add("Automobiles With Diesel Engine Displacing More Than 1500 Cc To 2500Cc");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }


        if(category.contentEquals("Hardware")) {
            List<String> list = new ArrayList<>();
            list.add("CPU components");
            list.add("Other integration parts");
            list.add("Keyboard essentials");
            list.add("Connecting links instrument");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }

        if(category.contentEquals("Spices")) {







            List<String> list = new ArrayList<>();
            list.add("Turrmeric");
            list.add("Black Pepper");
            list.add("Cardemin");
            list.add("Powders");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {


    }



public void onShow(View view){
    loadExport();


}


    private void loadExport() {
        progressDialog.setMessage("please wait.....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, analytics_url,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    progressDialog.dismiss();

                    JSONArray array = new JSONArray(response);


                    for (int i = 0; i < array.length(); i++) {

                            JSONObject export = array.getJSONObject(i);


                        exportData.add(new Export(

                                export.getString("product"),
                                export.getString("category"),
                                export.getString("year"),
                                export.getDouble("transport_cost"),
                                export.getDouble("handling_cost"),
                                export.getDouble("insurance_cost"),
                                export.getDouble("delivery_duty")


                        ));
                    }

                    ExportAdapter adapter = new ExportAdapter(Analytics.this,exportData);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();
                Toast.makeText(Analytics.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        })

{

    protected Map<String, String> getParams() {

        Map<String, String> params = new HashMap<>();

        params.put("Product",Product);
        params.put("Category",Category);
        params.put("Year",Year);

        return params;
            }


}

        ;


        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
}


public void GraphView(View view){



}
}