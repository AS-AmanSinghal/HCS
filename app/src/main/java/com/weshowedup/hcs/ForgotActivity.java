package com.weshowedup.hcs;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class ForgotActivity extends AppCompatActivity {

    TextInputEditText email;
    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        if (getSupportActionBar()!=null)
            getSupportActionBar().hide();
        email = findViewById(R.id.forgot_email);
        button = findViewById(R.id.forgot_btn);
        progressBar = findViewById(R.id.forgot_progressbar);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!String.valueOf(email.getText()).trim().contains("@") ||
                        !String.valueOf(email.getText()).trim().contains(".")) {
                    button.setEnabled(false);
                    button.setBackgroundColor(Color.parseColor("#A3434343"));
                } else {
                    button.setEnabled(true);
                    button.setBackgroundResource(R.drawable.button_background);
                }
            }
        };
        email.addTextChangedListener(textWatcher);
        button.setEnabled(false);
        button.setBackgroundColor(Color.parseColor("#A3434343"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgotActivity.this,VerificationActivity.class);
                intent.putExtra("change","1");
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
