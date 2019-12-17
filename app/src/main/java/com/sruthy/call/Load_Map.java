package com.sruthy.call;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Load_Map extends AppCompatActivity {
    TextView textView;
SharedPreferences sharedPreferences;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load__map);
        imageView=findViewById(R.id.imageView2);
        image();
        sharedPreferences=getSharedPreferences("number", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("hi",true);
        editor.apply();

        textView = findViewById(R.id.txt);
        ok();
    }
    public void  ok() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://anoopsuvarnan1.000webhostapp.com/fetchlocationapi.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//If we are getting success from server


                        String idd;

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json_obj = jsonArray.getJSONObject(i);
                                idd = json_obj.getString("latitude");
                                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q="+idd));
                                startActivity(intent);
                                // Toast.makeText(Load_Map.this,idd,Toast.LENGTH_SHORT).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


//Creating a shared preference


//Adding values to editor


//Saving values to editor


                        //  Snackbar.make(view,"Login Success",Snackbar.LENGTH_SHORT).show();

//Starting profile activity

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//You can handle error here if you want

                    }

                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
//Adding parameters to request


//returning parameter
                return params;
            }
        };

//Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    public void image()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://dress-metal.000webhostapp.com/fetchimage.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//If we are getting success from server


                        String idd;

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json_obj = jsonArray.getJSONObject(i);
                                idd = json_obj.getString("image");
                                Picasso.get().load("http://dress-metal.000webhostapp.com/uploads/"+idd).into(imageView);
                                // Toast.makeText(Load_Map.this,idd,Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


//Creating a shared preference


//Adding values to editor


//Saving values to editor


                        //  Snackbar.make(view,"Login Success",Snackbar.LENGTH_SHORT).show();

//Starting profile activity

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//You can handle error here if you want

                    }

                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
//Adding parameters to request


//returning parameter
                return params;
            }
        };

//Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.child:
              Intent intent=new Intent(Load_Map.this,Calllog.class);
              startActivity(intent);
                return true;
            case R.id.pic:
                Intent intenti=new Intent(Load_Map.this,Sms.class);
                startActivity(intenti);
                return true;



            default:
                return super.onOptionsItemSelected(item);
        }
    }
}






