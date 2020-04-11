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

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText name,email,mobile,password,confirm_password;
    Button button;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        if (getSupportActionBar()!=null)
            getSupportActionBar().hide();

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        mobile=findViewById(R.id.mobile);
        password=findViewById(R.id.password);
        confirm_password=findViewById(R.id.confirm_password);
        button=findViewById(R.id.signup_btn);
        progressBar=findViewById(R.id.signup_progressbar);

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
                if (String.valueOf(name.getText()).trim().isEmpty() || !String.valueOf(email.getText()).trim().contains("@") ||
                        !String.valueOf(email.getText()).trim().contains(".") ||
                        String.valueOf(password.getText()).trim().length()<8 ||
                        String.valueOf(confirm_password.getText()).trim().length()<8 ||
                        String.valueOf(mobile.getText()).trim().length()!=10
                )
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

        name.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);
        mobile.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        confirm_password.addTextChangedListener(textWatcher);
        button.setEnabled(false);
        button.setBackgroundColor(Color.parseColor("#A3434343"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(password.getText()).trim().equals(String.valueOf(confirm_password.getText()).trim()))
                {
                    Intent intent=new Intent(SignUpActivity.this,VerificationActivity.class);
                    intent.putExtra("change","2");
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Snackbar.make(getWindow().getDecorView(),"Password Does not Match",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
