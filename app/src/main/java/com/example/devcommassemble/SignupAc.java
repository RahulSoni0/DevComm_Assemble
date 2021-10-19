package com.example.devcommassemble;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupAc extends AppCompatActivity {

    private TextView loginbtnrd ;
    private Button Signup;
    private EditText name , email , password , confirmpassword;
    private AppCompatButton signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.passwordcfn);
        loginbtnrd = findViewById(R.id.loginbtnrd);
        loginbtnrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(SignupAc.this,SigninAc.class);
                startActivity(it);
            }
        });
    }
}