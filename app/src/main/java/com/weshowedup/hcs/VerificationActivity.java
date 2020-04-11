package com.weshowedup.hcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class VerificationActivity extends AppCompatActivity {

    TextInputEditText otp;
    TextView resendOtp;
    Button button;
    ProgressBar progressBar;
    public int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        if (getSupportActionBar()!=null)
            getSupportActionBar().hide();
        otp=findViewById(R.id.verification);
        resendOtp=findViewById(R.id.resendOtp);
        button=findViewById(R.id.verification_btn);
        progressBar=findViewById(R.id.verification_progressbar);
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
                if (String.valueOf(otp.getText()).trim().length()!=6){
                    button.setEnabled(false);
                    button.setBackgroundColor(Color.parseColor("#A3434343"));}
                else
                {
                    button.setEnabled(true);
                    button.setBackgroundResource(R.drawable.button_background);
                }
            }
        };

        otp.addTextChangedListener(textWatcher);
        button.setEnabled(false);
        button.setBackgroundColor(Color.parseColor("#A3434343"));
        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                resendOtp.setEnabled(false);
                resendOtp.setTextColor(Color.RED);
                resendOtp.setText("00:" + String.valueOf(counter));
                counter++;
            }

            @Override
            public void onFinish() {
                resendOtp.setText("Resend OTP");
                resendOtp.setTextColor(Color.BLACK);
                resendOtp.setEnabled(true);
            }
        }.start();
        resendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(getWindow().getDecorView(),"Resend OTP",Snackbar.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getIntent().getStringExtra("change").equals("1"))
                {
                    startActivity(new Intent(VerificationActivity.this,ChangePasswordActivity.class));
                    finish();
                }
                else
                {
                    Snackbar.make(getWindow().getDecorView(),"Verification BUTTON",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
