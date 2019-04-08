package com.nstu.www.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText usrnameEditText,passwordEditText;
    private Button loginButton;
    private TextView textView;
    private  int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usrnameEditText=(EditText) findViewById(R.id.usernameId);
        passwordEditText=(EditText)findViewById(R.id.passwordId);
        loginButton=(Button)findViewById(R.id.loginButtonId);
        textView=(TextView)findViewById(R.id.textviewId);
        textView.setText("Number of Attempts Remaining:3");
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=usrnameEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                if(username.equals("admin")&& password.equals("0178")){
                    Intent intent;
                    intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    counter--;
                    textView.setText("Number of Attempts Remaining: "+counter);
                    if(counter==0){
                        loginButton.setEnabled(false);
                    }

                }
            }
        });

    }
}
