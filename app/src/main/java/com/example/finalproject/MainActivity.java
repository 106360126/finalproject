package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.taichung).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String City = "taichung";
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("City",City);
                startActivity(intent);
            }
        });
        findViewById(R.id.taipei).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String City = "taipei";
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("City",City);
                startActivity(intent);
            }
        });
        findViewById(R.id.tainan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String City = "tainan";
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("City",City);
                startActivity(intent);
            }
        });
        findViewById(R.id.pingtung).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String City = "pingtung";
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("City",City);
                startActivity(intent);
            }
        });
        findViewById(R.id.kaohsiung).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String City = "kaohsiung";
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("City",City);
                startActivity(intent);
            }
        });
        findViewById(R.id.taitung).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String City = "taitung";
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("City",City);
                startActivity(intent);
            }
        });
    }
}
