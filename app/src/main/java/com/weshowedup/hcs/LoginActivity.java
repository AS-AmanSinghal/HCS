package com.weshowedup.hcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText email,password;
    RadioButton remember_me;
    TextView forgotPassword,signup;
    Button button;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (getSupportActionBar()!=null)
            getSupportActionBar().hide();
        email=findViewById(R.id.login_email);
        password=findViewById(R.id.login_password);
        remember_me=findViewById(R.id.remember_me);
        forgotPassword=findViewById(R.id.forgot_password);
        signup=findViewById(R.id.signUp);
        button=findViewById(R.id.login_btn);
        progressBar=findViewById(R.id.login_progressBar);

        TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if (!String.valueOf(email.getText()).trim().contains("@") || !String.valueOf(email.getText()).trim().contains(".")
                        || String.valueOf(password.getText()).trim().isEmpty())
                {
                    button.setEnabled(false);
                    button.setBackgroundColor(Color.parseColor("#A3434343"));
                }
                else
                {
                    button.setEnabled(true);
                    button.setBackgroundResource(R.drawable.button_background);
                }
            }
        };
        email.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        button.setEnabled(false);
        button.setBackgroundColor(Color.parseColor("#A3434343"));

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotActivity.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(getWindow().getDecorView(),"BUTTON LOGIN",Snackbar.LENGTH_SHORT).show();
            }
        });

    }
}
