package com.example.zaykaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailSignUp , usernameSignUp , passwordSignUp;
    private Button signUpButton;
    private DataBaseHelper1 myDB;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailSignUp = findViewById(R.id.signupemail);
        usernameSignUp = findViewById(R.id.signupusername);
        passwordSignUp = findViewById(R.id.siguppassword);

        signUpButton = findViewById(R.id.signupbutton);

        myDB = new DataBaseHelper1(this);
        insertUser();
    }

    private void insertUser(){
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDB.registerUser(usernameSignUp.getText().toString(), emailSignUp.getText().toString(), passwordSignUp.getText().toString());

                if (usernameSignUp.getText().toString().isEmpty() || usernameSignUp.getText().toString().length()<=3){
                    Toast.makeText(SignUpActivity.this, "Username is empty or length of username is less than 4", Toast.LENGTH_LONG).show();
                }
                else if (passwordSignUp.getText().toString().isEmpty() || passwordSignUp.getText().toString().length()<=3) {
                    Toast.makeText(SignUpActivity.this, "Password is empty or length of password is less than 4", Toast.LENGTH_LONG).show();
                }
                else if (emailSignUp.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please enter email", Toast.LENGTH_LONG).show();
                }
                else {
                        if (!emailSignUp.getText().toString().matches(emailPattern)){
                            Toast.makeText(SignUpActivity.this, "enter valid email", Toast.LENGTH_LONG).show();
                        }
                        else{
                            if (var) {
                            Toast.makeText(SignUpActivity.this, "User Registered Successfully !!", Toast.LENGTH_SHORT).show();
                            Intent SignUpIntent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(SignUpIntent);
                            } else
                            {
                                Toast.makeText(SignUpActivity.this, "Registration Error !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

        });
    }
}