package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SecondActivity extends AppCompatActivity {

    Button button;
    EditText textToSend;
    String textToSendString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button = findViewById(R.id.set_button);
        textToSend = findViewById(R.id.input_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Instanserar ny intent och hämtar textvärde
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                textToSendString = textToSend.getText().toString();

                // Lägger till extras i intent
                intent.putExtra("text", textToSendString);
                startActivity(intent);
            }
        });
    }
}