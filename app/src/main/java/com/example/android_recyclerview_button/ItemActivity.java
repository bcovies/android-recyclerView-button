package com.example.android_recyclerview_button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        SharedPreferences pref = getSharedPreferences("PASSARTEXTOVIEW", MODE_PRIVATE);
        String textoRecyclerView = pref.getString("STRINGROW", null);

        System.out.println(textoRecyclerView);

        textView = findViewById(R.id.activity_item_textView);

        textView.setText(textoRecyclerView);



    }
}