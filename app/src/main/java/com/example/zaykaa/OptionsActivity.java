package com.example.zaykaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Button newLoginButton = findViewById(R.id.newLoginButton);
        Button newSignUpButton = findViewById(R.id.newSignUpButton);

        newLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movePage1 = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(movePage1);
            }
        });

        newSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movePage2 = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(movePage2);
            }
        });
    }
}