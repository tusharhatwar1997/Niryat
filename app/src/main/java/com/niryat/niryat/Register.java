package com.niryat.niryat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    String register_url = "https://wwwtexacom.000webhostapp.com/Register.php";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_NAME = "name";
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_PASSWORD = "password";

    private EditText ET_EMAIL;
    private EditText ET_NAME;
    private EditText ET_MOBILE;
    private EditText ET_PASSWORD;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressDialog = new ProgressDialog(this);

        ET_EMAIL = findViewById(R.id.et_email);
        ET_NAME = findViewById(R.id.et_name);
        ET_MOBILE = findViewById(R.id.et_mobile);
        ET_PASSWORD = findViewById(R.id.et_password);


    }


    public void onRegister(View view) {

        final String email = ET_EMAIL.getText().toString().trim();
        final String name = ET_NAME.getText().toString().trim();
        final String mobile = ET_MOBILE.getText().toString().trim();
        final String password = ET_PASSWORD.getText().toString().trim();

        if (!isValidEmail(email)) {
            ET_EMAIL.setError("Invalid Email");
        }

        if (!isValidName(name)) {
            ET_NAME.setError("Invalid Name");
        }

        if (!isValidMobile(mobile)) {
            ET_MOBILE.setError("Invalid Mobile Number");
        }
         if(isValidEmail(email) && isValidName(name) && isValidMobile(mobile)){
            progressDialog.setMessage("Please Wait.....");
            progressDialog.show();


            StringRequest stringRequest = new StringRequest(Request.Method.POST, register_url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();

                            Toast.makeText(Register.this, response, Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),Home.class));
                            finish();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Register.this, error.toString(), Toast.LENGTH_LONG).show();
                        }
                    }) {

                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put(KEY_EMAIL, email);
                    params.put(KEY_NAME, name);
                    params.put(KEY_MOBILE, mobile);
                    params.put(KEY_PASSWORD, password);
                    return params;
                }

            };
            RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

        }
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidName(String name) {
        if (!name.isEmpty()  && name.length()< 15) {
            return true;
        }
return false;
    }

    private boolean isValidMobile(String mobile) {
        if (mobile != null && mobile.length() == 10) {
            return true;
        }
return false;
    }


}
