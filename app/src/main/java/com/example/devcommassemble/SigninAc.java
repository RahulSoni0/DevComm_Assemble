package com.example.devcommassemble;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninAc extends AppCompatActivity {
    private TextView forgetpasstv;
    private TextView signuprd;
    private EditText email , password;
    private AppCompatButton signin;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        getSupportActionBar().hide();
        forgetpasstv  = findViewById(R.id.forgetPasswordTv);
        signuprd = findViewById(R.id.signuprd);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password12);
        signin = findViewById(R.id.loginbtn);
        auth = FirebaseAuth.getInstance();
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
                Intent intent = new Intent(SigninAc.this,SignupAc.class);
                startActivity(intent);
            }
        });



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!email.getText().toString().trim().equals("")){
                    if(!password.getText().toString().trim().equals("")){

                        signin.setEnabled(false);



                        //FireBase Auth
                        String emailDataLog = email.getText().toString().trim();
                        String passDataLog = password.getText().toString().trim();
                        auth.signInWithEmailAndPassword(emailDataLog,passDataLog).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){

                                    Intent log=new Intent(SigninAc.this, MainActivity.class);
                                    startActivity(log);
                                    finish();

                                }else{

                                    Toast.makeText(SigninAc.this, "Invalid"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    signin.setEnabled(true);
                                }
                            }
                        });
                    }else{
                        password.setError("Please Enter Password");
                    }
                }else{
                    email.setError("Please Enter Email");
                }
            }
        });
        //end



    }








}