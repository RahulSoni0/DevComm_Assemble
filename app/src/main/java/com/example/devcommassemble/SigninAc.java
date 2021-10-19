package com.example.devcommassemble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SigninAc extends AppCompatActivity {
    private TextView forgetpasstv;
    private TextView signuprd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        forgetpasstv  = findViewById(R.id.forgetPasswordTv);
        signuprd = findViewById(R.id.signuprd);
        forgetpasstv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninAc.this,ForgetPassAc.class);
                startActivity(intent);
            }
        });

        signuprd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninAc.this , SignupAc.class);
                startActivity(intent);
            }
        });

    }
}