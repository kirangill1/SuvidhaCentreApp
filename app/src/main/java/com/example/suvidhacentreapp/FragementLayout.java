package com.example.suvidhacentreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FragementLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragement_layout);
    }

    public void statistics(View view) {
        Intent i = new Intent(FragementLayout.this, Statistics.class);
        startActivity(i);
        finish();
    }
}
