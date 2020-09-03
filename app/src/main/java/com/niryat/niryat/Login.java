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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    String login_url = "https://wwwtexacom.000webhostapp.com/login.php";
    public static final String KEY_LEMAIL ="lemail";
    public static final String KEY_LPASSWORD ="lpassword";
    private EditText ET_LEMAIL;
    private EditText ET_LPASSWORD;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
    ET_LEMAIL = findViewById(R.id.et_lemail);
    ET_LPASSWORD = findViewById(R.id.et_lpassword);


}
    public void onLogin(View view)

    {
userLogin();
}
public void userLogin(){



    progressDialog.setMessage("please wait.....");
progressDialog.show();
    final String lemail = ET_LEMAIL.getText().toString().trim();
    final String lpassword = ET_LPASSWORD.getText().toString().trim();

    StringRequest stringRequest = new StringRequest(Request.Method.POST, login_url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();


                    try {


                        if (response.trim().equals("success")) {
                            startActivity(new Intent(getApplicationContext(),Home.class));
                            finish();

                            JSONObject obj = new JSONObject(response);
                            SharedPrefManager.getInstance(getApplicationContext()).userLogin(
                                    obj.getString("email"),
                            obj.getString("name"),
                            obj.getString("mobileno")


                            );
                        }
                        else {
                            Toast.makeText(Login.this, response, Toast.LENGTH_LONG).show();

                        }

                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(Login.this,error.toString(), Toast.LENGTH_LONG).show();
                }
            }) {

        protected Map<String, String> getParams()  {
            Map<String,String> map = new HashMap<>();
            map.put(KEY_LEMAIL,lemail);
            map.put(KEY_LPASSWORD,lpassword);
            return map;
        }

    };
RequestHandler.getInstance(this).addToRequestQueue(stringRequest);


}
public void onRegister(View view){

    Intent intent = new Intent(this,Register.class);

    startActivity(intent);

}
    }


