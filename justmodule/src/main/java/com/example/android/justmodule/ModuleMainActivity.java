package com.example.android.justmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ModuleMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_main);
        Intent intent;
        try {
            intent = new Intent(getApplicationContext()x,Class.forName("com.example.android.justjava.MainActivity"));
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.e( "onCreate: ","error in intent" );
        }

    }
}
