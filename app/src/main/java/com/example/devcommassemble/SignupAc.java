package com.example.devcommassemble;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupAc extends AppCompatActivity {

    private TextView loginbtnrd ;
    private Button Signup;
    private EditText name , email , password , confirmPassword;
    private AppCompatButton signup;
    String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.getsbtn);
        confirmPassword = findViewById(R.id.passwordcfn);
        loginbtnrd = findViewById(R.id.loginbtnrd);
        loginbtnrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(SignupAc.this,SigninAc.class);
                startActivity(it);
            }
        });
     Auth = FirebaseAuth.getInstance();

     signup.setEnabled(false);


        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

       password.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               checkInputs();
           }

           @Override
           public void afterTextChanged(Editable editable) {

           }
       });


      confirmPassword.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              checkInputs();
          }

          @Override
          public void afterTextChanged(Editable editable) {

          }
      });



      signup.setOnClickListener(new View.OnClickListener() {
          @Override

          public void onClick(View view) {
              signup.setEnabled(false);
              if(email.getText().toString().trim().matches(emailPattern)){
                  if(password.getText().toString().trim().equals(confirmPassword.getText().toString().trim())){

                      String emaildata = email.getText().toString().trim();
                      String passworddata = password.getText().toString().trim();

                      Auth.createUserWithEmailAndPassword(emaildata , passworddata).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                          @Override
                          public void onComplete(@NonNull Task<AuthResult> task) {

                              if(task.isSuccessful()){

                                 Auth.signInWithEmailAndPassword(emaildata,passworddata).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                     @Override
                                     public void onComplete(@NonNull Task<AuthResult> task) {
                                         if(task.isSuccessful()){

                                             Toast.makeText(SignupAc.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                                             Intent in = new Intent(SignupAc.this,MainActivity.class);
                                             startActivity(in);
                                             finish();
                                         }
                                         else{
                                             Toast.makeText(SignupAc.this,"SignUp Failed " + task.getException().getMessage(),Toast.LENGTH_SHORT ).show();

                                         }



                                     }
                                 });





                              }
                              else{
                                  Toast.makeText(SignupAc.this,"Signup Failed " + task.getException().getMessage(),Toast.LENGTH_SHORT ).show();

                              }

                          }
                      });
















                  }

                  else{

                      confirmPassword.setError("pasd jkcje");
                  }



              }
              else{
                  email.setError("Please Inmsclsclmcl");

                  signup.setEnabled(true);
              }
          }
      });











    }

    private void checkInputs() {

        if(!name.getText().toString().trim().equals("")){

            if(!email.getText().toString().trim().equals("")){

                if(!password.getText().toString().trim().equals("")){

                    if (!confirmPassword.getText().toString().trim().equals("")){

                        if(password.getText().toString().trim().length()>=6){

                            signup.setEnabled(true);

                        }else{
                            password.setError("Please Enter Valid Password!");

                        }
                    }else{
                        confirmPassword.setError("Please Re-enter Password!");

                    }
                }else{
                    password.setError("Please Enter Password!");

                }
            }else{
                email.setError("Please Enter Email!");

            }
        }else{
            name.setError("Please Enter Name!");

        }


    }
}