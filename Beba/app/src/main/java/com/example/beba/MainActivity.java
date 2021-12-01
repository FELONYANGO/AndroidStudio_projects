package com.example.beba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String LOGIN = "com.example.myFirstApp.MESSAGE";
    public static final String SIGN_UP = "com.example.myFirstApp.SIGN IN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void login(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        Button button = (Button) findViewById(R.id.loginButton);
        String message = button.getText().toString();
        intent.putExtra(LOGIN, message);
        startActivity(intent);
    }

    public void signup(View view) {
        Intent intent = new Intent(this, DisplaySignUP.class);
        TextView textView = (TextView) findViewById(R.id.signUp);
        String text = textView.getText().toString();
        intent.putExtra(SIGN_UP, text);
        startActivity(intent);


    }
}