package com.example.lesson2_6;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText mail;
    EditText password;
    Button button;
    TextView enter;
    TextView login;
    TextView forgot;
    TextView fgt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = findViewById(R.id.mail);
        password = findViewById(R.id.password);
        button = findViewById(R.id.btn);
        enter = findViewById(R.id.enter);
        login = findViewById(R.id.login);
        forgot = findViewById(R.id.forgot);
        fgt = findViewById(R.id.fgt);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String email = editable.toString();
                if (email.isEmpty()) {
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }
        };

        mail.addTextChangedListener(textWatcher);


        button.setOnClickListener(view -> {
            if (mail.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                Toast toast = Toast.makeText(MainActivity.this, "Добро пожаловать!",
                        Toast.LENGTH_SHORT);
                toast.show();
                onClickAction();

            } else {
                Toast toast = Toast.makeText(MainActivity.this, "Не верный логин или пароль.",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

    private void onClickAction() {
        mail.setVisibility(View.GONE);
        password.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        enter.setVisibility(View.GONE);
        login.setVisibility(View.GONE);
        forgot.setVisibility(View.GONE);
        fgt.setVisibility(View.GONE);
    }


}

