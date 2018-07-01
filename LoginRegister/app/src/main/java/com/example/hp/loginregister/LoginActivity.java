package com.example.hp.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Storage s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.login);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        s = new Storage(getApplicationContext());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                boolean a = s.check(username.getText().toString(), password.getText().toString());
                if(a) {
                    Intent intent = new Intent(LoginActivity.this, AccountActivity.class);
                    intent.putExtra("Username", username.getText().toString());
                    startActivity(intent);
                }
                else
                {

                        Toast.makeText(LoginActivity.this, "User does not exist", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
