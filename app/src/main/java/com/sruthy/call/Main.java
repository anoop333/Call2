package com.sruthy.call;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {
    EditText txt;
    Button btn;
    SharedPreferences sharedPreferences;
    private  boolean loggedin=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mai);
        sharedPreferences=getSharedPreferences("number", Context.MODE_PRIVATE);
        loggedin=sharedPreferences.getBoolean("hi",false);
        txt=findViewById(R.id.phn);
        btn=findViewById(R.id.btn2);
        if (loggedin)
        {
            Intent intent=new Intent(Main.this,Load_Map.class);
            startActivity(intent);
            finish();
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt.getText().toString().isEmpty())
                {
                    txt.setError("Phone number is empty");
                }
                else
                {
                   SharedPreferences.Editor editor=sharedPreferences.edit();
                   editor.putString("num","+91"+txt.getText().toString());
                   editor.apply();
               //    Toast.makeText(Main.this,sharedPreferences.getString("num",null),Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Main.this,Load_Map.class);
                    startActivity(intent);
                }
            }
        });
    }
}

