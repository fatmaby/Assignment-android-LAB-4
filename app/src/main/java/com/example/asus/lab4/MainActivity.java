package com.example.asus.lab4;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText eName, eAge;
    TextView tvName, tvAge;
    private static String PREF_NAME="myFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName= (EditText)findViewById(R.id.e_name);
        eAge= (EditText)findViewById(R.id.e_age);

        tvName= (TextView) findViewById(R.id.tv_name);
        tvAge= (TextView) findViewById(R.id.tv_age);

    }

    public void save(View view){
        SharedPreferences.Editor editor= getSharedPreferences(PREF_NAME,MODE_PRIVATE).edit();
        editor.putString("name", eName.getText().toString());
        editor.putInt("age",Integer.valueOf(eAge.getText().toString()));
        editor.commit();

        SharedPreferences pref =getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        tvName.setText(pref.getString("name","no name defined"));
        tvAge.setText("Age:"+pref.getInt("age",0));
    }
}