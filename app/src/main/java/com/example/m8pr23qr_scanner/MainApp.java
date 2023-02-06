package com.example.m8pr23qr_scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainApp extends AppCompatActivity {
    int CODE = 1;
    TextView textView;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.resultText);
        button = findViewById(R.id.button2);

        button.setOnClickListener((clicked) -> {
            Intent intent = new Intent(this, Scanner.class);
            startActivityForResult(intent, CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");
                textView.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                // Write your code if there's no result
            }
        }
    } //onActivityResult
}