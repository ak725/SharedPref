package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PrefrenceName = "Mypref";
    private EditText name;
    private EditText value;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(PrefrenceName, Context.MODE_PRIVATE);

        if(sharedPreferences.contains("name") &&
                sharedPreferences.contains("value")){
            startActivity(new Intent(this,Info.class));
            finish();
        }



        this.name = findViewById(R.id.edittext_name);
        value = findViewById(R.id.edittext_value);
        Button submit = findViewById(R.id.button_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input_name = MainActivity.this.name.getText().toString();
                String input_value = value.getText().toString();


                if(!input_name.isEmpty() &&
                        !input_value.isEmpty()){

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", input_name);
                    editor.putString("value", input_value);
                    editor.apply();

                    showText();
                }
            }
        });

    }

    void showText(){
        Toast.makeText(this,"Added successFully",Toast.LENGTH_LONG).show();
        startActivity(new Intent(this,Info.class));
        finish();
    }
}