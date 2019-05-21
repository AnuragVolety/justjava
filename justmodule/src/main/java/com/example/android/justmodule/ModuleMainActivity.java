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
        Log.e("onCreate: ","In module, on the way to main activity" );
        Intent i =new Intent();
        i.setAction("android.intent.action.VIEW");
        startActivity(i);
    }
}
