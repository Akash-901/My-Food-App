package com.example.zaykaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText loginUsername , loginPassword;
    private Button loginButton;
    private DataBaseHelper1 myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUsername = findViewById(R.id.loginusername);
        loginPassword = findViewById(R.id.loginpassword);
        loginButton = findViewById(R.id.loginbutton);

        myDb = new DataBaseHelper1(this);

        loginUser();

    }
    private void loginUser(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDb.checkUser(loginUsername.getText().toString() , loginPassword.getText().toString());
                if (loginUsername.getText().toString().isEmpty() || loginUsername.getText().toString().length()<=3){
                    Toast.makeText(LoginActivity.this, "Username is empty or wrong username", Toast.LENGTH_LONG).show();
                }
                else if (loginPassword.getText().toString().isEmpty() || loginPassword.getText().toString().length()<=3) {
                    Toast.makeText(LoginActivity.this, "Password is empty or wrong password", Toast.LENGTH_LONG).show();
                }
               else {
                    if (var){
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this , MainActivity.class));
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}