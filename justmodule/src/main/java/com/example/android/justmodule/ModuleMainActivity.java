package com.example.android.justmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ModuleMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_main);
        Intent intent = null;
        try {
            intent = new Intent(this,Class.forName("com.example.android.justjava.myMainActivity"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        startActivity(intent);

    }
}
