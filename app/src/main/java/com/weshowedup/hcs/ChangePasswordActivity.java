package com.weshowedup.hcs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class ChangePasswordActivity extends AppCompatActivity {

    TextInputEditText password,password2;
    Button button;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        if (getSupportActionBar()!=null)
            getSupportActionBar().hide();
        password=findViewById(R.id.change_pass);
        password2=findViewById(R.id.change_pass2);
        button=findViewById(R.id.change_btn);
        progressBar=findViewById(R.id.change_progressbar);

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
                if (String.valueOf(password.getText()).trim().length()<8 ||
                        String.valueOf(password2.getText()).trim().length()<8)
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
        password.addTextChangedListener(textWatcher);
        password2.addTextChangedListener(textWatcher);
        button.setEnabled(false);
        button.setBackgroundColor(Color.parseColor("#A3434343"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(getWindow().getDecorView(),"Change Password",Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
