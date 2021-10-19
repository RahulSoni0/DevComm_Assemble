package com.example.devcommassemble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ForgetPassAc extends AppCompatActivity {
    private TextView RTtnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        RTtnlogin = findViewById(R.id.RTNLOGIN);

        RTtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPassAc.this , SigninAc.class);
                startActivity(intent);
            }
        });
    }
}