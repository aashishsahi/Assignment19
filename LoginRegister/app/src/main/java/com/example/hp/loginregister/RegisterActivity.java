package com.example.hp.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Storage s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register = findViewById(R.id.register);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final EditText email = findViewById(R.id.email);
        s = new Storage(getApplicationContext());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s.store(username.getText().toString(), password.getText().toString(), email.getText().toString());
                Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
            }

        });
    }
}
