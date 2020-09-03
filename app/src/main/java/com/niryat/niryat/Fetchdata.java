package com.niryat.niryat;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class Fetchdata extends AppCompatActivity {
    String fetch_url = "https://wwwtexacom.000webhostapp.com/fetch.php";
    private ProgressDialog progressDialog;
TextView tv_name,tv_email;
String name ="Vedant";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata);

        progressDialog = new ProgressDialog(this);

        tv_name=findViewById(R.id.tv_name);

        Toast.makeText(Fetchdata.this, name, LENGTH_SHORT).show();

    }

    public void Fetch(View view) {
        progressDialog.setMessage("please wait.....");
        progressDialog.show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, fetch_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        try {

                            tv_email.setText(response.getString("emailid"));
                          tv_name.setText(response.getString("name"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(Fetchdata.this, error.toString(), Toast.LENGTH_LONG).show();            }
        })


        {

            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();



                params.put("name",name);




                return params;
            }


        }
                ;







        RequestHandler.getInstance(this).addToRequestQueue(jsonObjectRequest);

    }




}
