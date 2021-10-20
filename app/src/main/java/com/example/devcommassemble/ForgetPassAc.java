package com.example.devcommassemble;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassAc extends AppCompatActivity {
    private TextView RTtnlogin;
    private AppCompatButton resetBtn;
    private EditText oldEmailEt;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        getSupportActionBar().hide();
        RTtnlogin = findViewById(R.id.RTNLOGIN);
        resetBtn = findViewById(R.id.resetbtn);
        oldEmailEt = findViewById(R.id.oldemailet);

        auth = FirebaseAuth.getInstance();

        RTtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPassAc.this , SigninAc.class);
                startActivity(intent);
            }
        });



        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!oldEmailEt.getText().toString().trim().equals("")){

                    resetBtn.setEnabled(false);
                    String emailDataToReset=oldEmailEt.getText().toString().trim();
                    //Sending Reset Mail To User
                    auth.sendPasswordResetEmail(emailDataToReset).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){

                                Toast.makeText(ForgetPassAc.this, "Email successfully sent to your registered mail, Dont't Forget to check spam folder", Toast.LENGTH_LONG).show();


                            }else{
                                Toast.makeText(ForgetPassAc.this, "Something Went Wrong"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                resetBtn.setEnabled(true);

                            }


                        }
                    });
                    //end


                }else{

                    oldEmailEt.setError("Please Enter Your Registered Email");
                    resetBtn.setEnabled(true);

                }

            }
        });












    }
}